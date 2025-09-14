package HumanResourcesPackage.Mappers;

import HumanResourcesPackage.DTOs.SingleDTOs.JobPositionDTO;
import HumanResourcesPackage.Entitys.JobPositionEntity;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
@Builder
public class JobPositionMapper{
    public  JobPositionDTO toDTO(JobPositionEntity jobPosition) {
        return JobPositionDTO.builder().positionName(jobPosition.getPositionName()).id(jobPosition.getId()).build();}

    public  JobPositionEntity toEntity(JobPositionDTO jobPositionDTO) {
    return JobPositionEntity.builder().positionName(jobPositionDTO.positionName()).id(jobPositionDTO.id()).build();
    }
}
