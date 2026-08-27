package HumanResourcesPackage.Controllers;

import HumanResourcesPackage.DTOs.SingleDTOs.EmployersDTO;
import HumanResourcesPackage.OperationsImplementation.ImplementCRUD.GetAll;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;


/**
 * Exposes endpoints for employer data.
 */
@RestController
public class EmployersController {
    private final GetAll<EmployersDTO> getAll;

    /**
     * Creates the controller with the employer retrieval operation.
     *
     * @param getAll operation used to retrieve employers
     */
    public EmployersController(GetAll<EmployersDTO> getAll) {
        this.getAll = getAll;
    }

    /**
     * Returns all employers.
     *
     * @return an HTTP 200 response containing all employers
     */
    @GetMapping("/GetAllEmploye")
    public ResponseEntity<List<EmployersDTO>> getEmployers() {
        return new ResponseEntity<>(getAll.GetAll(), OK);
    }
}
