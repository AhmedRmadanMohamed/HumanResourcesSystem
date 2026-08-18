create table companies
(
    id           BIGINT primary key AUTO_INCREMENT,
    public_id    CHAR(36)     NOT NULL UNIQUE,
    tenant_id    BIGINT       NOT NULL,
    company_code VARCHAR(50)  NOT NULL,
    legal_name   VARCHAR(200) NOT NULL,
    display_name VARCHAR(150),
    status       VARCHAR(20)  NOT NULL,
    created_at   DATETIME(6)  NOT NULL,
    updated_at   DATETIME(6)  NOT NULL
)