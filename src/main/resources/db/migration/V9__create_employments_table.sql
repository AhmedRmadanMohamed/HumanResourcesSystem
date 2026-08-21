CREATE TABLE employments
(
    id               BIGINT       NOT NULL AUTO_INCREMENT,

    tenant_id        BIGINT       NOT NULL,
    employee_id      BIGINT       NOT NULL,
    company_id       BIGINT       NOT NULL,
    department_id    BIGINT       NOT NULL,
    job_position_id  BIGINT       NOT NULL,

    start_date       DATE         NOT NULL,
    end_date         DATE         NULL,

    status           VARCHAR(20)  NOT NULL,

    created_at       TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at       TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    PRIMARY KEY (id),

    KEY idx_employments_tenant_id (tenant_id),
    KEY idx_employments_employee_id (employee_id),
    KEY idx_employments_company_id (company_id),
    KEY idx_employments_department_id (department_id),
    KEY idx_employments_job_position_id (job_position_id),

    CONSTRAINT fk_employments_tenant
        FOREIGN KEY (tenant_id)
            REFERENCES tenants(id)
            ON DELETE RESTRICT
            ON UPDATE RESTRICT,

    CONSTRAINT fk_employments_employee
        FOREIGN KEY (employee_id)
            REFERENCES employees(id)
            ON DELETE RESTRICT
            ON UPDATE RESTRICT,

    CONSTRAINT fk_employments_company
        FOREIGN KEY (company_id)
            REFERENCES companies(id)
            ON DELETE RESTRICT
            ON UPDATE RESTRICT,

    CONSTRAINT fk_employments_department
        FOREIGN KEY (department_id)
            REFERENCES departments(id)
            ON DELETE RESTRICT
            ON UPDATE RESTRICT,

    CONSTRAINT fk_employments_job_position
        FOREIGN KEY (job_position_id)
            REFERENCES job_positions(id)
            ON DELETE RESTRICT
            ON UPDATE RESTRICT
);