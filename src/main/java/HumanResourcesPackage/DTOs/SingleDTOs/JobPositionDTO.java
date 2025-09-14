package HumanResourcesPackage.DTOs.SingleDTOs;

import lombok.Builder;

@Builder
public record JobPositionDTO(Integer id, String positionName) {

}
