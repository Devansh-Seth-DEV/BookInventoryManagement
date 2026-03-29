# Book Inventory Management System

A Spring Boot application for managing book inventories, users, and transactions. 

This project follows a strict layered architecture to ensure scalability and maintainability.

## 🚀 Tech Stack

* **Language:** Java 21+
* **Framework:** Spring Boot 4.x
* **Data Access:** Spring Data JPA (Hibernate)
* **Database:** MySQL
* **Build Tool:** Maven

---

## 🏗 Project Structure & Standards

The project follows a specific package-level hierarchy under `com.bookinventory`.

| Package            | Purpose               | Naming/Coding Rules                                                    |
|:------------------ |:--------------------- |:---------------------------------------------------------------------- |
| **.model**         | Database Entities     | Includes Entity, Junction, and Transaction tables.                     |
| **.dto**           | Data Transfer Objects | **Constraint:** Must only have a DEFAULT constructor.                  |
| **.dto.converter** | Model-DTO Mapping     | Must use `public static` methods: `convert(Model)` and `convert(DTO)`. |
| **.repository**    | Data Access Layer     | Classes must end with `Repository`.                                    |
| **.service**       | Business Logic        | Interfaces end with `Service`; Implementations end with `Impl`.        |
| **.api**           | Web Controllers       | Annotated with `@RestController`; end with `Controller`.               |
| **.exception**     | Error Handling        | Custom and Global classes; must end with `Exception`.                  |

## 🌐 API & Routing Standards

All controllers must follow a strict annotation and naming pattern to keep the API predictable.

### 1. Annotations & Naming

* **@RestController**: Every controller must use this annotation (no standard `@Controller`).
* **Naming**: Class names must end with `Controller` (e.g., `BookController`).

### 2. Root URL Formatting

Every controller must define a root URL using `@RequestMapping` that **includes a trailing slash**.

**Example:**

```java
@RestController
@RequestMapping("/user/") // Required trailing slash
public class UserController {
    // Endpoints here
}
```

### 📂 Folder Tree Visual

```text
src/main/java/com/bookinventory/
├── api/             # Controllers (@RestController)
├── dto/             # Data Transfer Objects
│   └── converter/   # Static Model <-> DTO mappers
├── exception/       # Custom & Global Exception Handlers
├── model/           # JPA Entities
├── repository/      # JpaRepository Interfaces
└── service/         # Business Logic (Interface + Impl)
```
