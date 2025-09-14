package HumanResourcesPackage.Repositorys;

import HumanResourcesPackage.DTOs.JoinsEntitys.UserInformationDTO;
import HumanResourcesPackage.Entitys.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {

    @Query(
            value = """
                    SELECT
                      A.email        AS email,
                      A.status       AS status,
                      A.password        AS password,
                      A.is_activated AS activated,
                      A.created_date AS createdDate,
                      B.role_name    AS roleName
                    FROM users A
                    JOIN userroles C ON C.user_id = A.id
                    JOIN roles B     ON B.id = C.role_id
                    """,
            nativeQuery = true
    )
    List<UserInformationDTO> GetAllUsersInfo();

    @Query(value = """
              select  A.email  , A.status  , A.password , A.is_activated , A.created_date,    B.role_name
              from users  A JOIN  userroles C on  A.id = C.user_id  JOIN   roles B  ON b.id= c.role_id where B.role_name =:RoleType
            """,
            nativeQuery = true)
    CopyOnWriteArrayList<UserInformationDTO> GetAllUsersInfoByRole(@Param("RoleType") String RoleType);


}
