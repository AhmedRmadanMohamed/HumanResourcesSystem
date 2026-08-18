-- =========================================================
-- 1) CREATE ALL TABLES FIRST
-- =========================================================

CREATE TABLE users (
                       id int NOT NULL,
                       is_activated bit(1) DEFAULT NULL,
                       status bit(1) DEFAULT NULL,
                       created_date datetime(6) DEFAULT NULL,
                       email varchar(255) NOT NULL,
                       password varchar(255) DEFAULT NULL,
                       PRIMARY KEY (id)
)
    ENGINE = INNODB,
    AVG_ROW_LENGTH = 1638,
    CHARACTER SET utf8mb4,
    COLLATE utf8mb4_0900_ai_ci;


CREATE TABLE roles (
                       id int NOT NULL AUTO_INCREMENT,
                       role_name varchar(255) DEFAULT NULL,
                       PRIMARY KEY (id)
)
    ENGINE = INNODB,
    AUTO_INCREMENT = 11,
    AVG_ROW_LENGTH = 1638,
    CHARACTER SET utf8mb4,
    COLLATE utf8mb4_0900_ai_ci;


CREATE TABLE cities (
                        id int NOT NULL AUTO_INCREMENT,
                        city_name varchar(255) DEFAULT NULL,
                        PRIMARY KEY (id)
)
    ENGINE = INNODB,
    AUTO_INCREMENT = 11,
    AVG_ROW_LENGTH = 1638,
    CHARACTER SET utf8mb4,
    COLLATE utf8mb4_0900_ai_ci;


CREATE TABLE cities_seq (
                            next_val bigint DEFAULT NULL
)
    ENGINE = INNODB,
    CHARACTER SET utf8mb4,
    COLLATE utf8mb4_0900_ai_ci;


CREATE TABLE jobpositions (
                              id int NOT NULL AUTO_INCREMENT,
                              position_name varchar(255) DEFAULT NULL,
                              PRIMARY KEY (id)
)
    ENGINE = INNODB,
    AUTO_INCREMENT = 11,
    AVG_ROW_LENGTH = 1638,
    CHARACTER SET utf8mb4,
    COLLATE utf8mb4_0900_ai_ci;


CREATE TABLE workplaces (
                            id int NOT NULL AUTO_INCREMENT,
                            name varchar(255) DEFAULT NULL,
                            PRIMARY KEY (id)
)
    ENGINE = INNODB,
    AUTO_INCREMENT = 11,
    AVG_ROW_LENGTH = 1638,
    CHARACTER SET utf8mb4,
    COLLATE utf8mb4_0900_ai_ci;


CREATE TABLE worktimes (
                           id int NOT NULL AUTO_INCREMENT,
                           name varchar(255) DEFAULT NULL,
                           PRIMARY KEY (id)
)
    ENGINE = INNODB,
    AUTO_INCREMENT = 11,
    AVG_ROW_LENGTH = 1638,
    CHARACTER SET utf8mb4,
    COLLATE utf8mb4_0900_ai_ci;


CREATE TABLE employers (
                           id bigint NOT NULL AUTO_INCREMENT,
                           company_name varchar(255) DEFAULT NULL,
                           phone_number varchar(255) DEFAULT NULL,
                           website varchar(255) DEFAULT NULL,
                           user_id int DEFAULT NULL,
                           PRIMARY KEY (id)
)
    ENGINE = INNODB,
    AUTO_INCREMENT = 11,
    AVG_ROW_LENGTH = 1638,
    CHARACTER SET utf8mb4,
    COLLATE utf8mb4_0900_ai_ci;


CREATE TABLE jobseekers (
                            birth_date date DEFAULT NULL,
                            id int NOT NULL AUTO_INCREMENT,
                            preferred_position_id int DEFAULT NULL,
                            user_id int DEFAULT NULL,
                            nationality_id bigint DEFAULT NULL,
                            first_name varchar(255) DEFAULT NULL,
                            github varchar(255) DEFAULT NULL,
                            last_name varchar(255) DEFAULT NULL,
                            linkedin varchar(255) DEFAULT NULL,
                            bio text DEFAULT NULL,
                            PRIMARY KEY (id)
)
    ENGINE = INNODB,
    AUTO_INCREMENT = 11,
    AVG_ROW_LENGTH = 1638,
    CHARACTER SET utf8mb4,
    COLLATE utf8mb4_0900_ai_ci;


