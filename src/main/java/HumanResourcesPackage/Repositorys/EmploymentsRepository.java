package HumanResourcesPackage.Repositorys;

import HumanResourcesPackage.Entitys.EmploymentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploymentsRepository extends JpaRepository<EmploymentsEntity, Long> {
}
