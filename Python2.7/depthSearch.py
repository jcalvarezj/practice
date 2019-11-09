#!/usr/bin/python
#coding=utf-8

'''
Basic recursion program that shows all elements in depth in the directory tree 
of the specified absolute path in the searchPath variable
Outputs into two files: 
	depthSearch_rawOutput.txt: shows files in the order of recursion
	depthSearch_stackOutput.txt: shows files after ordering in a stack
@author: J. Alvarez
'''

import os

searchPath = "/home/jcalvarezj/Documents/hyperblog"

rawFileManager = open('depthSearch_rawOutput.txt','w')
stackFileManager = open('depthSearch_stackOutput.txt','w')

outputStack = []

def depthSearch(directory, level):
	branches = os.listdir(directory)
	for item in branches:
		itemPath = os.path.join(directory, item)
		directorySlash = ""
		if (os.path.isdir(itemPath)):
			depthSearch(itemPath, level*2)
			directorySlash = "/"
		hearts = ""
		for i in range(level):
			hearts += "♥"
		rawFileManager.write(hearts+" "+item+directorySlash+"\n")
		outputStack.append(hearts+" "+item+directorySlash+"\n")

def wrapper(path):
	rawFileManager.write("Searching in depth for the following path: %s\n" % \
			path)
	depthSearch(path,1)
	writeStackFile(path)

def writeStackFile(path):
	stackFileManager.write("Searching in depth for the following path: %s\n" % \
			path)
	while(outputStack):
		stackFileManager.write(outputStack.pop())

wrapper(searchPath)

rawFileManager.close()
stackFileManager.close()
