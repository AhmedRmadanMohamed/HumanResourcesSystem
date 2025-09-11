package HumanResourcesPackage.Controllers;

import HumanResourcesPackage.DTOs.JobPositionDTO;
import HumanResourcesPackage.Implementation.JobPositionCRUD;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;


@RestController
@RequestMapping("/JobPosition")
@CrossOrigin("*")
public class JobPositionController {
    private final JobPositionCRUD jobPositionCRUD;

    public JobPositionController(JobPositionCRUD jobPositionCRUD) {
        this.jobPositionCRUD = jobPositionCRUD;
    }

    @GetMapping("/GetAllPosition")
    public ResponseEntity<?> getAllJobPosition() {

        return new ResponseEntity<>(jobPositionCRUD.getJobPositions(), CREATED);
    }

    @PostMapping("/Add")
    public ResponseEntity<List<JobPositionDTO>> addNewJobPosition(@RequestBody List<JobPositionDTO> jobPositions) {
        if (jobPositions == null || jobPositions.isEmpty()) return new ResponseEntity<>(BAD_REQUEST);
        return new ResponseEntity<>(jobPositionCRUD.AddNewPosition(jobPositions), CREATED);
    }


}
