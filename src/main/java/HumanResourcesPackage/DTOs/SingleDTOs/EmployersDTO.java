package HumanResourcesPackage.DTOs.SingleDTOs;

import lombok.Builder;

@Builder
public record EmployersDTO(
        Long id,
        String companyName,
        String website,
        String phone,
        Integer userId
) {
}
