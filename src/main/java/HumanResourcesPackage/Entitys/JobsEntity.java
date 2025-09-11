package HumanResourcesPackage.Entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "jobs", schema = "humanresources")
public class JobsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "position_id")
    private Integer PositionId;
    @Column(name = "employer_id")
    private Integer EmployeeId;
    @Column(name = "city_id")
    private Integer CityId;
    @Column(name = "work_time_id")
    private Integer WorkTimeId;
    @Column(name = "workplace_id")
    private Integer WorkplaceId;
    @Lob
    @Column(name = "description", columnDefinition = "TEXT")
    private String Description;
    @Column(name = "min_salary")
    private BigDecimal Min_Salary;
    @Column(name = "max_salary")
    private BigDecimal MaxSalary;
    @Column(name = "number_of_vacancies")
    private Integer NumberOfVacancies;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "deadline")
    private LocalDate Deadline;
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
    @JoinColumn(name = "work_time_id" , referencedColumnName = "id")
    private  WorktimesEntity worktimes;
    @ManyToOne
    @JoinColumn(name = "workplace_id" , referencedColumnName = "id")
    private  WorkplacesEntity workplaces;

}
