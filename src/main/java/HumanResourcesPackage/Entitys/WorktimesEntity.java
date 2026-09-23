package HumanResourcesPackage.Entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "worktimes")
public class WorktimesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "name", length = 255)
    private String name;
    
    @OneToMany(mappedBy = "workTime", cascade = CascadeType.ALL)
    private List<JobsEntity> jobs;
}
