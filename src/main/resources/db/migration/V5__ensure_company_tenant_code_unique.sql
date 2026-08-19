SET @index_exists = (
    SELECT COUNT(*)
    FROM information_schema.statistics
    WHERE table_schema = DATABASE()
      AND table_name = 'companies'
      AND index_name = 'uq_company_tenant_code'
);

SET @sql = IF(
        @index_exists = 0,
        'ALTER TABLE companies
         ADD CONSTRAINT uq_company_tenant_code
         UNIQUE (tenant_id, company_code)',
        'SELECT 1'
           );

PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;