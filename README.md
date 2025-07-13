📘 Library Book Catalog API
A simple Spring Boot-based RESTful API for managing a library’s book catalog.

🔧 Features
Add a new book ✅

Retrieve all books ✅

Get book details by ID ✅

Delete a book ✅

Update availability of a book ✅

Input validation using @NotBlank ✅

Spring Data JPA with MySQL backend ✅

🛠️ Tech Stack
Java 8+

Spring Boot

Spring Web

Spring Data JPA

MySQL Database

Bean Validation (JSR-380)

Postman (for testing)

📁 Project Structure


src/
├── main/
│   ├── java/
│   │   └── com.example.library/
│   │       ├── controller/
│   │       ├── model/
│   │       ├── service/
│   │       ├── repository/
│   │       └── LibraryManagementSystemApplication.java
│   └── resources/
│       └── application.properties


⚙️ Setup Instructions
1. ✅ Clone the Repository

git clone  https://github.com/Rahuldev56/LMS-Catalog.git

cd LMS-Catalog

2. ✅ Create MySQL Database


CREATE DATABASE library_db;


3. ✅ Configure application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/library_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
⚠️ Replace root and your_password with your MySQL credentials.

4. ✅ Build and Run the App
From IntelliJ:

Right-click LibraryManagementSystemApplication.java → Run

Or via terminal:

mvn clean install
mvn spring-boot:run

🔄 API Endpoints
Method	Endpoint	Description
POST	/books	Add a new book
GET	/books	Retrieve all books
GET	/books/{id}	Get book by ID
DELETE	/books/{id}	Delete a book by ID
PUT	/books/{id}/availability	Update availability status

📮 Sample Requests (Postman)
✅ Add Book

POST /books
Content-Type: application/json

{
  "title": "Effective Java",
  "author": "Joshua Bloch",
  "isbn": "9780134685991",
  "available": true
}

✅ Update Availability

PUT /books/1/availability?available=false

✅ Validation Rules
title: must not be blank

author: must not be blank

If validation fails, response is:

[
  "title: Title cannot be empty",
  "author: Author cannot be empty"
]

📦 Postman Collection


Open Postman

Import LibraryBookCatalog.postman_collection.json (share this file from your system)

Test all endpoints easily

📚 Dependencies Used

<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
</dependencies>
