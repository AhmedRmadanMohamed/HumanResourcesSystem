package HumanResourcesPackage.Mappers;

import HumanResourcesPackage.DTOs.SingleDTOs.EmployersDTO;
import HumanResourcesPackage.Entitys.EmployersEntity;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
@Builder
public class EmployersMapper {

    public EmployersDTO mapEmployersDTO(EmployersEntity employersEntity) {
        return EmployersDTO.builder().id(employersEntity.getId())
                .phone(employersEntity.getPhone()).jobsEntities(employersEntity.
                        getJobsEntities()).usersEntity(employersEntity.getUsersEntity())
                .companyName(employersEntity.getCompanyName()).website(employersEntity.getWebsite())
                .build();

    }


    public EmployersEntity mapEmployersEntity(EmployersDTO employersDTO) {
        return EmployersEntity.builder().id(employersDTO.id()).Phone(employersDTO.phone()).
                JobsEntities(employersDTO.jobsEntities()).usersEntity(employersDTO.usersEntity()).
                CompanyName(employersDTO.companyName()).Website(employersDTO.website()).build();
    }

}
