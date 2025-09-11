package HumanResourcesPackage.Entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Entity
@Table(name = "jobpositions", schema = "humanresources")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class JobPositionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "position_name")
    private String positionName;
    @OneToMany(mappedBy = "jobPosition")
    private List<JobsEntity> jobs;
    @OneToMany(mappedBy = "preferredPositionEntity")
    private List<JobseekersEntity> workplaces;


}
