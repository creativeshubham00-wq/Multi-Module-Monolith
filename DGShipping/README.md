# DGShipping

Maven multi-module project. Java 21, Spring Boot 4.1.1, layered architecture, JPA + H2.

## Structure

```
DGShipping/                     <- parent (packaging=pom, no jar itself)
├── pom.xml
├── common/                      <- shared library (BaseEntity, DTOs, exceptions, utils, config) - plain jar
├── casualty-investigation/      <- Spring Boot app, port 8082, depends on common
├── education-training/          <- Spring Boot app, port 8083, depends on common
└── safety-circulars-dms/        <- Spring Boot app, port 8084, depends on common
```

## Layered architecture (inside each business module)

Every app module (`casualty-investigation`, `education-training`, `safety-circulars-dms`)
follows the same layering:

```
com.dgshipping.<module>/
├── controller/     <- REST endpoints only. Validates input, delegates to service, returns ApiResponse<T>.
├── service/         <- interface = the contract
│   └── impl/         <- implementation = the actual business logic, talks to the repository
├── repository/     <- Spring Data JPA interfaces, no logic, pure data access
├── entity/          <- @Entity classes, extend common's BaseEntity for id + audit timestamps
├── dto/             <- Request/Response objects — never expose the entity directly over HTTP
├── mapper/          <- converts entity <-> dto, keeps that logic out of the service
└── <Module>Application.java   <- main class
```

Request flow: `Controller -> Service (interface) -> ServiceImpl -> Repository -> Database`,
with `Mapper` converting between `Entity` and `DTO` at the service boundary. Each layer only
knows about the layer directly below it — controllers never touch the repository directly,
and services never build HTTP-specific objects.

| Module | Entity | Endpoints |
|---|---|---|
| casualty-investigation | `CasualtyReport` | `/api/casualty-reports` |
| education-training | `TrainingCourse` | `/api/training-courses` |
| safety-circulars-dms | `SafetyCircular` | `/api/safety-circulars` |

Each supports standard CRUD: `POST /`, `GET /`, `GET /{id}`, `PUT /{id}`, `DELETE /{id}`.

## What's in `common`

- `entity.BaseEntity` — `@MappedSuperclass` with `id`, `createdAt`, `updatedAt`; every module's
  entity extends this instead of redefining those fields
- `dto.ApiResponse<T>` — shared response envelope every controller returns
- `exception.ResourceNotFoundException` + `exception.GlobalExceptionHandler` — consistent
  error responses across all modules
- `util.DateUtils` — shared date formatting helpers
- `config.CommonWebConfig` — shared CORS config
- `config.JpaAuditingConfig` — `@EnableJpaAuditing`, so `BaseEntity`'s timestamps get
  populated automatically (picked up because each app `@ComponentScan`s `com.dgshipping.common`)

Add any other cross-cutting implementation here (security config, common constants, shared
service interfaces, a base repository, etc.).

## How the wiring works

- The **root pom** (`packaging=pom`) inherits `spring-boot-starter-parent`, lists all
  modules, and declares shared dependencies (`spring-boot-starter-web`,
  `spring-boot-starter-data-jpa`, `spring-boot-starter-validation`, `h2`) so every child
  inherits them automatically.
- **`common`** has `packaging=jar` but deliberately has **no** `spring-boot-maven-plugin`
  execution — it's a library, not a runnable app.
- Each app module declares `common` as a dependency, has its own `mainClass`, and
  `@ComponentScan`s both its own package and `com.dgshipping.common`.
- Each app module has its own **in-memory H2 database** (a different DB name per module —
  `casualtydb`, `educationdb`, `safetycircularsdb`) so they don't collide, and
  `spring.jpa.hibernate.ddl-auto=update` auto-creates tables from the entities on startup.
  The H2 console is enabled per module at `/h2-console`.

## Build everything from the root

```bash
cd DGShipping
mvn clean install
```

Maven's reactor builds `common` first, then the three apps:

```
common/target/common-1.0.0.jar
casualty-investigation/target/casualty-investigation.jar
education-training/target/education-training.jar
safety-circulars-dms/target/safety-circulars-dms.jar
```

## Build/run just one module

```bash
mvn install -pl common
mvn clean install -pl casualty-investigation
```

Or in one line with `-am` (auto-builds `common` if not already installed):

```bash
mvn clean install -pl casualty-investigation -am
```

## Run a module from source, without creating a jar

```bash
cd casualty-investigation
mvn spring-boot:run
```

Or from the root: `mvn spring-boot:run -pl casualty-investigation`

## Run a built jar

```bash
java -jar casualty-investigation/target/casualty-investigation.jar
```

## Run all three modules at once

```bash
mvn install -pl common
mvn spring-boot:run -pl casualty-investigation > casualty-investigation.log 2>&1 &
mvn spring-boot:run -pl education-training > education-training.log 2>&1 &
mvn spring-boot:run -pl safety-circulars-dms > safety-circulars-dms.log 2>&1 &
```

Watch any one's log with `tail -f casualty-investigation.log`. Stop them all with
`pkill -f spring-boot:run`.

## Try the API (example: casualty-investigation module)

```bash
# create
curl -X POST http://localhost:8082/api/casualty-reports \
  -H "Content-Type: application/json" \
  -d '{"vesselName":"MV Horizon","incidentDate":"2026-01-15","description":"Engine room fire"}'

# list all
curl http://localhost:8082/api/casualty-reports

# get one
curl http://localhost:8082/api/casualty-reports/1

# update
curl -X PUT http://localhost:8082/api/casualty-reports/1 \
  -H "Content-Type: application/json" \
  -d '{"vesselName":"MV Horizon","incidentDate":"2026-01-15","description":"Engine room fire - updated report"}'

# delete
curl -X DELETE http://localhost:8082/api/casualty-reports/1
```

The other two modules follow the same pattern on their own port and endpoint (see the
table above).

## Adding shared code

Put new shared classes under `common/src/main/java/com/dgshipping/common/...`, then
`mvn install -pl common` so the other modules pick up the updated jar from the local repo.

## Adding a brand-new module

1. Copy an existing app module folder (including its `controller/service/repository/
   entity/dto/mapper` layout), rename it, update `artifactId`/`finalName`/`mainClass` in
   its `pom.xml` and rename the packages.
2. Add `<module>your-module</module>` to the root `pom.xml`.
3. Give it its own H2 database name and port in `application.yml` to avoid collisions with
   other modules.
