package HumanResourcesPackage.Mappers;


import HumanResourcesPackage.DTOs.request.CreateEmployeeRequest;
import HumanResourcesPackage.DTOs.response.EmployeeResponse;
import HumanResourcesPackage.Entitys.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring" ,   unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface EmployeeMapper {
    /**
     * Converts an employee creation request into a new employee entity.
     *
     * @param request the employee data to convert
     * @return the mapped employee entity
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tenant", ignore = true)
    @Mapping(target = "company", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "employments", ignore = true)
    EmployeeEntity toEntity(CreateEmployeeRequest request);


    /**
     * Converts an employee entity into its response representation.
     *
     * @param employee the entity to convert
     * @return the mapped employee response
     */
    @Mapping(source = "tenant.id", target = "tenantId")
    @Mapping(source = "company.id", target = "companyId")
    EmployeeResponse toResponse(EmployeeEntity employee);
}
