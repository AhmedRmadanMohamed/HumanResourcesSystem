package HumanResourcesPackage.Entitys;

import HumanResourcesPackage.Constants.DepartmentsStatus;
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
@Table(name = "departments", uniqueConstraints = {
    @UniqueConstraint(name = "uk_departments_company_department_code", columnNames = {"company_id", "department_code"})
})
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DepartmentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id", nullable = false)
    private TenantEntity tenant;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private CompaniesEntity company;
    
    @Column(name = "department_code", length = 50, nullable = false)
    private String departmentCode;

    @Column(name = "name", length = 150, nullable = false)
    private String name;
    
    @Column(name = "description", length = 500)
    private String description;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20, nullable = false)
    private DepartmentsStatus status;
    
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
    
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<EmploymentsEntity> employments;
}
