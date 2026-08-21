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
@Table(name = "departments")
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
    private String Name;
    @Column(name = "description", length = 500)
    private String Description;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20 , nullable = false)
    private DepartmentsStatus Status;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
    @OneToMany(mappedBy = "departments")
    private List<EmploymentsEntity> entities;
}


