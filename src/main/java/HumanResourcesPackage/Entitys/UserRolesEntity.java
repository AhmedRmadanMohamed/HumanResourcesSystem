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
    @JoinColumn(name = "user_id" , referencedColumnName = "id")
    private UsersEntity user;
    @ManyToOne
    @JoinColumn(name = "role_id" , referencedColumnName = "id")
    private RolesEntity role;


}
