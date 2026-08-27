package HumanResourcesPackage.OperationsImplementation.EntitysImp;

import HumanResourcesPackage.DTOs.request.CreateEmployeeRequest;
import HumanResourcesPackage.DTOs.response.EmployeeResponse;

import java.util.Optional;

public interface EmployeeServiceImpl {

    /**
     * Creates an employee using the provided request data.
     *
     * @param request the employee data to create
     * @return the created employee details
     */
    EmployeeResponse CreateEmployee(CreateEmployeeRequest request);

    Optional<EmployeeResponse> GetEmployeeOnCompany(Long employeeId,
                                                    Long companyId,
                                                    Long tenantId);


}
