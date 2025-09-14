package HumanResourcesPackage.DTOs.SingleDTOs;

import HumanResourcesPackage.Entitys.JobsEntity;
import HumanResourcesPackage.Entitys.UsersEntity;
import lombok.Builder;

import java.util.List;

@Builder
public record EmployersDTO(
        Long id,
        String companyName,
        String website,
        String phone,
        UsersEntity usersEntity,
        List<JobsEntity> jobsEntities
) {
}
