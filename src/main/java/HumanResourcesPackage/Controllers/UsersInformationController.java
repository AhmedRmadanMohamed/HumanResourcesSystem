package HumanResourcesPackage.Controllers;

import HumanResourcesPackage.DTOs.JoinsEntitys.UserInformationDTO;
import HumanResourcesPackage.OperationsImplementation.ImplementCRUD.GetAll;
import HumanResourcesPackage.OperationsImplementation.ImplementCRUD.GenericReadBy;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/UsersInformation")
@CrossOrigin("*")
public class UsersInformationController {
    private final GetAll<UserInformationDTO> GetAll;
    private final GenericReadBy<UserInformationDTO, String> GenericReadBy;

    public UsersInformationController(GetAll<UserInformationDTO> getAll, GenericReadBy<UserInformationDTO, String> genericReadBy) {
        GetAll = getAll;
        GenericReadBy = genericReadBy;
    }

    @GetMapping("/GetAllUsersInformation")
    public ResponseEntity<?> getAllUsersInformation() {
        return new ResponseEntity<>(GetAll.GetAll(), HttpStatus.OK);
    }

    @GetMapping("/GetInformationUserOfRoleName")
    public ResponseEntity<?> getAllUsersInformationByRoleNme(@RequestParam String RoleName) {
        return new ResponseEntity<>(GenericReadBy.GetBy(RoleName), HttpStatus.OK);
    }
}
