package HumanResourcesPackage.Controllers;

import HumanResourcesPackage.DTOs.SingleDTOs.JobPositionDTO;
import HumanResourcesPackage.OperationsImplementation.ImplementCRUD.GetAll;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.*;


@RestController
public class EmployersController {


    private final GetAll<JobPositionDTO> GetAll;

    public EmployersController(GetAll<JobPositionDTO> getAll) {
        GetAll = getAll;
    }

    @GetMapping("/GetAllEmploye")

    public ResponseEntity<?> getEmployers() {

        return new ResponseEntity<>(GetAll.GetAll(), OK);
    }





}
