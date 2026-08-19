package HumanResourcesPackage.Entitys;

import HumanResourcesPackage.Constants.CompanyStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "companies")
@AllArgsConstructor
@NoArgsConstructor
public class CompaniesEntity {
    @Id
    private Long id;
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "public_id", length = 36, nullable = false, unique = true)
    private UUID publicId;

    @Column(name = "company_code", length = 50, nullable = false)
    private String companyCode;
    @Column(name = "legal_name", length = 200, nullable = false)
    private String legalName;
    @Column(name = "display_name", length = 150, nullable = true)
    private String displayName;
    @Column(name = "status", length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private CompanyStatus status;
    @Column(name = "created_at" , nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_at" , nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @ManyToOne
    @JoinColumn(name = "tenant_id", nullable = false)
    private TenantEntity tenant;
}


