CREATE TABLE tenants
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    public_id   CHAR(36)     NOT NULL UNIQUE,
    tenant_code VARCHAR(50)  NOT NULL UNIQUE,
    name        VARCHAR(150) NOT NULL,
    status      VARCHAR(20)  NOT NULL,
    created_at  DATETIME(6)  NOT NULL,
    updated_at  DATETIME(6)  NOT NULL
);