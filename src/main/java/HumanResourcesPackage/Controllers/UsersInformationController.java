package HumanResourcesPackage.Controllers;

import HumanResourcesPackage.DTOs.JoinsEntitys.UserInformationDTO;
import HumanResourcesPackage.OperationsImplementation.ImplementCRUD.GenericReadBy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/UsersInformation")
@CrossOrigin("*")
public class UsersInformationController {

    private final GenericReadBy<UserInformationDTO, String> genericReadBy;

    public UsersInformationController(
            GenericReadBy<UserInformationDTO, String> enericReadBy) {
        this.genericReadBy = enericReadBy;
    }

    @GetMapping("/GetInformationUserOfRoleName")
    public ResponseEntity<?> getAllUsersInformationByRoleName(
            @RequestParam String roleName) {

        return new ResponseEntity<>(
                genericReadBy.GetBy(roleName),
                HttpStatus.OK
        );
    }
}