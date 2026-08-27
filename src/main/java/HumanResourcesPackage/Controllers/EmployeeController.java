package HumanResourcesPackage.Controllers;


import HumanResourcesPackage.DTOs.request.CreateEmployeeRequest;
import HumanResourcesPackage.DTOs.response.EmployeeResponse;
import HumanResourcesPackage.OperationsImplementation.EntitysImp.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
@CrossOrigin("*")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    @PostMapping
    public ResponseEntity <EmployeeResponse> AddNewEmployee(@RequestBody CreateEmployeeRequest request) {

        return new  ResponseEntity<>(employeeService.CreateEmployee(request), HttpStatus.CREATED);
    }

    @GetMapping("/employees/{employeeId}/company/{companyId}/tenant/{tenantId}")

    public ResponseEntity<Optional<EmployeeResponse>> getEmployeeByEmployeeId(@PathVariable Long employeeId, @PathVariable Long companyId , @PathVariable Long tenantId) {


        return new ResponseEntity<>(employeeService.GetEmployeeOnCompany(employeeId , companyId , tenantId) , HttpStatus.OK);
    }

}
