#!/usr/bin/python

'''
Manejo basico de clases
@author J Alvarez
'''

class Punto:

	def __init__(self,x,y):
		self.x = x
		self.y = y

	def __str__(self):
		return "Este es el punto %f,%f" % (self.x,self.y)

class Circulo:

	def __init__(self,centro,radio):
		self.centro = centro
		self.radio = radio

	def __str__(self):
		return "Este es el circulo con centro en "+str(self.centro)+" y de radio %f" % self.radio

centr = Punto(2,3)
circ = Circulo(centr,2)