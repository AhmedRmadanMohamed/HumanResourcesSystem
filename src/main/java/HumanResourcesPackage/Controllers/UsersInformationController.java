package HumanResourcesPackage.Controllers;

import HumanResourcesPackage.DTOs.JoinsEntitys.UserInformationDTO;
import HumanResourcesPackage.OperationsImplementation.ImplementCRUD.GenericReadBy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Exposes endpoints for querying user information.
 */
@RestController
@RequestMapping("/UsersInformation")
@CrossOrigin("*")
public class UsersInformationController {

    private final GenericReadBy<UserInformationDTO, String> genericReadBy;

    /**
     * Creates the controller with the role-based user lookup operation.
     *
     * @param enericReadBy operation used to retrieve users by role
     */
    public UsersInformationController(
            GenericReadBy<UserInformationDTO, String> enericReadBy) {
        this.genericReadBy = enericReadBy;
    }

    /**
     * Returns user information for the specified role.
     *
     * @param roleName role used to filter users
     * @return an HTTP 200 response containing matching user information
     */
    @GetMapping("/GetInformationUserOfRoleName")
    public ResponseEntity<?> getAllUsersInformationByRoleName(
            @RequestParam String roleName) {

        return new ResponseEntity<>(
                genericReadBy.GetBy(roleName),
                HttpStatus.OK
        );
    }
}
