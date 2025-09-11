package HumanResourcesPackage.Repositorys;

import HumanResourcesPackage.Entitys.WorkplacesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkplacesRepository extends JpaRepository<WorkplacesEntity, Integer> {
}
