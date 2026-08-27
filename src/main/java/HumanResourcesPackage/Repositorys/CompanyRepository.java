package HumanResourcesPackage.Repositorys;

import HumanResourcesPackage.Entitys.CompaniesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<CompaniesEntity, Long> {

    /**
     * Finds a company by its ID within the specified tenant.
     *
     * @param companyId the company ID
     * @param tenantId the tenant ID
     * @return the matching company, or an empty result if none exists
     */
    Optional<CompaniesEntity> findByIdAndTenant_Id(Long companyId, Long tenantId);
}
