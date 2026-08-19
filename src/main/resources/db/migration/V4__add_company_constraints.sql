ALTER TABLE companies
    ADD CONSTRAINT fk_companies_tenant
        FOREIGN KEY (tenant_id)
            REFERENCES tenants(id)
            ON DELETE RESTRICT;

