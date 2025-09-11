package HumanResourcesPackage.Entitys;

import HumanResourcesPackage.CompositeKey.UserRolesId;
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
@Table(name = "userroles", schema = "humanresources")
public class UserRolesEntity {
    @EmbeddedId
    private UserRolesId id;
    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private UsersEntity user;
    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    private RolesEntity role;


}
