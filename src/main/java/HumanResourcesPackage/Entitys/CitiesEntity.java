package HumanResourcesPackage.Entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "cities")
public class CitiesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "city_name", length = 255)
    private String cityName;
    
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<JobsEntity> jobs;
}