CREATE TABLE userroles (
                           role_id int NOT NULL,
                           user_id int NOT NULL,
                           PRIMARY KEY (role_id, user_id)
)
    ENGINE = INNODB,
    AVG_ROW_LENGTH = 1638,
    CHARACTER SET utf8mb4,
    COLLATE utf8mb4_0900_ai_ci;


CREATE TABLE jobs (
                      id bigint NOT NULL AUTO_INCREMENT,
                      created_at datetime(6) DEFAULT NULL,
                      deadline datetime(6) DEFAULT NULL,
                      description text DEFAULT NULL,
                      max_salary decimal(10, 2) DEFAULT NULL,
                      min_salary decimal(10, 2) DEFAULT NULL,
                      number_of_vacancies int DEFAULT NULL,
                      is_active bit(1) DEFAULT NULL,
                      city_id int DEFAULT NULL,
                      employer_id bigint DEFAULT NULL,
                      position_id int DEFAULT NULL,
                      workplace_id int DEFAULT NULL,
                      work_time_id int DEFAULT NULL,
                      PRIMARY KEY (id)
)
    ENGINE = INNODB,
    AUTO_INCREMENT = 11,
    AVG_ROW_LENGTH = 1638,
    CHARACTER SET utf8mb4,
    COLLATE utf8mb4_0900_ai_ci;


-- =========================================================
-- 2) UNIQUE INDEXES
-- =========================================================

ALTER TABLE users
    ADD UNIQUE INDEX UK6dotkott2kjsp8vw4d0m25fb7 (email);

ALTER TABLE roles
    ADD UNIQUE INDEX UK716hgxp60ym1lifrdgp67xt5k (role_name);


-- =========================================================
-- 3) FOREIGN KEYS
-- =========================================================

-- Employers -> Users
ALTER TABLE employers
    ADD CONSTRAINT FK6abfx371o1dsomsi0jstr0utl
        FOREIGN KEY (user_id)
            REFERENCES users (id);


-- Jobseekers -> Users
ALTER TABLE jobseekers
    ADD CONSTRAINT FKs8pwyc4q7ufu6n8f1ki8dftdb
        FOREIGN KEY (user_id)
            REFERENCES users (id);


-- Jobseekers -> Job Positions
ALTER TABLE jobseekers
    ADD CONSTRAINT FKsxoqg8edgiau8tenmglp4cf5p
        FOREIGN KEY (preferred_position_id)
            REFERENCES jobpositions (id);


-- User Roles -> Roles
ALTER TABLE userroles
    ADD CONSTRAINT FK1kbnhele2bs3c8vf71u7a7jqf
        FOREIGN KEY (role_id)
            REFERENCES roles (id);


-- User Roles -> Users
ALTER TABLE userroles
    ADD CONSTRAINT FK1t84g5bkfp9cghk2qba4844yb
        FOREIGN KEY (user_id)
            REFERENCES users (id);


-- Jobs -> Workplaces
ALTER TABLE jobs
    ADD CONSTRAINT FK1p37qnokndboyn50q9wnj8j2t
        FOREIGN KEY (workplace_id)
            REFERENCES workplaces (id);


-- Jobs -> Work Times
ALTER TABLE jobs
    ADD CONSTRAINT FK2d94p4gvmdlx2dhm9pyksgph0
        FOREIGN KEY (work_time_id)
            REFERENCES worktimes (id);


-- Jobs -> Job Positions
ALTER TABLE jobs
    ADD CONSTRAINT FK51o3p9u8xcmgqbjqi2d0apne2
        FOREIGN KEY (position_id)
            REFERENCES jobpositions (id);


-- Jobs -> Cities
ALTER TABLE jobs
    ADD CONSTRAINT FKeg3tcklkkgem8erx34qux1xx1
        FOREIGN KEY (city_id)
            REFERENCES cities (id);


-- Jobs -> Employers
ALTER TABLE jobs
    ADD CONSTRAINT FKja6e4osjhsx4wodgd2os82890
        FOREIGN KEY (employer_id)
            REFERENCES employers (id);