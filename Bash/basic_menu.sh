#!/bin/bash

# Basic shell program that displays a menu of commands
# Author: jcalvarezj
# Created at: 18/12/2021
# Version: 1.0.0

echo " --------------------------"
echo "|                          |"
echo "|   H E L L O  W O R L D   |"
echo "|                          |"
echo " --------------------------"

option=-1

while [[ $option -ne 7 ]]; do
	echo "What do you wanna do?"
	echo "1. Check current processes"
	echo "2. Available RAM memory"
	echo "3. Available disk space"
	echo "4. Network information (requires net-tools)"
	echo "5. List all environment variables (LESS)"
	echo "6. List all installed packages"
	echo "7. Finish"

	read -n1 -p "Please choose an option: " option
	echo
	echo

	if [[ "$option" =~ '^[0-9]$' ]]; then
		echo "NUMBERS ONLY, DUDE!"
	else
		case $option in
			1)
				top
			;;
			2)
				free
				echo
			;;
			3)
				df -H
				echo
			;;
			4)
				ifconfig
				echo
			;;
			5)
				printenv | less
			;;
			6)
				dpkg -l
			;;
			7)
				echo "Bye-bye"
			;;
			*)
				echo "Not a valid option"
			;;
		esac
	fi
done
