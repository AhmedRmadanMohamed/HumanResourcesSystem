package HumanResourcesPackage.Entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "users", schema = "humanresources")
public class UsersEntity {
    @Id
    private Integer id;
    @Column(name = "email", unique = true, nullable = false)
    private String Email;
    @Column(name = "password")
    private String Password;
    @Column(name = "is_activated")
    private Boolean IsActive;
    @Column(name = "status")
    private Boolean Status;
    @Column(name = "created_date")
    private LocalDateTime localDateTime;

    @OneToMany(mappedBy = "usersEntity")
    private List<JobseekersEntity> jobseekers;
    @OneToMany(mappedBy = "usersEntity")
    private List<EmployersEntity> employers;
    @OneToMany(mappedBy = "role")
    private List<UserRolesEntity> usersRoles;
    @OneToMany(mappedBy = "user")
    private List<UserRolesEntity> users;


}
