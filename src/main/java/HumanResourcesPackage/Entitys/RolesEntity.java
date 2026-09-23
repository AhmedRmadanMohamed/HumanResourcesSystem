package HumanResourcesPackage.Entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "roles")
public class RolesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "role_name", unique = true, length = 255)
    private String roleName;
    
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<UserRolesEntity> userRoles;
}
