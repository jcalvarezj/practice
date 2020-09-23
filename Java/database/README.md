# JDBC Example

This is a quick basic example of a CRUD in Java using JDBC on a MySQL database

Build on Linux executing **./buildScript.sh**

Execute the generated JAR using **java -jar JDBCExample.jar**

The database can be imported from the games\_tournament.sql script. It requires the following process:

1. CREATE DATABASE games\_tournament;
2. mysql -p \<user with privileges\> -p games\_tournament < games\_tournament.sql
3. CREATE USER 'games\_tournament'@'localhost' IDENTIFIED\_BY 'games\_tournament';
4. GRANT ALL PRIVILEGES ON games\_tournament.\* TO 'games_tournament'@'localhost';


Javadoc can be generated into a _doc_ folder using **javadoc -d doc src/\*.java**

Made by Juan C. Alvarez
