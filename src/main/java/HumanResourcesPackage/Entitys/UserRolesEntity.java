package HumanResourcesPackage.Entitys;

import HumanResourcesPackage.Keys.UserRolesId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "userroles")
public class UserRolesEntity {
    @EmbeddedId
    private UserRolesId id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private UsersEntity user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    private RolesEntity role;
}
