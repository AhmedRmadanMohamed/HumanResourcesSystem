package HumanResourcesPackage.Repositorys;

import HumanResourcesPackage.Entitys.CompaniesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository  extends JpaRepository<CompaniesEntity , Long> {
}
