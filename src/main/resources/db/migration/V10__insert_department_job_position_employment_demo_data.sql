-- =========================================================
-- DEPARTMENTS - 10 ROWS
-- =========================================================

INSERT INTO departments
(
    tenant_id,
    company_id,
    department_code,
    name,
    description,
    status
)
SELECT tenant_id, id, 'DEP001', 'Information Technology', 'IT Department', 'ACTIVE'
FROM companies WHERE company_code = 'DEMO_C01'

UNION ALL

SELECT tenant_id, id, 'DEP002', 'Human Resources', 'Human Resources Department', 'ACTIVE'
FROM companies WHERE company_code = 'DEMO_C01'

UNION ALL

SELECT tenant_id, id, 'DEP003', 'Finance', 'Finance Department', 'ACTIVE'
FROM companies WHERE company_code = 'DEMO_C01'

UNION ALL

SELECT tenant_id, id, 'DEP001', 'Customer Service', 'Customer Service Department', 'ACTIVE'
FROM companies WHERE company_code = 'DEMO_C02'

UNION ALL

SELECT tenant_id, id, 'DEP001', 'Software Development', 'Software Development Department', 'ACTIVE'
FROM companies WHERE company_code = 'DEMO_C04'

UNION ALL

SELECT tenant_id, id, 'DEP002', 'Quality Assurance', 'QA Department', 'ACTIVE'
FROM companies WHERE company_code = 'DEMO_C04'

UNION ALL

SELECT tenant_id, id, 'DEP001', 'Operations', 'Operations Department', 'ACTIVE'
FROM companies WHERE company_code = 'DEMO_C07'

UNION ALL

SELECT tenant_id, id, 'DEP002', 'Administration', 'Administration Department', 'ACTIVE'
FROM companies WHERE company_code = 'DEMO_C07'

UNION ALL

SELECT tenant_id, id, 'DEP001', 'Sales', 'Sales Department', 'ACTIVE'
FROM companies WHERE company_code = 'DEMO_C09'

UNION ALL

SELECT tenant_id, id, 'DEP001', 'Production', 'Production Department', 'ACTIVE'
FROM companies WHERE company_code = 'DEMO_C10';


-- =========================================================
-- JOB POSITIONS - 10 ROWS
-- =========================================================

INSERT INTO job_positions
(
    tenant_id,
    company_id,
    position_code,
    title,
    description,
    status
)
SELECT tenant_id, id, 'POS001', 'Backend Developer', 'Backend Software Developer', 'ACTIVE'
FROM companies WHERE company_code = 'DEMO_C01'

UNION ALL

SELECT tenant_id, id, 'POS002', 'HR Specialist', 'Human Resources Specialist', 'ACTIVE'
FROM companies WHERE company_code = 'DEMO_C01'

UNION ALL

SELECT tenant_id, id, 'POS003', 'Accountant', 'Company Accountant', 'ACTIVE'
FROM companies WHERE company_code = 'DEMO_C01'

UNION ALL

SELECT tenant_id, id, 'POS001', 'Customer Service Agent', 'Customer Service Agent', 'ACTIVE'
FROM companies WHERE company_code = 'DEMO_C02'

UNION ALL

SELECT tenant_id, id, 'POS001', 'Java Developer', 'Java Backend Developer', 'ACTIVE'
FROM companies WHERE company_code = 'DEMO_C04'

UNION ALL

SELECT tenant_id, id, 'POS002', 'QA Engineer', 'Software Quality Engineer', 'ACTIVE'
FROM companies WHERE company_code = 'DEMO_C04'

UNION ALL

SELECT tenant_id, id, 'POS001', 'Operations Specialist', 'Operations Specialist', 'ACTIVE'
FROM companies WHERE company_code = 'DEMO_C07'

UNION ALL

SELECT tenant_id, id, 'POS002', 'Administrator', 'Administrative Employee', 'ACTIVE'
FROM companies WHERE company_code = 'DEMO_C07'

UNION ALL

SELECT tenant_id, id, 'POS001', 'Sales Representative', 'Sales Representative', 'ACTIVE'
FROM companies WHERE company_code = 'DEMO_C09'

UNION ALL

SELECT tenant_id, id, 'POS001', 'Production Engineer', 'Production Engineer', 'ACTIVE'
FROM companies WHERE company_code = 'DEMO_C10';


-- =========================================================
-- EMPLOYMENTS - 10 ROWS
-- =========================================================

INSERT INTO employments
(
    tenant_id,
    employee_id,
    company_id,
    department_id,
    job_position_id,
    start_date,
    end_date,
    status
)

SELECT
    c.tenant_id,
    e.id,
    c.id,
    d.id,
    jp.id,
    '2024-01-10',
    NULL,
    'ACTIVE'
FROM employees e
         JOIN companies c
              ON e.company_id = c.id
         JOIN departments d
              ON d.company_id = c.id
                  AND d.department_code = 'DEP001'
         JOIN job_positions jp
              ON jp.company_id = c.id
                  AND jp.position_code = 'POS001'
WHERE c.company_code = 'DEMO_C01'
  AND e.employee_code = 'EMP001'

