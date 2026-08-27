package HumanResourcesPackage.Listeners;

import HumanResourcesPackage.Constants.CompanyStatus;
import HumanResourcesPackage.Entitys.CompaniesEntity;
import jakarta.persistence.PrePersist;

import java.util.UUID;

public class CompaniesEntityListeners {


    /**
     * Assigns the default public identifier and status before a company is saved.
     *
     * @param companiesEntity the company being created
     */
    @PrePersist
    public void prePersist(CompaniesEntity companiesEntity) {

        if (companiesEntity.getPublicId() == null) {
            companiesEntity.setPublicId(UUID.randomUUID());
        }
        if (companiesEntity.getStatus() == null) {

            companiesEntity.setStatus(CompanyStatus.ACTIVE);
        }

    }
}
