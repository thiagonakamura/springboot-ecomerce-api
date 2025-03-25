# Spring Boot E-Commerce API

A RESTful API built with **Spring Boot** to manage an e-commerce system. This project includes functionalities for handling **users, products, orders, and categories**, following best practices in **MVC architecture, exception handling, and RESTful API design**.

## 🚀 Features
- ✅ **User Management** - CRUD operations for users.
- ✅ **Product Management** - CRUD operations for products.
- ✅ **Order Processing** - Create and track orders.
- ✅ **Category Management** - Organize products into categories.
- ✅ **Exception Handling** - Standardized error responses.
- ✅ **DTO Implementation** - Efficient data transfer.
- ✅ **Enum Usage** - Order status management.
- ✅ **Composite Primary Keys** - Applied in order items.
- ✅ **H2 Database for Persistence** - In-memory database for development and testing.
- ✅ **Automated Testing** - JUnit 5 for unit tests.

## 🛠️ Technologies Used
- **Java 17+** (Check `pom.xml` for version)
- **Spring Boot 3.4.3** - Backend framework
- **Spring Web** - API development
- **Spring Data JPA** - Database management
- **H2 Database** - In-memory database for testing
- **JUnit 5** - Testing framework
- **Maven** - Dependency management

## 📂 Project Structure
```
src/main/java/com/example/springboot_ecommerce_api/
│-- config/       # Configuration files
│-- controllers/  # Handles HTTP requests
│-- dtos/         # Data Transfer Objects
│-- entities/     # JPA Entities
│-- enums/        # Enumerations (e.g., OrderStatus)
│-- exceptions/   # Custom exception handling
│-- repositories/ # Database access layer
│-- services/     # Business logic layer
│-- SpringbootEcomerceApiApplication.java  # Main entry point
```
## 🏗️ Database Model

Below is the relational model used in this project:

![image](https://github.com/user-attachments/assets/2ac5f832-9214-4e12-bff9-684112fba6fe)

## 🏗️ Installation & Running
### 1️⃣ Clone the Repository
```bash
git clone https://github.com/yourusername/springboot-ecommerce-api.git
cd springboot-ecommerce-api
```

### 2️⃣ Configure the Database (`application.properties`)
The project uses H2 Database by default, so no additional setup is required. However, you can modify application.properties if needed:
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

### 3️⃣ Build & Run the Application
```bash
mvn clean install
mvn spring-boot:run
```

### 4️⃣ API Endpoints (Default: `http://localhost:8080`)
| Method | Endpoint           | Description        |
|--------|-------------------|--------------------|
| GET    | `/users`          | List all users    |
| POST   | `/users`          | Create a user     |
| GET    | `/products`       | List all products |
| POST   | `/orders`         | Create an order   |

## 📌 Example Usage (Postman)
### Create a User (`POST /users`)
#### Request Body
```json
{
  "name": "Thiago",
  "email": "thiago@email.com",
  "password": "123456"
}
```
#### Response
```json
{
  "id": 1,
  "name": "Thiago",
  "email": "thiago@email.com"
}
```

## 🛡️ Security & Future Improvements
- 🔒 **JWT Authentication** (To secure endpoints)
- ✅ **Pagination & Filtering** for large datasets
- 🧪 **Improve Test Coverage** with JUnit 5
- ⚡ **Cache Implementation** for optimized queries

## 🤝 Contributing
Feel free to contribute by opening a Pull Request or reporting issues.

## 👨‍💻 Author
Thiago - Entry Level Java Developer 📌 [LinkedIn](https://www.linkedin.com/in/thiago-kenzo-rocha-nakamura-1b24591a5/) 

## 📜 License
This project is licensed under the MIT License.

