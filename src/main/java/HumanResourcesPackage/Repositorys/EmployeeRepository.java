package HumanResourcesPackage.Repositorys;

import HumanResourcesPackage.Entitys.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
