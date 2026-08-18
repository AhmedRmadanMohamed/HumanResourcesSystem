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


@RestController
@RequestMapping("/JobPosition")
@CrossOrigin("*")
public class JobPositionController {
    private final GetAll<JobPositionDTO> getAll;
    private final GenericCreate<JobPositionDTO> genericCreate;

    public JobPositionController(GetAll<JobPositionDTO> getAll,
                                 GenericCreate<JobPositionDTO> genericCreate) {
        this.getAll = getAll;
        this.genericCreate = genericCreate;
    }

    @GetMapping("/GetAllPosition")
    public ResponseEntity<List<JobPositionDTO>> getAllJobPosition() {
        return new ResponseEntity<>(getAll.GetAll(), OK);
    }

    @PostMapping("/Add")
    public ResponseEntity<List<JobPositionDTO>> addNewJobPosition(@RequestBody List<JobPositionDTO> jobPositions) {
        if (jobPositions == null || jobPositions.isEmpty()) return new ResponseEntity<>(BAD_REQUEST);
        return new ResponseEntity<>(genericCreate.AddAll(jobPositions), CREATED);
    }
}
