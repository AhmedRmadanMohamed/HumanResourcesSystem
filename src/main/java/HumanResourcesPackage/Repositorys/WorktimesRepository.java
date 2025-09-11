package HumanResourcesPackage.Repositorys;

import HumanResourcesPackage.Entitys.WorktimesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorktimesRepository extends JpaRepository<WorktimesEntity, Integer> {
}
