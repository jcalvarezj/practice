#!/usr/bin/bash

# This script should be executed at the root of the project
# Requires java in the system

if [ ! -d "build" ]
	then
		echo "The build folder does not exist, creating..."
		mkdir build
		echo "The build folder was created"
	else
		echo "The build folder already exists"
fi

echo "Copying resources to build folder..."

cp -r lib/ build/

echo "Proceeding with compilation..."

javac src/*.java -d build

if [ $? -eq "0" ]
	then
		cd build

		echo "Creating manifest (Manifest.txt)..."

		echo "Class-Path: lib/mysql-connector-java-5.1.48.jar" >> Manifest.txt
		echo "Main-Class: Main" >> Manifest.txt
		echo "" >> Manifest.txt

		jar cvfm JDBCExample.jar Manifest.txt .

		mv JDBCExample.jar ../

	else
		echo "Stopping here. Compilation failed"
fi

echo "Cleaning up build folder..."

cd ..
rm -r build
