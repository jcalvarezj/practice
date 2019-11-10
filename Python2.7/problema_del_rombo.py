#!/usr/bin/python

'''
Esta script modela el problema del rombo de la herencia múltiple:

	A
 -- ^ --
B 		C
^		^
 ---D--

Suponiendo que A define una función, que se llama igual para B, C y D,
¿cuál el la función a la que llama D?
'''

class A:
	def funcion(self):
		print "++A"

class B(A):
	def funcion(self):
		print "++B"

class C(A):
	def funcion(self):
		print "++C"

class D(B,C):
	def funcion(self):
		print "++D"

d = D()
d.funcion() ## Retorna ++D

class A:
	def funcion(self):
		print "++A"

class B(A):
	def funcion(self):
		print "++B"

class C(A):
	def funcion(self):
		print "++C"

class D(B,C):
	pass

d = D()
d.funcion() ## Retorna ++B, porque B es la primera clase de en la lista de las que hereda


class A:
	def funcion(self):
		print "++A"

class B(A):
	pass

class C(A):
	def funcion(self):
		print "++C"

class D(B,C):
	pass

d = D()
d.funcion() ## Retorna ++C

class A:
	def funcion(self):
		print "++A"

class B(A):
	pass

class C(A):
	pass

class D(B,C):
	pass

d = D()
d.funcion() ## Retorna ++A

## Para el caso en que se quiera manejar alguna en específico:

class A:
	def funcion(self):
		print "++A"

class B(A):
	def funcion(self):
		print "++B"

class C(A):
	def funcion(self):
		print "++C"

class D(B,C):
	def funcion(self):
		print "++D"
		C.funcion(self)
		B.funcion(self)
		A.funcion(self)

d = D()
d.funcion() ## Retorna ++B, porque B es la primera clase de en la lista de las que hereda