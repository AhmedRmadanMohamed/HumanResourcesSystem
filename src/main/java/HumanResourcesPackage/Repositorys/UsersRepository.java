package HumanResourcesPackage.Repositorys;

import HumanResourcesPackage.DTOs.JoinsEntitys.UserInformationDTO;
import HumanResourcesPackage.Entitys.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {

    @Query(
            value = """
                    SELECT
                      A.email        AS email,
                      A.status       AS status,
                      A.is_activated AS is_activated,
                      A.created_date AS created_date,
                      B.role_name    AS role_name
                    FROM users A
                    JOIN userroles C ON C.user_id = A.id
                    JOIN roles B     ON B.id = C.role_id
                    """,
            nativeQuery = true
    )
    List<UserInformationDTO> GetAllUsersInfo();

    @Query(value = """
            SELECT
              A.email        AS email,
              A.status       AS status,
              A.is_activated AS is_activated,
              A.created_date AS created_date,
              B.role_name    AS role_name
            FROM users A
            JOIN userroles C ON C.user_id = A.id
            JOIN roles B     ON B.id = C.role_id
            WHERE B.role_name = :roleName
            """,
            nativeQuery = true)
    List<UserInformationDTO> GetAllUsersInfoByRole(@Param("roleName") String roleName);
}
