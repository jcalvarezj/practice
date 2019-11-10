'''
Este es un boceto directo de los elementos de una interfaz gráfica.
Recordar que en la práctica una clase debe representar una ventana con sus elementos y funciones.
'''

import wx 	## Se puede obtener con pip install wxpython

def funcion_evento_boton(evento):
	print("El boton funciona")

aplicacion = wx.App() 		## Define la base de la aplicación para poder inicializar elementos de interfaz gráfica
################ INICIO APLICACION ################

ventana = wx.Frame(None,title="Titulo", size=(500,600)) 		## Creación de un objeto ventana

panel = wx.Panel(ventana) 		## Crea y pone el panel en la ventana
campo = wx.TextCtrl(panel,pos=(200,100))
boton = wx.Button(panel,label="Clickeame",pos=(100,100)) 		## Crea y pone un botón en el panel
boton.Bind(wx.EVT_BUTTON, funcion_evento_boton) 		## Enlaza al elemento botón una escucha a un evento y una función de manejo para el evento
etiqueta = wx.StaticText(panel,label="Ejemplo de label")

ventana.Show() 		## Muestra la ventana

################ FIN APLICACION ################
aplicacion.MainLoop() 		## Ejecuta el bucle principal de la aplicación (hilo de control)