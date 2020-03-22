/*
 * Map example. Name, phone, and query data are read from a file (input01.txt)
 * The response of the query (asking for names in the map) is written on an
 * output file (outputxx.txt)
 * Based on hackerrank.com challenge
 * @author J. Alvarez
 */

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <fstream>
#include <map>

using namespace std;

int main() {
    int n;
    ifstream inputFile("input01.txt");
    
    if(!inputFile)
        cout << "File could not be open" << endl;
    else {
        ofstream outputFile("outputxx.txt");

        if (!outputFile)
            cout << "Could not open outfut file" << endl;
        else {
            map<string, string> directory;
            string key;
            string value;
            string name;
            inputFile >> n;
            for (int i = 0; i < n; i++)   {
                inputFile >> key >> value;
                directory[key] = value;
            }
            while (inputFile >> name) {
                if (directory.count(name) != 0)
                    outputFile << name << "=" << directory[name] << endl;
                else
                    outputFile << "Not found" << endl;
            }

        }
        outputFile.close();
    }

    inputFile.close();
    return 0;
}