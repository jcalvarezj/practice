# Database example

This is a basic example of database access with Golang using the **Go-SQL-Driver** and **database/sql** packages.

It runs using a MySQL database called **gotest**, and accesses through credentials **gouser**:**gouser**.

Requires a running MySQL instance with these database and credentials, and operates over the **user** table.

To test this program it is possible to import the database using the **gotest.sql** SQL script.

Compile using `go build main.go` and run using `./main`
