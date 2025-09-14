package HumanResourcesPackage.Controllers;

import HumanResourcesPackage.DTOs.SingleDTOs.JobPositionDTO;
import HumanResourcesPackage.OperationsImplementation.ImplementCRUD.GenericCreate;
import HumanResourcesPackage.OperationsImplementation.ImplementCRUD.GenericRead;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;


@RestController
@RequestMapping("/JobPosition")
@CrossOrigin("*")
public class JobPositionController {
    private final GenericRead<JobPositionDTO> GenericRead;
    private final GenericCreate<JobPositionDTO> GenericCreate;

    public JobPositionController(GenericRead<JobPositionDTO> GenericRead, GenericCreate<JobPositionDTO> genericCreate) {
        this.GenericRead = GenericRead;
        GenericCreate = genericCreate;
    }

    @GetMapping("/GetAllPosition")
    public ResponseEntity<?> getAllJobPosition() {

        return new ResponseEntity<>(GenericRead.GetAll(), CREATED);
    }

    @PostMapping("/Add")
    public ResponseEntity<List<JobPositionDTO>> addNewJobPosition(@RequestBody List<JobPositionDTO> jobPositions) {
        if (jobPositions == null || jobPositions.isEmpty()) return new ResponseEntity<>(BAD_REQUEST);
        return new ResponseEntity<>(GenericCreate.AddAll(jobPositions), CREATED);
    }


}
