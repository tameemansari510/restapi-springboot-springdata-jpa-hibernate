# restapi-springboot-springdata-jpa-hibernate
REST API CRUD operations for a simple application using SpringBoot, JPA, Hibernate, MySQL

# Requirements
Java - 1.8.x

Maven - 3.x.x

Mysql - 5.x.x

# Steps to setup

### 1. Clone application
Clone repository to your local machine using "git clone https://github.com/tameemansari510/restapi-springboot-springdata-jpa-hibernate.git"

### 2. Create MySQL
Download and install MySQL

Create database "notes_app"

### 3. Configure database
Open src/main/resources/application.properties

Change username and password in application.properties file

Change spring.datasource.username and spring.datasource.password as per your mysql installation

### 4. Configure server port
Open src/main/resources/application.properties

Configure server port in application.properties file

Add or change server.port = 8080 or 8081 whichever port are available in your local

### 5. Build and run the app using maven
mvn package

java -jar target/easy-notes-1.0.0.jar

Alternatively, you can run the app without packaging it using -

mvn spring-boot:run

### 6. Run application
After successfull compile and build of application.

Use http://localhost:8080. or http://localhost:8081. 

port number based on the server configuration done in application.properties file

### 7. Explore API
Create note: POST /notes

Get note by id: GET /notes/{id}

Get all notes: GET /notes

Get all notes with paging and sorting: GET /notes?pageNo={pageNo}&pageSize={pageSize}&sortBy={sortBy}
  
Update notes by id: PUT /notes/{id}

Delete notes by id: DELETE /notes/{id}

Test using postman or other clients