UNION ALL

SELECT
    c.tenant_id,
    e.id,
    c.id,
    d.id,
    jp.id,
    '2024-02-15',
    NULL,
    'ACTIVE'
FROM employees e
         JOIN companies c ON e.company_id = c.id
         JOIN departments d
              ON d.company_id = c.id
                  AND d.department_code = 'DEP002'
         JOIN job_positions jp
              ON jp.company_id = c.id
                  AND jp.position_code = 'POS002'
WHERE c.company_code = 'DEMO_C01'
  AND e.employee_code = 'EMP002'

UNION ALL

SELECT
    c.tenant_id,
    e.id,
    c.id,
    d.id,
    jp.id,
    '2024-03-20',
    '2025-03-20',
    'ENDED'
FROM employees e
         JOIN companies c ON e.company_id = c.id
         JOIN departments d
              ON d.company_id = c.id
                  AND d.department_code = 'DEP003'
         JOIN job_positions jp
              ON jp.company_id = c.id
                  AND jp.position_code = 'POS003'
WHERE c.company_code = 'DEMO_C01'
  AND e.employee_code = 'EMP003'

UNION ALL

SELECT
    c.tenant_id,
    e.id,
    c.id,
    d.id,
    jp.id,
    '2024-04-05',
    NULL,
    'ACTIVE'
FROM employees e
         JOIN companies c ON e.company_id = c.id
         JOIN departments d
              ON d.company_id = c.id
                  AND d.department_code = 'DEP001'
         JOIN job_positions jp
              ON jp.company_id = c.id
                  AND jp.position_code = 'POS001'
WHERE c.company_code = 'DEMO_C02'
  AND e.employee_code = 'EMP001'

UNION ALL

SELECT
    c.tenant_id,
    e.id,
    c.id,
    d.id,
    jp.id,
    '2023-11-10',
    NULL,
    'ACTIVE'
FROM employees e
         JOIN companies c ON e.company_id = c.id
         JOIN departments d
              ON d.company_id = c.id
                  AND d.department_code = 'DEP001'
         JOIN job_positions jp
              ON jp.company_id = c.id
                  AND jp.position_code = 'POS001'
WHERE c.company_code = 'DEMO_C04'
  AND e.employee_code = 'EMP001'

UNION ALL

SELECT
    c.tenant_id,
    e.id,
    c.id,
    d.id,
    jp.id,
    '2024-05-17',
    '2025-01-31',
    'TERMINATED'
FROM employees e
         JOIN companies c ON e.company_id = c.id
         JOIN departments d
              ON d.company_id = c.id
                  AND d.department_code = 'DEP002'
         JOIN job_positions jp
              ON jp.company_id = c.id
                  AND jp.position_code = 'POS002'
WHERE c.company_code = 'DEMO_C04'
  AND e.employee_code = 'EMP002'

UNION ALL

SELECT
    c.tenant_id,
    e.id,
    c.id,
    d.id,
    jp.id,
    '2025-01-05',
    NULL,
    'ACTIVE'
FROM employees e
         JOIN companies c ON e.company_id = c.id
         JOIN departments d
              ON d.company_id = c.id
                  AND d.department_code = 'DEP001'
         JOIN job_positions jp
              ON jp.company_id = c.id
                  AND jp.position_code = 'POS001'
WHERE c.company_code = 'DEMO_C07'
  AND e.employee_code = 'EMP001'

UNION ALL

SELECT
    c.tenant_id,
    e.id,
    c.id,
    d.id,
    jp.id,
    '2025-02-11',
    NULL,
    'ACTIVE'
FROM employees e
         JOIN companies c ON e.company_id = c.id
         JOIN departments d
              ON d.company_id = c.id
                  AND d.department_code = 'DEP002'
         JOIN job_positions jp
              ON jp.company_id = c.id
                  AND jp.position_code = 'POS002'
WHERE c.company_code = 'DEMO_C07'
  AND e.employee_code = 'EMP002'

UNION ALL

SELECT
    c.tenant_id,
    e.id,
    c.id,
    d.id,
    jp.id,
    '2025-03-01',
    NULL,
    'ACTIVE'
FROM employees e
         JOIN companies c ON e.company_id = c.id
         JOIN departments d
              ON d.company_id = c.id
                  AND d.department_code = 'DEP001'
         JOIN job_positions jp
              ON jp.company_id = c.id
                  AND jp.position_code = 'POS001'
WHERE c.company_code = 'DEMO_C09'
  AND e.employee_code = 'EMP001'

UNION ALL

SELECT
    c.tenant_id,
    e.id,
    c.id,
    d.id,
    jp.id,
    '2025-04-12',
    '2026-01-15',
    'ENDED'
FROM employees e
         JOIN companies c ON e.company_id = c.id
         JOIN departments d
              ON d.company_id = c.id
                  AND d.department_code = 'DEP001'
         JOIN job_positions jp
              ON jp.company_id = c.id
                  AND jp.position_code = 'POS001'
WHERE c.company_code = 'DEMO_C10'
  AND e.employee_code = 'EMP001';



