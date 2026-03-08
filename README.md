# Hospital Management Database System

A Spring Boot application for managing hospital operations using JPA/Hibernate and MySQL. Currently implements basic CRUD operations for the Doctor entity with plans to expand to other healthcare management modules.

## 📋 Table of Contents

- [Features](#features)
- [Technology Stack](#technology-stack)
- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Configuration](#configuration)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [Usage Examples](#usage-examples)
- [Implemented Features](#implemented-features)
- [Upcoming Features](#upcoming-features)
- [Database Schema](#database-schema)

---

## ✨ Features

### Currently Implemented

- ✅ **Doctor Management** - Full CRUD operations
  - Create new doctors
  - Retrieve doctor information (by ID or all)
  - Update doctor details (partial and complete updates)
  - Delete doctor records
  - Get total count of doctors

### Planned Features

- 🔄 Patient Management
- 🔄 Appointment Management
- 🔄 Department Management
- 🔄 Staff Management
- 🔄 Hospital Services/Treatments

---

## 🛠 Technology Stack

| Technology          | Version | Purpose                 |
| ------------------- | ------- | ----------------------- |
| **Java**            | 21      | Programming Language    |
| **Spring Boot**     | 3.5.11  | Framework               |
| **Spring Data JPA** | Latest  | ORM Layer               |
| **Hibernate**       | Latest  | JPA Implementation      |
| **MySQL**           | 5.7+    | Database                |
| **Lombok**          | Latest  | Reduce Boilerplate Code |
| **Maven**           | 4.0.0   | Build Tool              |

---

## 📦 Prerequisites

Before running the application, ensure you have:

1. **Java 21** - [Download here](https://www.oracle.com/java/technologies/downloads/#java21)
2. **MySQL Server** - [Download here](https://dev.mysql.com/downloads/mysql/)
3. **Maven** - [Download here](https://maven.apache.org/download.cgi)
4. **Git** (optional)
5. **Postman or any REST client** - For API testing

---

## 📁 Project Structure

```
hospital-management-db/
├── src/
│   ├── main/
│   │   ├── java/com/jpahibernate/hospital_management_db/
│   │   │   ├── HospitalManagementDbApplication.java          # Main Spring Boot Application
│   │   │   ├── controller/
│   │   │   │   └── DoctorController.java                    # REST API Controller for Doctor
│   │   │   ├── service/
│   │   │   │   └── DoctorService.java                       # Business Logic Layer
│   │   │   ├── repository/
│   │   │   │   └── DoctorRepository.java                    # Data Access Layer
│   │   │   └── model/
│   │   │       └── Doctor.java                              # Entity Class
│   │   └── resources/
│   │       ├── application.properties                        # Configuration File
│   │       ├── static/                                       # Static Resources
│   │       └── templates/                                    # Template Files
│   └── test/
│       └── java/.../HospitalManagementDbApplicationTests.java
├── pom.xml                                                   # Maven Configuration
├── mvnw & mvnw.cmd                                          # Maven Wrapper
└── README.md                                                # This File
```

---

## ⚙️ Configuration

### Database Configuration

Update `application.properties` to match your MySQL setup:

```properties
# MySQL Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/hospital_db
spring.datasource.username=root
spring.datasource.password=Sanket123

# Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update        # Hibernate will update schema automatically
spring.jpa.show-sql=true                     # Show SQL queries in console
spring.jpa.properties.hibernate.format_sql=true  # Format SQL output

# Server Configuration
server.port=7799
spring.application.name=hospital-management-db
```

### Database Setup

Create the database before running the application:

```sql
CREATE DATABASE hospital_db;
USE hospital_db;
```

The application will automatically create the `doctor` table using Hibernate.

---

## 🚀 Getting Started

### 1. Clone/Download the Project

```bash
cd hospital-management-db
```

### 2. Build the Project

```bash
mvn clean install
```

Or using Maven wrapper:

```bash
./mvnw clean install          # On Linux/Mac
mvnw.cmd clean install        # On Windows
```

### 3. Run the Application

```bash
mvn spring-boot:run
```

Or using Maven wrapper:

```bash
./mvnw spring-boot:run        # On Linux/Mac
mvnw.cmd spring-boot:run      # On Windows
```

### 4. Verify Application is Running

Visit: `http://localhost:7799/doctor/apis/test`

Expected Response: `"Working"`

---

## 📡 API Endpoints

All endpoints are prefixed with: `http://localhost:7799/doctor/apis`

### Doctor Management Endpoints

| HTTP Method | Endpoint            | Description                          | Request Body     |
| ----------- | ------------------- | ------------------------------------ | ---------------- |
| **POST**    | `/saveDoctor`       | Create a new doctor                  | Doctor JSON      |
| **GET**     | `/findById/{id}`    | Retrieve doctor by ID                | -                |
| **GET**     | `/getAll`           | Retrieve all doctors                 | -                |
| **DELETE**  | `/deleteById/{id}`  | Delete doctor by ID                  | -                |
| **GET**     | `/count`            | Get total number of doctors          | -                |
| **PUT**     | `/updatePut/{id}`   | Update entire doctor record          | Doctor JSON      |
| **PATCH**   | `/updatePatch/{id}` | Update specific fields (name, email) | Query Parameters |

---

## 📝 Usage Examples

### 1. Create a New Doctor (POST)

**Request:**

```bash
POST http://localhost:7799/doctor/apis/saveDoctor
Content-Type: application/json

{
  "id": 1,
  "name": "Dr. John Smith",
  "email": "john.smith@hospital.com",
  "specialization": "Cardiology",
  "dob": "1985-05-15",
  "phone": "9876543210"
}
```

**Response:**

```json
"Doctor Saved Successfully"
```

---

### 2. Retrieve Doctor by ID (GET)

**Request:**

```bash
GET http://localhost:7799/doctor/apis/findById/1
```

**Response:**

```json
{
  "id": 1,
  "name": "Dr. John Smith",
  "email": "john.smith@hospital.com",
  "specialization": "Cardiology",
  "dob": "1985-05-15",
  "phone": "9876543210"
}
```

---

### 3. Retrieve All Doctors (GET)

**Request:**

```bash
GET http://localhost:7799/doctor/apis/getAll
```

**Response:**

```json
[
  {
    "id": 1,
    "name": "Dr. John Smith",
    "email": "john.smith@hospital.com",
    "specialization": "Cardiology",
    "dob": "1985-05-15",
    "phone": "9876543210"
  },
  {
    "id": 2,
    "name": "Dr. Sarah Johnson",
    "email": "sarah.johnson@hospital.com",
    "specialization": "Neurology",
    "dob": "1990-03-20",
    "phone": "9876543211"
  }
]
```

---

### 4. Update Entire Doctor Record (PUT)

**Request:**

```bash
PUT http://localhost:7799/doctor/apis/updatePut/1
Content-Type: application/json

{
  "id": 1,
  "name": "Dr. John Smith Updated",
  "email": "john.updated@hospital.com",
  "specialization": "Cardiology & Internal Medicine",
  "dob": "1985-05-15",
  "phone": "9876543210"
}
```

**Response:**

```json
"Doctor updated successfully using PUT"
```

---

### 5. Update Specific Fields (PATCH)

**Request:**

```bash
PATCH http://localhost:7799/doctor/apis/updatePatch/1?newName=Dr.%20John%20New&newEmail=john.new@hospital.com
```

**Response:**

```json
"Doctor Updated Successfully using PATCH"
```

---

### 6. Delete Doctor (DELETE)

**Request:**

```bash
DELETE http://localhost:7799/doctor/apis/deleteById/1
```

**Response:**

```json
"Doctor with id: 1 Deleted!"
```

---

### 7. Get Doctor Count (GET)

**Request:**

```bash
GET http://localhost:7799/doctor/apis/count
```

**Response:**

```json
"No. of Doctors: 5"
```

---

## 📊 Database Schema

### Doctor Table

```sql
CREATE TABLE doctor (
  id INT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL UNIQUE,
  specialization VARCHAR(100) NOT NULL,
  dob VARCHAR(20) NOT NULL,
  phone VARCHAR(15) NOT NULL UNIQUE
);
```

### Doctor Entity Attributes

| Field            | Type    | Constraints      | Description                               |
| ---------------- | ------- | ---------------- | ----------------------------------------- |
| `id`             | Integer | PRIMARY KEY      | Unique doctor identifier                  |
| `name`           | String  | NOT NULL         | Full name of the doctor                   |
| `email`          | String  | NOT NULL, UNIQUE | Official email address                    |
| `specialization` | String  | NOT NULL         | Medical specialization (e.g., Cardiology) |
| `dob`            | String  | NOT NULL         | Date of birth                             |
| `phone`          | String  | NOT NULL, UNIQUE | Contact phone number                      |

---

## ✅ Implemented Features

### Doctor Controller (`DoctorController.java`)

- Handles all HTTP requests related to doctor management
- Uses `@RestController` annotation for RESTful API
- Implements GET, POST, PUT, DELETE, and PATCH operations
- Uses `@PathVariable` for URL path parameters
- Uses `@RequestBody` for JSON request bodies
- Uses `@RequestParam` for query parameters

### Doctor Service (`DoctorService.java`)

- Contains business logic for doctor operations
- Handles CRUD operations coordination
- Implements PUT (full update) and PATCH (partial update) logic
- Uses Optional pattern for null-safe operations

### Doctor Repository (`DoctorRepository.java`)

- Extends `JpaRepository<Doctor, Integer>`
- Provides built-in CRUD operations
- Database interaction layer using Spring Data JPA

### Doctor Entity (`Doctor.java`)

- JPA Entity with Hibernate annotations
- Lombok annotations for reducing boilerplate (@Data, @Getter, @Setter, etc.)
- Proper column constraints and validations

---

## 🔄 Upcoming Features

### Phase 2: Patient Management

- [ ] Create Patient entity
- [ ] Build Patient CRUD operations
- [ ] Implement patient-doctor association
- [ ] Patient appointment history

### Phase 3: Appointment Management

- [ ] Create Appointment entity
- [ ] Schedule appointments
- [ ] Manage appointment status
- [ ] Appointment reminders

### Phase 4: Department Management

- [ ] Create Department entity
- [ ] Link doctors to departments
- [ ] Department management operations

### Phase 5: Staff Management

- [ ] Create Staff entity
- [ ] Manage nurses, reception staff, etc.
- [ ] Shift management

### Phase 6: Hospital Services

- [ ] Create Services/Treatments entity
- [ ] Link services with doctors
- [ ] Pricing management

---

## 🐛 Troubleshooting

### Issue: Connection Refused Error

**Solution:** Ensure MySQL server is running

```bash
# On Windows
net start MySQL80    # or your MySQL service name

# On Linux/Mac
brew services start mysql
sudo systemctl start mysql
```

### Issue: Database Not Found

**Solution:** Create the database manually

```sql
CREATE DATABASE hospital_db;
```

### Issue: Port Already in Use

**Solution:** Change port in `application.properties`

```properties
server.port=8888  # Change to any available port
```

### Issue: Hibernate Table Not Created

**Solution:** Check the DDL configuration

```properties
spring.jpa.hibernate.ddl-auto=update  # Should be 'update' or 'create'
```

---

## 📚 Key Concepts Used

- **Spring Boot** - Framework for building standalone applications
- **Spring Data JPA** - Simplifies database access layer
- **Hibernate** - ORM framework for object-relational mapping
- **REST API** - Architectural style for web services
- **CRUD Operations** - Create, Read, Update, Delete
- **Request/Response Cycle** - HTTP communication pattern
- **Dependency Injection** - Using `@Autowired` for bean management
- **Annotations** - `@Entity`, `@Table`, `@Column`, `@Id`, `@RestController`, `@Service`, `@Repository`

---

## 📖 Resources

- [Spring Boot Official Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA Documentation](https://spring.io/projects/spring-data-jpa)
- [Hibernate Documentation](https://hibernate.org/)
- [REST API Best Practices](https://restfulapi.net/)
- [MySQL Documentation](https://dev.mysql.com/doc/)

---

## 📞 Support

For issues, questions, or suggestions, refer to the project structure and review the inline code comments for detailed explanations.

---

**Last Updated:** March 2026  
**Status:** ✅ Doctor Module Complete | 🔄 Other Modules - In Progress
