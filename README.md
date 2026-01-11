🔵 TASK 2 – Spring Boot REST API (Product Management)
📌 Project Overview

This project was created as Task 2 for the Spring Framework Apps course at
Akademia Finansów i Biznesu Vistula.

Unlike Task 1, this application is a pure REST API:

no frontend (no HTML, no Thymeleaf),

communication is done only via HTTP and JSON,

tested using Postman and Swagger UI,

follows layered architecture and REST principles.

The application allows full CRUD operations on a Product resource:

Create

Read (single & all)

Update

Delete

🎯 Goals of Task 2

✔ Create REST API using Spring Boot
✔ Understand Spring stereotypes (@Controller, @Service, @Repository)
✔ Work with DTOs (Request / Response objects)
✔ Implement mapping between objects
✔ Handle HTTP status codes correctly
✔ Add Swagger (OpenAPI) documentation
✔ Implement exception handling
✔ Use H2 database with Spring Data JPA

🛠 Technologies Used

Java

Spring Boot

Spring Web

Spring Data JPA

Hibernate

H2 In-Memory Database

Swagger / OpenAPI

Maven

Postman

⚙️ Project Creation

The project was created directly in IntelliJ IDEA using:

File → New → Project → Spring Initializr

Selected dependencies:

Spring Web

Spring Data JPA

H2 Database

Spring Boot DevTools

📂 Project Structure
src/main/java
└── com.example.firstrestapi
    ├── FirstRestApiApplication.java
    │
    ├── product
    │   ├── api
    │   │   ├── ProductController.java
    │   │   ├── request
    │   │   │   ├── ProductRequest.java
    │   │   │   └── UpdateProductRequest.java
    │   │   └── response
    │   │       └── ProductResponse.java
    │   │
    │   ├── domain
    │   │   └── Product.java
    │   │
    │   ├── service
    │   │   └── ProductService.java
    │   │
    │   ├── repository
    │   │   └── ProductRepository.java
    │   │
    │   └── support
    │       ├── ProductMapper.java
    │       ├── exception
    │       │   └── ProductNotFoundException.java
    │       ├── ProductExceptionSupplier.java
    │       └── ProductExceptionHandler.java
    │
    └── shared
        └── api
            └── response
                └── ErrorMessageResponse.java

🧠 Architecture Overview

The application follows layered architecture:

Layer	Responsibility
Controller	Handles HTTP requests and responses
Service	Business logic
Repository	Database access
Domain	Entity model
DTOs	API request & response objects
Support	Mapping and exception handling
🧱 Domain Layer – Product Entity
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}

Explanation:

@Entity – marks class as database entity

@Id – primary key

@GeneratedValue – auto-generated ID

This class represents a database table

📥 Request & 📤 Response Objects (DTOs)
ProductRequest

Used when creating a product.

{
  "name": "Laptop"
}

UpdateProductRequest

Used when updating a product.

ProductResponse

Returned to client after operations.

Why DTOs?

Separation of API from internal model

Security

Flexibility

Clean architecture

🔁 ProductMapper

Responsible for mapping objects:

Request → Entity

Entity → Response

This avoids:

logic duplication

mixing layers

tight coupling

🗄 Repository Layer
Spring Data JPA
public interface ProductRepository extends JpaRepository<Product, Long> {
}

Why this works without implementation?

Spring Data JPA:

generates methods automatically at runtime

provides:

save

findById

findAll

deleteById

This is done using proxies and reflection.

⚙️ Service Layer – Business Logic

The service:

validates data

maps objects

handles exceptions

communicates with repository

Example logic:

Receive request from controller

Convert DTO → Entity

Save entity

Convert Entity → Response

Return result

🌐 Controller Layer – REST Endpoints

Base URL:

/api/v1/products

POST – Create Product
POST /api/v1/products


Request:

{
  "name": "Phone"
}


Response:

Status: 201 CREATED

Body: ProductResponse

GET – Find Product by ID
GET /api/v1/products/{id}


Responses:

200 OK – product exists

404 NOT FOUND – product does not exist

GET – Find All Products
GET /api/v1/products


Response:

200 OK

List of products (or empty list)

PUT – Update Product
PUT /api/v1/products/{id}


Updates existing product

Returns product state before update

Uses exception handling if product does not exist

DELETE – Delete Product
DELETE /api/v1/products/{id}


Response:

204 NO CONTENT

❗ Exception Handling
ProductNotFoundException

Custom exception thrown when product does not exist.

ProductExceptionSupplier

Provides reusable exception suppliers.

@ControllerAdvice

Global exception handler:

catches ProductNotFoundException

returns:

HTTP 404

clear error message

ErrorMessageResponse

Standard error response object.

📖 Swagger (OpenAPI)

Swagger was added to:

document API

test endpoints

visualize requests & responses

Swagger URLs:
http://localhost:8080/swagger-ui/index.html
http://localhost:8080/v3/api-docs

🗃 H2 Database Configuration

application.properties:

spring.h2.console.enabled=true
spring.h2.console.path=/console
spring.datasource.url=jdbc:h2:mem:testdb
spring.jpa.show-sql=true

H2 Console:
http://localhost:8080/console


JDBC URL:

jdbc:h2:mem:testdb

🧪 Testing
Tools Used:

Swagger UI

Postman

Browser

Tested Scenarios:

✔ Create product
✔ Get product by ID
✔ Get all products
✔ Update product
✔ Delete product
✔ Handle missing product (404)

📄 HTTP Status Codes Used
Code	Meaning
200	OK
201	Created
204	No Content
404	Not Found
500	Internal Server Error (avoided by handlers)
🧾 .gitignore

The project includes .gitignore to exclude:

build files

IDE files

OS files

✅ Final Result

This project demonstrates:

deep understanding of Spring Boot REST APIs

clean architecture

correct HTTP usage

exception handling

database integration

professional documentation

It fully satisfies Task 2 requirements and is ready for live presentation, testing, and evaluation.

✅ END OF TASK 2 README
Tests:
<img width="1279" height="919" alt="image111" src="https://github.com/user-attachments/assets/ef32e7f1-d4ef-405e-85c5-cccf551ce158" />
<img width="1279" height="920" alt="image222" src="https://github.com/user-attachments/assets/3bdab3d9-263d-412e-831a-99d84684af75" />
<img width="1275" height="908" alt="image333" src="https://github.com/user-attachments/assets/366a5280-d412-4639-b4d6-3e095b982fb3" />
<img width="1279" height="916" alt="image444" src="https://github.com/user-attachments/assets/aaf3de0d-d908-4129-9766-880821c09f37" />
<img width="1279" height="919" alt="image555" src="https://github.com/user-attachments/assets/da9cb7e5-f63d-44ab-ac0c-68b271e275f4" />
<img width="1276" height="910" alt="image666" src="https://github.com/user-attachments/assets/fd07fab4-67db-4ea7-89c4-81dc80433014" />
<img width="1279" height="918" alt="image777" src="https://github.com/user-attachments/assets/918725c4-02cc-4988-838f-b40dca31547e" />
<img width="1279" height="915" alt="image888" src="https://github.com/user-attachments/assets/9bdcfb08-24cb-4334-8062-7797e5e1f7db" />
<img width="1279" height="918" alt="image999" src="https://github.com/user-attachments/assets/2ccd438a-2241-45af-90f8-6298ba37436b" />


