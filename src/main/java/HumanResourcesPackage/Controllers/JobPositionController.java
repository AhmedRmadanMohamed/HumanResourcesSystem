package HumanResourcesPackage.Controllers;

import HumanResourcesPackage.DTOs.SingleDTOs.JobPositionDTO;
import HumanResourcesPackage.OperationsImplementation.ImplementCRUD.GenericCreate;
import HumanResourcesPackage.OperationsImplementation.ImplementCRUD.GetAll;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;


@RestController
@RequestMapping("/JobPosition")
@CrossOrigin("*")
public class JobPositionController {
    private final GetAll<JobPositionDTO> GetAll;
    private final GenericCreate<JobPositionDTO> GenericCreate;

    public JobPositionController(GetAll<JobPositionDTO> GetAll, GenericCreate<JobPositionDTO> genericCreate) {
        this.GetAll = GetAll;
        GenericCreate = genericCreate;
    }

    @GetMapping("/GetAllPosition")
    public ResponseEntity<?> getAllJobPosition() {

        return new ResponseEntity<>(GetAll.GetAll(), OK);
    }

    @PostMapping("/Add")
    public ResponseEntity<List<JobPositionDTO>> addNewJobPosition(@RequestBody List<JobPositionDTO> jobPositions) {
        if (jobPositions == null || jobPositions.isEmpty()) return new ResponseEntity<>(BAD_REQUEST);
        return new ResponseEntity<>(GenericCreate.AddAll(jobPositions), CREATED);
    }


}    
