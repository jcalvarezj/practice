#!/usr/bin/python
#coding=utf-8

'''
Esta script maneja una conexión básica con una base de datos: crea la base de datos, crea tablas y maneja un CRUD
@author J Alvarez
'''

import sqlite3

conexion = sqlite3.connect("miBaseDeDatos.db")

cursor = conexion.cursor()

cursor.execute('''DROP TABLE mascota;''')
print("Se ha limpiado la tabla de la base de datos")

cursor.execute('''CREATE TABLE mascota( id INTEGER PRIMARY KEY NOT NULL, nombre TEXT NOT NULL, genero TEXT NOT NULL, especie TEXT NOT NULL);''')
print("Se ha ejecutado la creacion de la base de datos miBaseDeDatos.db con una tabla")

cursor.execute('''INSERT INTO mascota VALUES(0,"pepa","h","marrano");''')
cursor.execute('''INSERT INTO mascota VALUES(1,"nestor","m","dragon");''')
cursor.execute('''INSERT INTO mascota VALUES(2,"luisa","h","gaviota");''')
cursor.execute('''INSERT INTO mascota VALUES(3,"pepe","m","pez");''')
cursor.execute('''INSERT INTO mascota VALUES(4,"ayaka","h","cosa");''')

conexion.commit()

print("Se han realizado y confirmado las inserciones")

consulta = cursor.execute('''SELECT * FROM mascota;''')

print("La base de datos contiene:")

resultado = ""

for registro in consulta:
	for columna in registro:
		resultado += " "+str(columna)+" "
	resultado += "\n"

print(resultado)
