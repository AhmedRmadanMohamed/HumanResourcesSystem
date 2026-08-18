<div align="center">

# 👥 Human Resources System

**A tenant-aware HR backend for managing people, roles, employers, job seekers, and job positions through a clean Spring Boot architecture.**

![Java](https://img.shields.io/badge/Java-23-E76F00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-REST_API-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-Database-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Flyway](https://img.shields.io/badge/Flyway-Migrations-CC0200?style=for-the-badge&logo=flyway&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

</div>

---

## ✨ Overview

Human Resources System is a Java backend that models the core workflows of an HR platform. The current implementation combines a layered REST architecture with a tenant-aware domain model, relational persistence, DTO mapping, and versioned database migrations.

The project is an evolving backend implementation and currently focuses on the domain and data-access foundations of the platform.

## 🚀 Highlights

- Tenant-aware entities and lifecycle handling.
- User, role, employer, job-seeker, workplace, work-time, and job-position models.
- REST controllers backed by service and repository layers.
- DTOs and dedicated mappers for API-facing data.
- Generic CRUD operations for reusable data-access behavior.
- Flyway migrations for the baseline schema, tenants, and companies.
- Repository and application-level tests.
- MySQL for persistent environments and H2 for lightweight development or testing scenarios.

## 🧱 Architecture

```text
HTTP Request
    │
    ▼
Controllers ──► Services ──► Repositories ──► MySQL / H2
                    │
                    ├──► DTOs & Mappers
                    └──► Tenant-aware Entities
```

```text
src/
├── main/
│   ├── java/HumanResourcesPackage/
│   │   ├── Controllers/
│   │   ├── Services/
│   │   ├── Repositorys/
│   │   ├── Entitys/
│   │   ├── DTOs/
│   │   ├── Mappers/
│   │   ├── Listeners/
│   │   └── OperationsImplementation/
│   └── resources/
│       ├── application.properties
│       └── db/migration/
└── test/
```

## 🧩 Domain Coverage

| Area | Main models |
|---|---|
| Identity & access | Users, roles, user-role assignments |
| Tenancy | Tenants and tenant entity lifecycle |
| Recruitment | Job seekers, employers, jobs, and job positions |
| Organization | Workplaces, work times, cities, and companies |

## 🔌 API Snapshot

| Method | Path | Purpose |
|---|---|---|
| `GET` | `/GetAllEmploye` | List employers |
| `GET` | `/JobPosition/GetAllPosition` | List job positions |
| `POST` | `/JobPosition/Add` | Add a job position |
| `GET` | `/UsersInformation/GetInformationUserOfRoleName` | Retrieve user information by role |

> The API is still evolving. Treat the paths above as a snapshot of the current implementation.

## ⚙️ Getting Started

### Prerequisites

- JDK 23
- Maven
- MySQL

### Configure the application

Set the local database connection in `src/main/resources/application.properties`:

```properties
spring.datasource.url=<your-jdbc-url>
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>
```

Do not commit real credentials. Use environment-specific configuration or a secret manager for any shared or deployed environment.

### Run

```bash
git clone https://github.com/AhmedRmadanMohamed/HumanResourcesSystem.git
cd HumanResourcesSystem
mvn spring-boot:run
```

Flyway applies the versioned migrations when the application starts.

### Test

```bash
mvn test
```

## 🗺️ Roadmap

- Complete the remaining HR use cases and validation rules.
- Expand controller and service test coverage.
- Add authentication and role-based authorization.
- Publish an OpenAPI contract for the REST endpoints.
- Add an automated build and test workflow.

---

<div align="center">

Built as a practical Java and Spring Boot HR backend project.

</div>
