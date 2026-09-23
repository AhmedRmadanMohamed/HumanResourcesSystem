package HumanResourcesPackage.Entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "jobpositions")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class JobPositionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "position_name", length = 255)
    private String positionName;
    
    @OneToMany(mappedBy = "jobPosition", cascade = CascadeType.ALL)
    private List<JobsEntity> jobs;
    
    @OneToMany(mappedBy = "preferredPosition", cascade = CascadeType.ALL)
    private List<JobseekersEntity> jobseekers;
}
