package HumanResourcesPackage.Controllers;

import HumanResourcesPackage.DTOs.JoinsEntitys.UserInformationDTO;
import HumanResourcesPackage.OperationsImplementation.ImplementCRUD.GenericReadBy;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/UsersInformation")
@CrossOrigin("*")
public class UsersInformationController {
    private final GenericReadBy<UserInformationDTO, String> GenericReadBy;

        GenericReadBy = genericReadBy;
    }

    @GetMapping("/GetAllUsersInformation")
    public ResponseEntity<?> getAllUsersInformation() {
    }

    @GetMapping("/GetInformationUserOfRoleName")
    public ResponseEntity<?> getAllUsersInformationByRoleNme(@RequestParam String RoleName) {
        return new ResponseEntity<>(GenericReadBy.GetBy(RoleName), HttpStatus.OK);
    }
}
