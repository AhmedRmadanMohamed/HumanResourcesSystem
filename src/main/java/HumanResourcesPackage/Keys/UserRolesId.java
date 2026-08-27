package HumanResourcesPackage.Keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserRolesId implements Serializable {
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * Checks whether this key has the same user and role identifiers as another key.
     *
     * @param o the object to compare with
     * @return {@code true} when both keys represent the same user-role pair
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRolesId)) return false;
        UserRolesId that = (UserRolesId) o;
        return Objects.equals(userId, that.userId) && Objects.equals(roleId, that.roleId);
    }

    /**
     * Generates a hash code from the user and role identifiers.
     *
     * @return the hash code for this key
     */
    @Override
    public int hashCode() {
        return Objects.hash(userId, roleId);
    }


}
