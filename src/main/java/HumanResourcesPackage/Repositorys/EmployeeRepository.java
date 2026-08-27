package HumanResourcesPackage.Repositorys;

import HumanResourcesPackage.Entitys.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    @Query("""
            SELECT e
            FROM EmployeeEntity e
            JOIN e.company c
            JOIN e.tenant t
            WHERE e.id = :employeeId
            AND c.id = :companyId
            AND t.id = :tenantId
            """)

    Optional<EmployeeEntity> findEmployee(
            Long employeeId,
            Long companyId,
            Long tenantId
    );
}
