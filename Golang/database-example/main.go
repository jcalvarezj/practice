// This program connects to the MySQL gotest database

package main

import (
	"fmt"
	"database/sql"

	_ "github.com/go-sql-driver/mysql"
)

const USER = "gouser"
const PASS = "gouser"
const HOST = "127.0.0.1:3306"
const DATABASE = "gotest"

type User struct {
	username string
	firstName string
	lastName string
	birthday string
	sex string
	biography string
}

func main() {
	conn_string := fmt.Sprintf("%s:%s@tcp(%s)/%s", USER, PASS, HOST, DATABASE)
	connection, err := sql.Open("mysql", conn_string)

	if err != nil {
		panic(err.Error())
	}

	defer connection.Close()

	insert, err := connection.Query("INSERT IGNORE INTO user VALUES (?, ?, ?, ?, ?, ?)",
					   "jajaja", "Sebastian", "McDonalds", "1994-12-10", "M", "Dev")

	if err != nil {
		panic(err.Error())
	}

	defer insert.Close()

	query_statement := fmt.Sprintf("SELECT * FROM user")

	results, err := connection.Query(query_statement)

	if err != nil {
		panic(err.Error())
	}

	for results.Next() {
		var user User
		err = results.Scan(&user.username, &user.firstName, &user.lastName, &user.birthday,
				&user.sex, &user.biography)

		if err != nil {
			panic(err.Error())
		}

		fmt.Println(user)
	}
}
