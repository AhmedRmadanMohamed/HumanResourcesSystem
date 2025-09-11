package HumanResourcesPackage.Entitys;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "jobseekers", schema = "humanresources")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobseekersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String FirstName;

    @Column(name = "last_name")
    private String LastName;

    @Temporal(TemporalType.DATE)
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


    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UsersEntity usersEntity;

    @ManyToOne
    @JoinColumn(name = "preferred_position_id", referencedColumnName = "id")
    private JobPositionEntity preferredPositionEntity;
}
