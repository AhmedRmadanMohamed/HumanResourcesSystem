package HumanResourcesPackage.Mappers;

import HumanResourcesPackage.DTOs.SingleDTOs.JobPositionDTO;
import HumanResourcesPackage.Entitys.JobPositionEntity;
import org.springframework.stereotype.Component;

@Component
public class JobPositionMapper {
    /**
     * Converts a job position entity into its DTO representation.
     *
     * @param jobPosition the entity to convert
     * @return the mapped job position DTO
     */
    public JobPositionDTO toDTO(JobPositionEntity jobPosition) {
        return JobPositionDTO.builder().positionName(jobPosition.getPositionName()).id(jobPosition.getId()).build();
    }

    /**
     * Converts a job position DTO into an entity.
     *
     * @param jobPositionDTO the DTO to convert
     * @return the mapped job position entity
     */
    public JobPositionEntity toEntity(JobPositionDTO jobPositionDTO) {
        return JobPositionEntity.builder().positionName(jobPositionDTO.positionName()).id(jobPositionDTO.id()).build();
    }
}
