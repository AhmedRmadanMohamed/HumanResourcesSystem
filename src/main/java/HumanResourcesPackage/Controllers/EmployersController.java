package HumanResourcesPackage.Controllers;

import HumanResourcesPackage.DTOs.SingleDTOs.EmployersDTO;
import HumanResourcesPackage.OperationsImplementation.ImplementCRUD.GetAll;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;


@RestController
public class EmployersController {
    private final GetAll<EmployersDTO> getAll;

    public EmployersController(GetAll<EmployersDTO> getAll) {
        this.getAll = getAll;
    }

    @GetMapping("/GetAllEmploye")

    public ResponseEntity<List<EmployersDTO>> getEmployers() {
        return new ResponseEntity<>(getAll.GetAll(), OK);
    }
}
