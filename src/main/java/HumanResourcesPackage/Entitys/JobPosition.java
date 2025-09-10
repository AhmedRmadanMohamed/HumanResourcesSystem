package HumanResourcesPackage.Entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "jobpositions", schema = "humanresources")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class JobPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "position_name" , length = 50)
    private String positionName;
}
