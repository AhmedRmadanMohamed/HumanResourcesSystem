package HumanResourcesPackage.Repositorys;

import HumanResourcesPackage.Entitys.JobPositionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPositionsRepository extends JpaRepository<JobPositionsEntity, Long> {
}
