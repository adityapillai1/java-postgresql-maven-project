# Java Project using JDBC, Postgresql and Maven
This is an example project created during DE training. It is a java project that reads .csv and .json files and inserts them into a postgresql database.

## Prerequisites
* Java
* Maven
* PostgreSQL

## How to run
* Clone this repository using git clone https://github.com/adityapillai1/jdbc-postgresql-maven-example.git
* Create a PostgreSQL database and a table named people with the following schema:
CREATE TABLE people (
    sno INT PRIMARY KEY,
    name VARCHAR,
    age INT
);
* You should see that the data fron .csv or .json file has been inserted to the people table
