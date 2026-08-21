package HumanResourcesPackage.Repositorys;

import HumanResourcesPackage.Entitys.DepartmentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentsRepository extends JpaRepository<DepartmentsEntity, Long> {
}
