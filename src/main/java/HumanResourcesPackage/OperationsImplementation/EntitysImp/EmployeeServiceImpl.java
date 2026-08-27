package HumanResourcesPackage.OperationsImplementation.EntitysImp;

import HumanResourcesPackage.DTOs.request.CreateEmployeeRequest;
import HumanResourcesPackage.DTOs.response.EmployeeResponse;

public interface EmployeeServiceImpl {

    /**
     * Creates an employee using the provided request data.
     *
     * @param request the employee data to create
     * @return the created employee details
     */
    EmployeeResponse CreateEmployee (CreateEmployeeRequest request);
}
