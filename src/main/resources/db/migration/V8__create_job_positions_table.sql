CREATE TABLE job_positions
(
    id              BIGINT        NOT NULL AUTO_INCREMENT,

    tenant_id       BIGINT        NOT NULL,
    company_id      BIGINT        NOT NULL,

    position_code   VARCHAR(50)   NOT NULL,
    title           VARCHAR(150)  NOT NULL,
    description     VARCHAR(500)  NULL,

    status          VARCHAR(20)   NOT NULL,

    created_at      TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at      TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    PRIMARY KEY (id),

    UNIQUE KEY uk_job_positions_company_position_code
        (company_id, position_code),

    KEY idx_job_positions_tenant_id
        (tenant_id),

    CONSTRAINT fk_job_positions_tenant
        FOREIGN KEY (tenant_id)
            REFERENCES tenants(id)
            ON DELETE RESTRICT
            ON UPDATE RESTRICT,

    CONSTRAINT fk_job_positions_company
        FOREIGN KEY (company_id)
            REFERENCES companies(id)
            ON DELETE RESTRICT
            ON UPDATE RESTRICT
);