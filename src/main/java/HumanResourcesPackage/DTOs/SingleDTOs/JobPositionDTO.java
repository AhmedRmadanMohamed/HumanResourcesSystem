package HumanResourcesPackage.DTOs.SingleDTOs;

import HumanResourcesPackage.Entitys.JobsEntity;
import HumanResourcesPackage.Entitys.JobseekersEntity;
import lombok.Builder;

import java.util.List;

@Builder

public record JobPositionDTO(
        Integer id,
        String positionName,
        List<JobsEntity> jobs,
        List<JobseekersEntity> jobseekers
) {
}