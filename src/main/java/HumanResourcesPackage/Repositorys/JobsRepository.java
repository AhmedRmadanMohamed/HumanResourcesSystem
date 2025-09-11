package HumanResourcesPackage.Repositorys;

import HumanResourcesPackage.Entitys.JobsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsRepository extends JpaRepository<JobsEntity, Integer> {
}
