package HumanResourcesPackage.DTOs.request;


import java.time.LocalDate;


public record CreateEmployeeRequest(


        Long tenantId,

        Long companyId,

        String employeeCode,

        String firstName,

        String middleName,

        String lastName,

        String email,

        String phone,

        LocalDate hireDate


) {

}

