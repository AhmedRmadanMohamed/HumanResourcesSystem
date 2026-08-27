package HumanResourcesPackage.Controllers;

import HumanResourcesPackage.DTOs.SingleDTOs.JobPositionDTO;
import HumanResourcesPackage.OperationsImplementation.ImplementCRUD.GenericCreate;
import HumanResourcesPackage.OperationsImplementation.ImplementCRUD.GetAll;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;


/**
 * Exposes endpoints for managing job positions.
 */
@RestController
@RequestMapping("/JobPosition")
@CrossOrigin("*")
public class JobPositionController {
    private final GetAll<JobPositionDTO> getAll;
    private final GenericCreate<JobPositionDTO> genericCreate;

    /**
     * Creates the controller with job position read and create operations.
     *
     * @param getAll operation used to retrieve job positions
     * @param genericCreate operation used to create job positions
     */
    public JobPositionController(GetAll<JobPositionDTO> getAll,
                                 GenericCreate<JobPositionDTO> genericCreate) {
        this.getAll = getAll;
        this.genericCreate = genericCreate;
    }

    /**
     * Returns all job positions.
     *
     * @return an HTTP 200 response containing all job positions
     */
    @GetMapping("/GetAllPosition")
    public ResponseEntity<List<JobPositionDTO>> getAllJobPosition() {
        return new ResponseEntity<>(getAll.GetAll(), OK);
    }

    /**
     * Creates the provided job positions.
     *
     * @param jobPositions job positions to create
     * @return an HTTP 201 response with saved positions, or HTTP 400 when the request is empty
     */
    @PostMapping("/Add")
    public ResponseEntity<List<JobPositionDTO>> addNewJobPosition(@RequestBody List<JobPositionDTO> jobPositions) {
        if (jobPositions == null || jobPositions.isEmpty()) return new ResponseEntity<>(BAD_REQUEST);
        return new ResponseEntity<>(genericCreate.AddAll(jobPositions), CREATED);
    }
}
