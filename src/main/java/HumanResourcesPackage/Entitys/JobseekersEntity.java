package HumanResourcesPackage.Entitys;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "jobseekers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobseekersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name", length = 255)
    private String firstName;

    @Column(name = "last_name", length = 255)
    private String lastName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "nationality_id")
    private Long nationalityId;

    @Column(name = "github", length = 255)
    private String github;

    @Column(name = "linkedin", length = 255)
    private String linkedin;

    @Lob
    @Column(name = "bio", columnDefinition = "TEXT")
    private String bio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UsersEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "preferred_position_id")
    private JobPositionEntity preferredPosition;
}
