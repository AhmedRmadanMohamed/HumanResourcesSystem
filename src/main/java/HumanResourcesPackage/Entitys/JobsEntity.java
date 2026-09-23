package HumanResourcesPackage.Entitys;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "jobs")
public class JobsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Lob
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "min_salary", precision = 10, scale = 2)
    private BigDecimal minSalary;

    @Column(name = "max_salary", precision = 10, scale = 2)
    private BigDecimal maxSalary;

    @Column(name = "number_of_vacancies")
    private Integer numberOfVacancies;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "deadline")
    private LocalDateTime deadline;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id")
    private JobPositionEntity jobPosition;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employer_id")
    private EmployersEntity employer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private CitiesEntity city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_time_id")
    private WorktimesEntity workTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workplace_id")
    private WorkplacesEntity workplace;
}
