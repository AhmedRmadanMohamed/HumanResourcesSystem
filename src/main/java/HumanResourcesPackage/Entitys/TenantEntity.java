package HumanResourcesPackage.Entitys;

import HumanResourcesPackage.Constants.TenantStatus;
import HumanResourcesPackage.Keys.TenantEntityListener;
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
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tenants")
@EntityListeners(TenantEntityListener.class)
public class TenantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "public_id", unique = true, nullable = false, length = 36)
    private UUID publicId;
    @Column(name = "tenant_code", unique = true, nullable = false, length = 50)
    private String tenantCode;
    @Column(name = "name", nullable = false, length = 150)
    private String tenantName;
    @Column(name = "status", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private TenantStatus tenantStatus;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}