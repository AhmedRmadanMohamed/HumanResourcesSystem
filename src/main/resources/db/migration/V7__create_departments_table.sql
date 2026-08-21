CREATE TABLE departments
(
    id              BIGINT       NOT NULL AUTO_INCREMENT,

    tenant_id       BIGINT       NOT NULL,
    company_id      BIGINT       NOT NULL,

    department_code VARCHAR(50)   NOT NULL,
    name            VARCHAR(150)  NOT NULL,
    description     VARCHAR(500)  NULL,

    status          VARCHAR(20)   NOT NULL,

    created_at      TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at      TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    PRIMARY KEY (id),

    UNIQUE KEY uk_departments_company_department_code
        (company_id, department_code),

    KEY idx_departments_tenant_id (tenant_id),

    CONSTRAINT fk_departments_tenant
        FOREIGN KEY (tenant_id)
            REFERENCES tenants(id)
            ON DELETE RESTRICT
            ON UPDATE RESTRICT,

    CONSTRAINT fk_departments_company
        FOREIGN KEY (company_id)
            REFERENCES companies(id)
            ON DELETE RESTRICT
            ON UPDATE RESTRICT
);