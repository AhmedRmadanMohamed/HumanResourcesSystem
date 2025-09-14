package HumanResourcesPackage.Controllers;

import HumanResourcesPackage.DTOs.JoinsEntitys.UserInformationDTO;
import HumanResourcesPackage.OperationsImplementation.ImplementCRUD.GenericRead;
import HumanResourcesPackage.OperationsImplementation.ImplementCRUD.GenericReadBy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/UsersInformation")
@CrossOrigin("*")
public class UsersInformationController {
    private final GenericRead<UserInformationDTO> GenericRead;
    private final GenericReadBy<UserInformationDTO, String> GenericReadBy;

    public UsersInformationController(GenericRead<UserInformationDTO> genericRead, GenericReadBy<UserInformationDTO, String> genericReadBy) {
        GenericRead = genericRead;
        GenericReadBy = genericReadBy;
    }

    @GetMapping("/GetAllUsersInformation")
    public ResponseEntity<?> getAllUsersInformation() {
        return new ResponseEntity<>(GenericRead.GetAll(), HttpStatus.OK);
    }

    @GetMapping("/GetInformationUserOfRoleName")
    public ResponseEntity<?> getAllUsersInformationByRoleNme(@RequestParam String RoleName) {
        return new ResponseEntity<>(GenericReadBy.GetBy(RoleName), HttpStatus.OK);
    }
}
