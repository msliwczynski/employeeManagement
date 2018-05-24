# Employee management app

Employee management app is a simple web application, developed as coding task, to track information about employees and salaries in business organization.

  Main features are:
  - employee information storage (add/update/delete)
  - generating salary report
  - generating employees report

### Run locally

#### Build
Build application with maven:

`mvn clean package`

#### Run
To run application locally use command:

`mvn spring-boot:run`

#### H2 database console
To enter h2 database console after run application go to:
http://localhost:8080/h2-console

Use settings:

- Driver class: org.h2.Driver
- JDBC URL: jdbc:h2:mem:testdb
- Username: sa
- Password:

#### Keywords
- Spring Boot 2.0.2 (Spring Data, Spring MVC, Spring Security)
- Thymeleaf
- H2 database
- DataTables
- Maven