package HumanResourcesPackage.Entitys;

import HumanResourcesPackage.Constants.TenantStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tenants")
public class TenantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "public_id", unique = true, nullable = false)
    private UUID publicId;
    @Column(name = "tenant_code", unique = true, nullable = false)
    private String tenantCode;
    @Column(name = "name", nullable = false)
    private String tenantName;
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TenantStatus tenantStatus;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
