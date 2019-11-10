#!/usr/bin/python
#coding=utf-8

'''
Script basica de manejo de conexion a base de datos PostgreSQL
'''

import psycopg2

conexion = psycopg2.connect(database="mibasededatos",user="postgres",password="sql12345",host="127.0.0.1",port="5432")

cursor = conexion.cursor()

cursor.execute('''DROP TABLE mascota;''') 		## Usar si ya existía
	
cursor.execute('''CREATE TABLE mascota(id INTEGER PRIMARY KEY NOT NULL, nombre TEXT NOT NULL, genero TEXT NOT NULL, especie TEXT NOT NULL);''')

cursor.execute("""INSERT INTO mascota VALUES(0,'pepe','m','perro');""")
cursor.execute("""INSERT INTO mascota VALUES(1,'epa','h','loro');""")

inserciones = [(2,'pepa','h','cerdo'),(3,'tobias','m','perro')]

cursor.executemany("""INSERT INTO mascota VALUES(%s,%s,%s,%s);""", inserciones)

conexion.commit()

cursor.execute("""SELECT * FROM mascota;""")

consulta = cursor.fetchall()

print(str(consulta))

if consulta == None:
	print "NO HAY REGISTROS"
else:
	columnas = [informacion[0] for informacion in cursor.description]

	resultado = ""

	for columna in columnas:
		resultado += "\t"+columna+"\t"

	resultado += "\n"

	for registro in consulta:
		for columna in registro:
			resultado += "\t"+str(columna)+"\t"
		resultado += "\n"

	print("La consulta retorna:\n"+resultado)

	conexion.close()
