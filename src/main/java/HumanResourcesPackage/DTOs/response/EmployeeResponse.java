package HumanResourcesPackage.DTOs.response;

import HumanResourcesPackage.Constants.EmployeeStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record EmployeeResponse(
        Long id,
        Long tenantId,
        Long companyId,
        String employeeCode,
        String firstName,
        String middleName,
        String lastName,
        String email,
        String phone,
        LocalDate hireDate,
        EmployeeStatus status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt

) {
}