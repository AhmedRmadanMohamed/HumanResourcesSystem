package HumanResourcesPackage.Mappers;

import HumanResourcesPackage.DTOs.SingleDTOs.EmployersDTO;
import HumanResourcesPackage.Entitys.EmployersEntity;
import org.springframework.stereotype.Component;

@Component
public class EmployersMapper {

    public EmployersDTO mapEmployersDTO(EmployersEntity employersEntity) {
        Integer userId = employersEntity.getUsersEntity() == null
                ? null
                : employersEntity.getUsersEntity().getId();

        return EmployersDTO.builder()
                .id(employersEntity.getId())
                .phone(employersEntity.getPhone())
                .userId(userId)
                .companyName(employersEntity.getCompanyName())
                .website(employersEntity.getWebsite())
                .build();
    }
}
