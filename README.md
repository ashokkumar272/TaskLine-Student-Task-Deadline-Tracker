# TaskLine 📋

A **RESTful Task Management API** built with **Spring Boot 4.0** and **Java 17**, demonstrating industry-standard backend development practices and clean architecture principles.

---

## 🎯 Project Overview

TaskLine is a backend service that enables users to manage tasks with deadlines. It showcases my proficiency in building production-ready APIs following best practices in software design.

### Key Highlights
- Clean **3-tier architecture** (Controller → Service → Repository)
- **DTO pattern** for request/response handling
- **Custom exception handling** with meaningful error responses
- **Input validation** using Jakarta Bean Validation
- **JPA/Hibernate** for database operations

---

## 🛠️ Tech Stack

| Technology | Purpose |
|------------|---------|
| **Java 17** | Core programming language |
| **Spring Boot 4.0** | Application framework |
| **Spring Data JPA** | Data persistence layer |
| **Hibernate** | ORM framework |
| **MySQL** | Relational database |
| **Maven** | Build & dependency management |
| **Jakarta Validation** | Input validation |

---

## 📐 Architecture

```
src/main/java/com/example/taskline/
├── controller/          # REST API endpoints
│   └── TaskController.java
├── service/             # Business logic layer
│   ├── TaskService.java (Interface)
│   └── TaskServiceImpl.java
├── repository/          # Data access layer
│   └── TaskRepository.java
├── entity/              # JPA entities
│   ├── Task.java
│   └── TaskStatus.java
├── dto/                 # Data Transfer Objects
│   ├── TaskCreateRequest.java
│   └── TaskResponse.java
├── exception/           # Custom exception handling
│   ├── GlobalExceptionHandler.java
│   └── ResourceNotFoundException.java
└── TaskLineApplication.java
```

---

## 🔌 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/tasks` | Create a new task |
| `GET` | `/api/tasks` | Retrieve all tasks |
| `GET` | `/api/tasks/{id}` | Get task by ID |
| `PUT` | `/api/tasks/{id}/done` | Mark task as completed |
| `DELETE` | `/api/tasks/{id}` | Delete a task |
| `GET` | `/api/tasks/upcoming?hours=48` | Get tasks with deadlines within specified hours |

### Sample Request & Response

**Create Task:**
```json
POST /api/tasks
{
  "title": "Complete project documentation",
  "description": "Write comprehensive README for portfolio",
  "deadline": "2026-02-05T18:00:00"
}
```

**Response:**
```json
{
  "id": 1,
  "title": "Complete project documentation",
  "description": "Write comprehensive README for portfolio",
  "deadline": "2026-02-05T18:00:00",
  "status": "PENDING"
}
```

---

## ✨ Features & Design Decisions

### 1. **DTO Pattern**
Separates internal entity structure from API contracts, providing flexibility and security by controlling exposed data.

### 2. **Service Interface**
`TaskService` interface with `TaskServiceImpl` implementation enables loose coupling and easier unit testing.

### 3. **Global Exception Handling**
Centralized exception handling using `@RestControllerAdvice` provides consistent error responses:
- `ResourceNotFoundException` → 404 Not Found
- Validation errors → 400 Bad Request with field-level messages

### 4. **Input Validation**
Uses Jakarta Bean Validation annotations (`@NotBlank`, `@NotNull`) to ensure data integrity at the API layer.

### 5. **Custom Query Methods**
JPA derived query `findByDeadlineBetween()` demonstrates understanding of Spring Data query creation.

### 6. **Environment-Based Configuration**
Database credentials configured via environment variables for security best practices.

---

## 🚀 Getting Started

### Prerequisites
- Java 17+
- Maven 3.6+
- MySQL 8.0+

### Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/taskline.git
   cd taskline
   ```

2. **Configure database**
   
   Create a MySQL database:
   ```sql
   CREATE DATABASE taskManager;
   ```

3. **Set environment variables** (or use defaults in `application.properties`)
   ```bash
   export DB_URL=jdbc:mysql://localhost:3306/taskManager
   export DB_USERNAME=your_username
   export DB_PASSWORD=your_password
   ```

4. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```

5. **Access the API**
   ```
   http://localhost:8080/api/tasks
   ```

---

## 📚 Skills Demonstrated

- **Backend Development:** Building RESTful APIs with Spring Boot
- **Database Design:** Entity modeling and JPA relationships
- **Clean Code:** Separation of concerns, SOLID principles
- **Error Handling:** Custom exceptions with meaningful responses
- **Validation:** Input sanitization and validation
- **Version Control:** Git-based project management

---

## 🔮 Future Enhancements

- [ ] Add pagination and sorting for task lists
- [ ] Implement task categories/labels
- [ ] Add user authentication with Spring Security
- [ ] Integrate Swagger/OpenAPI documentation
- [ ] Write unit and integration tests
- [ ] Containerize with Docker

---

## 👨‍💻 Author

**Ashok**  
*Aspiring Software Developer*

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Connect-blue)]()
[![GitHub](https://img.shields.io/badge/GitHub-Follow-black)]()

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).
