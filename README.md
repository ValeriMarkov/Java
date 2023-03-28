# Java
Java projects


To run the application, you need to:

1) Open the project in intellij
2) Modify the following in application.proporties:
    a) Change the port number, to the one you use in PostgreSQL - spring.datasource.url=jdbc:postgresql://localhost:5432/city
    b) modify the username, to yours - spring.datasource.username=postgres
    c) modify password to your account's password - spring.datasource.password=123123
3) Open PostgreSQL's shell, and enter the following commands:
    a) CREATE DATABASE city;
    b) GRAND ALL PRIVILEGES ON DATABASE "city" TO yourusername
    c) \c city
4) Launch the project from CityApplication
