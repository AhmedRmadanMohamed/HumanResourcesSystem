CREATE TABLE employees
(
    id            BIGINT       NOT NULL AUTO_INCREMENT,

    tenant_id     BIGINT       NOT NULL,
    company_id    BIGINT       NOT NULL,

    employee_code VARCHAR(50)  NOT NULL,

    first_name    VARCHAR(100) NOT NULL,
    middle_name   VARCHAR(100) NULL,
    last_name     VARCHAR(100) NOT NULL,

    email         VARCHAR(255) NULL,
    phone         VARCHAR(50)  NULL,

    hire_date     DATE         NULL,

    status        VARCHAR(30)  NOT NULL,

    created_at    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    PRIMARY KEY (id),

    UNIQUE KEY uk_employees_company_employee_code
        (company_id, employee_code),

    KEY idx_employees_tenant_id (tenant_id),

    CONSTRAINT fk_employees_tenant
        FOREIGN KEY (tenant_id)
            REFERENCES tenants(id)
            ON DELETE RESTRICT
            ON UPDATE RESTRICT,

    CONSTRAINT fk_employees_company
        FOREIGN KEY (company_id)
            REFERENCES companies(id)
            ON DELETE RESTRICT
            ON UPDATE RESTRICT
);

SHOW TABLES LIKE 'employees';