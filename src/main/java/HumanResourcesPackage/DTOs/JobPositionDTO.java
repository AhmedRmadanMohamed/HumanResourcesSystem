package HumanResourcesPackage.DTOs;

import lombok.Builder;

@Builder
public record JobPositionDTO(Integer id, String positionName) {

}
