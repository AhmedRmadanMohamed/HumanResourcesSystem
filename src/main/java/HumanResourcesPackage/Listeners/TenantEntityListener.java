package HumanResourcesPackage.Listeners;

import HumanResourcesPackage.Constants.TenantStatus;
import HumanResourcesPackage.Entitys.TenantEntity;
import jakarta.persistence.PrePersist;
import java.util.UUID;
public class TenantEntityListener {
    /**
     * Assigns the default public identifier and status before a tenant is saved.
     *
     * @param tenant the tenant being created
     */
    @PrePersist
    public void beforeInsert(TenantEntity tenant) {

        if (tenant.getPublicId() == null) {
            tenant.setPublicId(UUID.randomUUID());
        }

        if (tenant.getTenantStatus() == null) {
            tenant.setTenantStatus(TenantStatus.ACTIVE);
        }
    }
}
