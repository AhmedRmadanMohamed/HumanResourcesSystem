package HumanResourcesPackage.Entitys;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Table(name = "jobs", schema = "humanresources")
public class JobsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Lob
    @Column(name = "description", columnDefinition = "TEXT")
    private String Description;

    @Column(name = "min_salary", precision = 10, scale = 2)
    private BigDecimal Min_Salary;

    @Column(name = "max_salary", precision = 10, scale = 2)
    private BigDecimal MaxSalary;

    @Column(name = "number_of_vacancies")
    private Integer NumberOfVacancies;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "deadline")
    private LocalDateTime Deadline;

    @Column(name = "created_at")
    private LocalDateTime CreatedAt;


    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private JobPositionEntity jobPosition;

    @ManyToOne
    @JoinColumn(name = "employer_id", referencedColumnName = "id")
    private EmployersEntity employers;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private CitiesEntity citiesEntity;

    @ManyToOne
    @JoinColumn(name = "work_time_id", referencedColumnName = "id")
    private WorktimesEntity worktimes;

    @ManyToOne
    @JoinColumn(name = "workplace_id", referencedColumnName = "id")
    private WorkplacesEntity workplaces;
}
