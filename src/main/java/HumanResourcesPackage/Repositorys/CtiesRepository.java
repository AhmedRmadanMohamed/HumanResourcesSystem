package HumanResourcesPackage.Repositorys;
import HumanResourcesPackage.Entitys.CitiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CtiesRepository extends JpaRepository<CitiesEntity, Integer> {
}
