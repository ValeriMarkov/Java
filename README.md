# Java
Java project

Sorry for the awful scheme.

To run the application, you need to:

1) Open the project in intellij
2) Modify the following in application.proporties:

    a) Change the port number, to the one you use in PostgreSQL - spring.datasource.url=jdbc:postgresql://localhost:PORT/city

    b) modify the username, to yours - spring.datasource.username=USERNAME

    c) modify password to your account's password - spring.datasource.password=PASSWORD

3) Open PostgreSQL's shell, and enter the following commands:

    a) CREATE DATABASE city;

    b) GRAND ALL PRIVILEGES ON DATABASE "city" TO yourusername

    c) \c city

4) Launch the project from CityApplication

5) Open this link in a browser, with your configured PORT:

http://localhost:8080/api/v1/cities
