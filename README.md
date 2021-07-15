# Java Spring Boot Basics

This repo is from Platzi's course [Fundamentos de Java Spring Boot](https://platzi.com/clases/spring-boot/)

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

## General info

In this course we learn the fundamentals of working with Spring Boot in Java and the concepts related to it. Throughout the course we are working on a very simple web application that allows us to manage users.

### What is Spring Boot?
* A project based on Spring.
* Its main objective is to "run" the application.
* Integrate with third party libraries very easily.
* Minimal settings at the properties level.
* Its main characteristics are embedded web servers.

### Main features
* Independent.
* Embedded Tomcat, Jetty or Undertow.
* Proportion of dependencies.
* No XML generation.
* Health metrics of the application.

### What is a dependency?
* They are objects defined as a functionality.
* Without this functionality the other objects will not be able to work, they depend on them.
* We need objects that have other dependencies that help fulfill a goal.
* *Small characteristic of a specific object.*

### What is inversion of control?
* Principle that transfers control of objects from a program to a container or framework.
* Unlike carrying the flow of a program in the traditional way.

### Advantages of IoC
* Decoupling when objects have their dependencies.
* The implementation of dependencies is hidden, benefit of interface segregation.
* Facilitates testing by components or dependency mocks.
* Greater modularity of a program.

### IoC in the context of Spring Boot
* The objects that are managed by the Spring IoC container are called beans.
* A bean is an object that is instantiated, assembled, and managed by a Spring IoC container.

### What is dependency injection?
* Dependency injection (DI) is the process by which objects define their dependencies.
* Cleaner code and more effective decoupling when each object has its dependency.
* Implementation of the investment of control principle.
* Definition of the other objects they work with.
* Classes easier to test, particularly when they are interfaces.

### Autoconfiguration and runtime
* Automatically configure your applications based on JAR dependencies that you added.
* The autoconfiguration is not invasive, whenever we want we can configure our own beans.

### What is an Annotation in Spring Boot?
An Annotation is a way of adding metadata to Java source code that is available to the application at run or compile time. It is a simpler alternative to using XML.

### Annotation types

||||
|-|-|-|
|@Component||If our class or interface does not have a clear specification such as @Service, @Repository or @Controller, we simply go to @Component and indicate that it is simply a component.|
||@Controller|Presentation: To indicate that this will be the class that will manage the user's requests for get, post, put, patch or delete.|
||@Service|Service: With this notation we specify that all our business logic, calculations or calls to other external APIs will be found in this class.|
||@Repository|Persistence: It is used for the classes or interfaces that will work with the access to the database.|

On the other hand, it is not strictly necessary that you comply with placing a specific notation, but it is good practice.

### Logs
|Error|Info|Debug|Others|
|-----|----|-----|------|

### What is JPA?
Java specification for accessing, preserving, and managing data between objects or classes and a relational database.
|JPA|
|-|
|Java Persistence API|

### What is JPQL?
* JPQL is the query language defined by JPA.
* Similar to SQL but with the particularity of operating on objects.

### What are Query methods?
* It is a definition of a query manually as a string or derived from the method name.

## Technologies

This project was created using:
* IntelliJ IDEA
* Postman
* JDK 8 or higher version
* [Spring Boot](https://start.spring.io/)

## Setup

To work in this project, install it locally:
* [IntelliJ IDEA](https://www.jetbrains.com/idea/download)
* [Postman](https://www.postman.com/downloads/)
* [JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
