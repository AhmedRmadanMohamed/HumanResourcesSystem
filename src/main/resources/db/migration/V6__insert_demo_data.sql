INSERT INTO tenants
(
    public_id,
    tenant_code,
    name,
    status,
    created_at,
    updated_at
)
VALUES
    (UUID(), 'DEMO_T01', 'Alpha Group',   'ACTIVE', NOW(), NOW()),
    (UUID(), 'DEMO_T02', 'Beta Group',    'ACTIVE', NOW(), NOW()),
    (UUID(), 'DEMO_T03', 'Gamma Group',   'ACTIVE', NOW(), NOW()),
    (UUID(), 'DEMO_T04', 'Delta Group',   'ACTIVE', NOW(), NOW()),
    (UUID(), 'DEMO_T05', 'Epsilon Group', 'ACTIVE', NOW(), NOW()),
    (UUID(), 'DEMO_T06', 'Zeta Group',    'ACTIVE', NOW(), NOW()),
    (UUID(), 'DEMO_T07', 'Eta Group',     'ACTIVE', NOW(), NOW()),
    (UUID(), 'DEMO_T08', 'Theta Group',   'ACTIVE', NOW(), NOW()),
    (UUID(), 'DEMO_T09', 'Iota Group',    'ACTIVE', NOW(), NOW()),
    (UUID(), 'DEMO_T10', 'Kappa Group',   'ACTIVE', NOW(), NOW());


INSERT INTO companies
(
    public_id,
    company_code,
    legal_name,
    display_name,
    status,
    created_at,
    updated_at,
    tenant_id
)
VALUES
    (
        UUID(),
        'DEMO_C01',
        'Alpha Technology LLC',
        'Alpha Tech',
        'ACTIVE',
        NOW(),
        NOW(),
        (SELECT id FROM tenants WHERE tenant_code = 'DEMO_T01')
    ),
    (
        UUID(),
        'DEMO_C02',
        'Alpha Services LLC',
        'Alpha Services',
        'ACTIVE',
        NOW(),
        NOW(),
        (SELECT id FROM tenants WHERE tenant_code = 'DEMO_T01')
    ),
    (
        UUID(),
        'DEMO_C03',
        'Alpha Trading LLC',
        'Alpha Trading',
        'ACTIVE',
        NOW(),
        NOW(),
        (SELECT id FROM tenants WHERE tenant_code = 'DEMO_T01')
    ),
    (
        UUID(),
        'DEMO_C04',
        'Beta Software LLC',
        'Beta Software',
        'ACTIVE',
        NOW(),
        NOW(),
        (SELECT id FROM tenants WHERE tenant_code = 'DEMO_T02')
    ),
    (
        UUID(),
        'DEMO_C05',
        'Beta Consulting LLC',
        'Beta Consulting',
        'ACTIVE',
        NOW(),
        NOW(),
        (SELECT id FROM tenants WHERE tenant_code = 'DEMO_T02')
    ),
    (
        UUID(),
        'DEMO_C06',
        'Beta Medical LLC',
        'Beta Medical',
        'ACTIVE',
        NOW(),
        NOW(),
        (SELECT id FROM tenants WHERE tenant_code = 'DEMO_T02')
    ),
    (
        UUID(),
        'DEMO_C07',
        'Gamma Systems LLC',
        'Gamma Systems',
        'ACTIVE',
        NOW(),
        NOW(),
        (SELECT id FROM tenants WHERE tenant_code = 'DEMO_T03')
    ),
    (
        UUID(),
        'DEMO_C08',
        'Gamma Logistics LLC',
        'Gamma Logistics',
        'ACTIVE',
        NOW(),
        NOW(),
        (SELECT id FROM tenants WHERE tenant_code = 'DEMO_T03')
    ),
    (
        UUID(),
        'DEMO_C09',
        'Delta Solutions LLC',
        'Delta Solutions',
        'ACTIVE',
        NOW(),
        NOW(),
        (SELECT id FROM tenants WHERE tenant_code = 'DEMO_T04')
    ),
    (
        UUID(),
        'DEMO_C10',
        'Delta Manufacturing LLC',
        'Delta Manufacturing',
        'ACTIVE',
        NOW(),
        NOW(),
        (SELECT id FROM tenants WHERE tenant_code = 'DEMO_T04')
    );


INSERT INTO employees
(
    tenant_id,
    company_id,
    employee_code,
    first_name,
    middle_name,
    last_name,
    email,
    phone,
    hire_date,
    status
)
SELECT
    tenant_id,
    id,
    'EMP001',
    'Ahmed',
    NULL,
    'Mohamed',
    'ahmed@alpha.com',
    '01000000001',
    '2024-01-10',
    'ACTIVE'
FROM companies
WHERE company_code = 'DEMO_C01'

UNION ALL

SELECT
    tenant_id,
    id,
    'EMP002',
    'Omar',
    'Ali',
    'Hassan',
    'omar@alpha.com',
    '01000000002',
    '2024-02-15',
    'ACTIVE'
FROM companies
WHERE company_code = 'DEMO_C01'

UNION ALL

SELECT
    tenant_id,
    id,
    'EMP003',
    'Sara',
    NULL,
    'Mahmoud',
    'sara@alpha.com',
    '01000000003',
    '2024-03-20',
    'INACTIVE'
FROM companies
WHERE company_code = 'DEMO_C01'

UNION ALL

SELECT
    tenant_id,
    id,
    'EMP001',
    'Mostafa',
    NULL,
    'Ibrahim',
    'mostafa@services.com',
    '01000000004',
    '2024-04-05',
    'ACTIVE'
FROM companies
WHERE company_code = 'DEMO_C02'

UNION ALL

SELECT
    tenant_id,
    id,
    'EMP001',
    'Mariam',
    'Ahmed',
    'Ali',
    'mariam@beta.com',
    '01000000005',
    '2023-11-10',
    'ACTIVE'
FROM companies
WHERE company_code = 'DEMO_C04'

UNION ALL

SELECT
    tenant_id,
    id,
    'EMP002',
    'Youssef',
    NULL,
    'Khaled',
    'youssef@beta.com',
    '01000000006',
    '2024-05-17',
    'TERMINATED'
FROM companies
WHERE company_code = 'DEMO_C04'

UNION ALL

SELECT
    tenant_id,
    id,
    'EMP001',
    'Nour',
    NULL,
    'Samir',
    'nour@gamma.com',
    '01000000007',
    '2025-01-05',
    'ACTIVE'
FROM companies
WHERE company_code = 'DEMO_C07'

UNION ALL

SELECT
    tenant_id,
    id,
    'EMP002',
    'Mohamed',
    'Tarek',
    'Adel',
    'mohamed@gamma.com',
    '01000000008',
    '2025-02-11',
    'ACTIVE'
FROM companies
WHERE company_code = 'DEMO_C07'

UNION ALL

SELECT
    tenant_id,
    id,
    'EMP001',
    'Aya',
    NULL,
    'Hany',
    'aya@delta.com',
    '01000000009',
    '2025-03-01',
    'ACTIVE'
FROM companies
WHERE company_code = 'DEMO_C09'

UNION ALL

SELECT
    tenant_id,
    id,
    'EMP001',
    'Karim',
    NULL,
    'Sayed',
    'karim@manufacturing.com',
    '01000000010',
    '2025-04-12',
    'INACTIVE'
FROM companies
WHERE company_code = 'DEMO_C10';