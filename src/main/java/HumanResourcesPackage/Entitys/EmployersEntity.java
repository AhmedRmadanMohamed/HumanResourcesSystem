package HumanResourcesPackage.Entitys;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Table(name = "employers", schema = "humanresources")
public class EmployersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "company_name")
    private String CompanyName;

    @Column(name = "website")
    private String Website;

    @Column(name = "phone_number")
    private String Phone;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UsersEntity usersEntity;

    @OneToMany(mappedBy = "employers")
    private List<JobsEntity> JobsEntities;
}
