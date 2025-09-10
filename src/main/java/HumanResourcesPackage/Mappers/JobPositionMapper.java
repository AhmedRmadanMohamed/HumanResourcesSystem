package HumanResourcesPackage.Mappers;

import HumanResourcesPackage.DTOs.JobPositionDTO;
import HumanResourcesPackage.Entitys.JobPosition;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
@Builder
public class JobPositionMapper {
    public static JobPositionDTO toDTO(JobPosition jobPosition) {
        return JobPositionDTO.builder().positionName(jobPosition.getPositionName()).id(jobPosition.getId()).build();
    }

    public static JobPosition toEntity(JobPositionDTO jobPositionDTO) {
    return JobPosition.builder().positionName(jobPositionDTO.positionName()).id(jobPositionDTO.id()).build();
    }
}
