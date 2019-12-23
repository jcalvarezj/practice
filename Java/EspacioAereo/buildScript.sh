#!/usr/bin/bash

# This script should be executed at the root of the project
# Requires java in the system

if [ ! -d "build" ]
	then
		echo "build folder does not exist, creating..."
		mkdir build
		echo "created build folder"
	else
		echo "build folder exists"
fi

echo "copying resources to build folder..."

cp -r src/pkgSprites build/

echo "proceeding with compilation..."

find -name "*.java" > sources.txt

javac @sources.txt -d build

cd build

jar cvfe EspacioAereo.jar pkgVista.Ventana .

mv EspacioAereo.jar ../

rm -r ./*

cd ..

rm -r build

rm sources.txt
