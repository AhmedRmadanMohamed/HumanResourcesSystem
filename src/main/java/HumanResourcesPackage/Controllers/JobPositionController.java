package HumanResourcesPackage.Controllers;

import HumanResourcesPackage.Implementation.JobPositionCRUD;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/JobPosition")
@CrossOrigin("*")
public class JobPositionController {

    private final JobPositionCRUD jobPositionCRUD;
    public JobPositionController(JobPositionCRUD jobPositionCRUD) {
        this.jobPositionCRUD = jobPositionCRUD;
    }

    @GetMapping("/GitAllPosition")
    public ResponseEntity<?> getAllJobPosition() {
        return new ResponseEntity<>(jobPositionCRUD.getJobPositions(), HttpStatus.OK);
    }

}
