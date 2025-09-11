package HumanResourcesPackage.Entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "jobseekers", schema = "humanresources")
public class JobseekersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "first_name")
    private String FirstName;
    @Column(name = "last_name")
    private String LastName;
    @Column(name = "birth_date")
    private Date BirthDate;
    @Column(name = "nationality_id")
    private Long NationalItyId;
    @Column(name = "github")
    private String GitHub;
    @Column(name = "linkedin")
    private String LinkedIn;
    @Lob
    @Column(name = "bio", columnDefinition = "TEXT")
    private String Bio;
    @Column(name = "preferred_position_id")
    private Integer PreferredPositionId;
    @ManyToOne
    @JoinColumn(name = "user_id" ,referencedColumnName = "id")
    private UsersEntity usersEntity;
    @ManyToOne
    @JoinColumn(name = "preferred_position_id" , referencedColumnName = "id")
    private JobPositionEntity preferredPositionEntity;
}
