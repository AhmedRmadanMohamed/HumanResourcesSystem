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
@Table(name = "companies")
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
    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @ManyToOne
    @JoinColumn(name = "tenant_id", nullable = false)
    private TenantEntity tenant;

    @OneToMany(mappedBy = "company")
    private List<EmployeeEntity> employees;
}


