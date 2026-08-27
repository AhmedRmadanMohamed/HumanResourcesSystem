package HumanResourcesPackage;

import HumanResourcesPackage.DTOs.JoinsEntitys.UserInformationDTO;
import HumanResourcesPackage.Repositorys.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = MainHumanResourceApplication.class)
@ActiveProfiles("test")
@Transactional
class UsersRepositoryTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UsersRepository usersRepository;

    /**
     * Inserts the user, role, and relationship required by each test.
     */
    @BeforeEach
    void setUp() {
        jdbcTemplate.update("""
                        INSERT INTO users (id, email, password, is_activated, status, created_date)
                        VALUES (?, ?, ?, ?, ?, ?)
                        """,
                1, "admin@example.com", "encoded-password", true, true,
                Timestamp.from(Instant.parse("2026-08-18T00:00:00Z")));
        jdbcTemplate.update("INSERT INTO roles (id, role_name) VALUES (?, ?)", 1, "ADMIN");
        jdbcTemplate.update("INSERT INTO userroles (user_id, role_id) VALUES (?, ?)", 1, 1);
    }

    /**
     * Verifies that all user information is returned with its assigned role.
     */
    @Test
    void returnsAllUsersInformation() {
        List<UserInformationDTO> users = usersRepository.GetAllUsersInfo();

        assertThat(users).singleElement().satisfies(user -> {
            assertThat(user.email()).isEqualTo("admin@example.com");
            assertThat(user.role_name()).isEqualTo("ADMIN");
        });
    }

    /**
     * Verifies that user information can be filtered by role name.
     */
    @Test
    void filtersUsersInformationByRole() {
        List<UserInformationDTO> users = usersRepository.GetAllUsersInfoByRole("ADMIN");

        assertThat(users).singleElement().satisfies(user -> {
            assertThat(user.email()).isEqualTo("admin@example.com");
            assertThat(user.role_name()).isEqualTo("ADMIN");
        });
    }
}
