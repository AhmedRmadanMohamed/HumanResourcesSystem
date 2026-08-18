package HumanResourcesPackage.DTOs.SingleDTOs;

import HumanResourcesPackage.Constants.TenantStatus;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record TenantDTO(Long id, UUID publicId, String tenantCode, String tenantName, TenantStatus tenantStatus,
                        LocalDateTime createdAt, LocalDateTime updatedAt) {
}
