#!/usr/bin/python

'''
Basic structures example
'''

people = {'Pepe':['8858888','Engineering','Apt. 123'],
		  'Papa':['123','Food','122 Street'],
		  'Guacala':['8','Other','GGGGG Avenue']}

names = ['phone','department','address']

menu = {'P':0,'D':1,'A':2}

print("Current names are "+str(people.keys()))

name = raw_input("Hello. Please write the name of interest: ")
choice = raw_input("Now choose something. Phone (p), Department (d), \
Address (a): ")

print "Result: "
print(name+"'s "+names[menu[choice.capitalize()]]+": "+\
	 	people[name][menu[choice.capitalize()]])
