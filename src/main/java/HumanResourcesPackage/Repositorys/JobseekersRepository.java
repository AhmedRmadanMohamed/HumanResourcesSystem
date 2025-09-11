package HumanResourcesPackage.Repositorys;

import HumanResourcesPackage.Entitys.JobseekersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobseekersRepository extends JpaRepository<JobseekersEntity, Integer> {
}
