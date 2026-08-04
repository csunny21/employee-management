In this employee management application we went from a traditional CRUD application to an event-driven microservice architecture.

IntelliJ - IDE, Ubuntu-Docker-Kafka, Postman-Manual Integration Testing, Localhost - UI, PG Admin - Database
Employee-Management - Main Application
Notification-Service - Microservice
Audit-Service - Microservice

First Iteration was an incredibly simple application to help practice core java. 
contains five packages: Enum, Business Logic, Employee Class to name a couple.
Constructors, Getter/Setters, If-Statements, Exception Handling, Calling Methods,
For-Loops, Parameters, and Return Types can be viewed.
OOP concepts like Inheritance (extends), Interfaces (implements), and Abstraction are also within the application.

Second iteration, saw an overhaul of methods when the PGAdmin(database) was integated.
New packages, new classes. Instead of using the main we used Postman to manually integration test if the db was working.

The third iteration saw a simple UI created (HTML, CSS, JS). Listeners, Kafka, and Async was introduced to the application.
Than once the architecture allowed, I refactored the application removing Listeners/Entity/Notification classes.

The fourth iteration saw the removal of the consumer which is now in a microservice application: Notification Service
https://github.com/csunny21/notification-service

The fifth iteration saw the removal of more classes to make room for microservice application: Audit Service
https://github.com/csunny21/audit-service
