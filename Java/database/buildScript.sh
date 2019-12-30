#!/usr/bin/bash

# This script should be executed at the root of the project
# Requires java in the system

if [ ! -d "build" ]
	then
		echo "build folder does not exist, creating..."
		mkdir build
		echo "build folder created"
	else
		echo "build folder already exists"
fi

echo "copying resources to build folder..."

cp -r lib/ build/

echo "proceeding with compilation..."

javac src/*.java -d build

cd build

echo "creating manifest (Manifest.txt)..."

echo "Class-Path: lib/mysql-connector-java-5.1.48.jar" >> Manifest.txt
echo "Main-Class: Main" >> Manifest.txt
echo "" >> Manifest.txt

jar cvfm JDBCExample.jar Manifest.txt .

mv JDBCExample.jar ../

cd ..

rm -r build
