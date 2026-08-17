package HumanResourcesPackage.Controllers;

import HumanResourcesPackage.DTOs.JobPositionDTO;
import HumanResourcesPackage.OperationsImplementation.ImplementCRUD.GenericCRUD;
import HumanResourcesPackage.Services.ImplementationOfServices.JobPositionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;


@RestController
@RequestMapping("/JobPosition")
@CrossOrigin("*")
public class JobPositionController {
    private final GenericCRUD GenericCRUD;

    private final JobPositionService Jobpositionservice;

    public JobPositionController(GenericCRUD GenericCRUD, JobPositionService jobpositionservice) {
        this.GenericCRUD = GenericCRUD;
        Jobpositionservice = jobpositionservice;
    }

    @GetMapping("/GetAllPosition")
    public ResponseEntity<?> getAllJobPosition() {

        return new ResponseEntity<>(Jobpositionservice.jobPositionImplementationCRUD.getJobPositions(), CREATED);
    }

    @PostMapping("/Add")
    public ResponseEntity<List<JobPositionDTO>> addNewJobPosition(@RequestBody List<JobPositionDTO> jobPositions) {
        if (jobPositions == null || jobPositions.isEmpty()) return new ResponseEntity<>(BAD_REQUEST);
        return new ResponseEntity<>(GenericCRUD.AddNewPosition(jobPositions), CREATED);
    }


}
