package HumanResourcesPackage.Entitys;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "employers")
public class EmployersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "company_name", length = 255)
    private String companyName;

    @Column(name = "website", length = 255)
    private String website;

    @Column(name = "phone_number", length = 255)
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UsersEntity user;

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL)
    private List<JobsEntity> jobs;
}
