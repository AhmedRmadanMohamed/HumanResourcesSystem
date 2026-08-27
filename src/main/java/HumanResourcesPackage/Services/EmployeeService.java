package HumanResourcesPackage.Services;

import HumanResourcesPackage.Constants.EmployeeStatus;
import HumanResourcesPackage.DTOs.request.CreateEmployeeRequest;
import HumanResourcesPackage.DTOs.response.EmployeeResponse;
import HumanResourcesPackage.Entitys.CompaniesEntity;
import HumanResourcesPackage.Entitys.EmployeeEntity;
import HumanResourcesPackage.Mappers.EmployeeMapper;
import HumanResourcesPackage.OperationsImplementation.EntitysImp.EmployeeServiceImpl;
import HumanResourcesPackage.Repositorys.CompanyRepository;
import HumanResourcesPackage.Repositorys.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Handles employee creation operations.
 */
@Service
@RequiredArgsConstructor
public class EmployeeService implements EmployeeServiceImpl {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final CompanyRepository companyRepository;

    /**
     * Creates an employee and assigns it to a company in the requested tenant.
     *
     * @param request data required to create the employee
     * @return the created employee details
     * @throws java.util.NoSuchElementException if the company is not found for the tenant
     */
    @Transactional
    @Override
    public EmployeeResponse CreateEmployee(CreateEmployeeRequest request) {
        CompaniesEntity companies = companyRepository.findByIdAndTenant_Id(request.companyId(), request.tenantId()).orElseThrow();
        EmployeeEntity employeeEntity = employeeMapper.toEntity(request);
        employeeEntity.setCompany(companies);
        employeeEntity.setTenant(companies.getTenant());
        employeeEntity.setStatus(EmployeeStatus.ACTIVE);
        return employeeMapper.toResponse(employeeRepository.save(employeeEntity));
    }
}
