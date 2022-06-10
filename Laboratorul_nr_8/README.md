# JDBC - World Cities

Write an application that allows to connect to a relational database by using JDBC, submit SQL statements and display the results.

The main specifications of the application are:

## Compulsory (1p)

- [x] Create a relational database using any RDBMS (Oracle, Postgres, MySql, Java DB, etc.).
- [x] Write an SQL script that will create the following tables:
  - [x] countries: id, name, code, continent
  - [x] continents: id, name
- [x] Update pom.xml, in order to add the database driver to the project libraries.
- [x] Create a singleton class in order to manage a connection to the database.
- [x] Create DAO classes that offer methods for creating countries and continents, and finding them by their ids and names;
- [x] Implement a simple test using your classes.

## Homework (2p)

  ![plot](Screenshots/evenimente.png)
- [x] Create the necessary table in order to store cities in your database. A city may contain: id, country, name, capital(0/1), latitude, longitude
- [x] Create an object-oriented model of the data managed by the application.
- [x] Create a tool to import data from a real dataset: World capitals gps or other
  - ![plot](Screenshots/cont.png)
  - ![plot](Screenshots/country.png)
- [x] Display the distances between various cities in the world.
  - ![plot](Screenshots/distanta.png)