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
@Table(name = "users")
public class UsersEntity {
    @Id
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "email", unique = true, nullable = false, length = 255)
    private String email;
    
    @Column(name = "password", length = 255)
    private String password;
    
    @Column(name = "is_activated")
    private Boolean isActivated;
    
    @Column(name = "status")
    private Boolean status;
    
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<JobseekersEntity> jobseekers;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<EmployersEntity> employers;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserRolesEntity> userRoles;
}
