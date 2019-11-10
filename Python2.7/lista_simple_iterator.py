#!/usr/bin/python
#coding=utf-8

'''
Este programa maneja una estructura de datos de lista simplemente enlazada por orientación a objetos
e itera en sus elementos empleando un objeto Iterator
@author J Alvarez
'''

class Lista:

	def __init__(self):		
		self._cabeza = None		## Primer elemento de la estructura
		self._cursor = Nodo("")	## Cursor para Iterator
		self._conteo = 0		## Numero de elementos en la estructura

	def __str__(self):
		return "La lista es [" + self._listar() + "] con un conteo de " + str(self._conteo)

	def __iter__(self):
		"""
		Método que define esta clase como iterable con un Iterator.
		Retorna el objeto de instancia de esta clase.
		"""		
		return self

	def __next__(self):
		"""
		Método que mueve el cursor una posición adelante y retorna el objeto al que apunta
		@excepcion Lanza un StopIteration cuando se ha llegado al final de la estructura
		"""
		if(self._cursor.siguiente != None):
			self._cursor = self._cursor.siguiente
			return self._cursor
		else:
			raise StopIteration


	def _listar_recursivo(self,nodo):
		"""
		@pre: Nodo debe ser la cabeza desde donde listar
		"""
		if (nodo == None):
			return ""
		elif (nodo.siguiente == None):
			return str(nodo)
		else:
			return str(nodo)+","+self._listar(nodo.siguiente)

	def _listar(self):
		if (self._cabeza == None):
			return ""
		else:
			lista = ""
			cursor = self._cabeza
			lista += str(cursor) + ","
			while (cursor.siguiente != None):
				cursor = cursor.siguiente
				lista += str(cursor)
				if (cursor.siguiente != None):
					lista += ","
			return lista

	def agregar(self,datos):
		self._add(Nodo(datos))

	def _add(self,nodo):
		"""
		@precondicion: nodo es un nodo creado con información; cursor es la cabeza
		@postcondicion: se ha enlazado al final de la estructura el nodo
		"""
		if (self._cabeza == None):
			self._cabeza = nodo
			self._cursor.siguiente = self._cabeza
		elif (self._cabeza.siguiente == None):
			self._cabeza.siguiente = nodo
		else:
			cursor = self._cabeza
			while(cursor.siguiente != None):
				cursor = cursor.siguiente
			cursor.siguiente = nodo
		self._conteo += 1

	def getConteo(self):
		return self._conteo

	def getCabeza(self):
		return self._cabeza

class Nodo:

	def __init__(self,datos):
		"""
		Crea un nodo nuevo con los datos ingresados e inicializa la referencia al siguiente
		"""
		self._datos = datos
		self._siguiente = None

	def __str__(self):
		return str(self._datos)

	@property
	def datos(self):
		return self._datos
	
	@datos.setter
	def datos(self,datos):
		self._datos = datos

	@property
	def siguiente(self):
		return self._siguiente

	@siguiente.setter
	def siguiente(self,siguiente):
		self._siguiente = siguiente

lista = Lista()
lista.agregar("casa")
lista.agregar("cosa")
lista.agregar(8)
lista.agregar("ña")

print(str(lista))

iterador = iter(lista)
print(iterador.__next__())
print(iterador.__next__())
print(iterador.__next__())
print(iterador.__next__())
print(iterador.__next__())