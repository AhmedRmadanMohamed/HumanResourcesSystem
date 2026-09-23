package HumanResourcesPackage.Entitys;

import HumanResourcesPackage.Constants.JobPositionsStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "job_positions", uniqueConstraints = {
    @UniqueConstraint(name = "uk_job_positions_company_position_code", columnNames = {"company_id", "position_code"})
})
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class JobPositionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id", nullable = false)
    private TenantEntity tenant;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private CompaniesEntity company;
    
    @Column(name = "position_code", length = 50, nullable = false)
    private String positionCode;
    
    @Column(name = "title", length = 150, nullable = false)
    private String title;
    
    @Column(name = "description", length = 500)
    private String description;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20, nullable = false)
    private JobPositionsStatus status;
    
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
    
    @OneToMany(mappedBy = "jobPosition", cascade = CascadeType.ALL)
    private List<EmploymentsEntity> employments;
}
