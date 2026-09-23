package HumanResourcesPackage.Entitys;

import HumanResourcesPackage.Constants.CompanyStatus;
import HumanResourcesPackage.Listeners.CompaniesEntityListeners;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "companies", uniqueConstraints = {
    @UniqueConstraint(name = "uq_company_tenant_code", columnNames = {"tenant_id", "company_code"})
})
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EntityListeners(CompaniesEntityListeners.class)
public class CompaniesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "public_id", length = 36, nullable = false, unique = true)
    private UUID publicId;
    
    @Column(name = "company_code", length = 50, nullable = false)
    private String companyCode;
    
    @Column(name = "legal_name", length = 200, nullable = false)
    private String legalName;
    
    @Column(name = "display_name", length = 150)
    private String displayName;
    
    @Column(name = "status", length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private CompanyStatus status;
    
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id", nullable = false)
    private TenantEntity tenant;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<EmployeeEntity> employees;
    
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<DepartmentsEntity> departments;
    
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<JobPositionsEntity> jobPositions;
    
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<EmploymentsEntity> employments;
}
