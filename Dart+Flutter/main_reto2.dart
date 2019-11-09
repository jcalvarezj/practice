/*
 * This is an example of a static Flutter app that shows an image, a centered 
 * text, and a transparent black box. Requires the image "foto.jpg" on the
 * /assets folder. Requires enabline the assets on the pubspec.yaml file,
 * changing this file's name to "main.dart", and placing it on /lib
 *
 * @author J. Alvarez
 */

import 'dart:io';

import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Reto 2 App',
      theme: ThemeData(
        primarySwatch: Colors.grey,
      ),
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatelessWidget {
  MyHomePage({Key key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Reto 2 App"),
      ),
      body: Stack(
        children: <Widget>[
          Container(
            width: MediaQuery.of(context).size.width,
            height: MediaQuery.of(context).size.height,
            child: Image.asset(
              "assets/foto.jpg",
              fit: BoxFit.fill,
            ),
          ),
          Center(
            child: Container(
              color: Color.fromRGBO(0, 0, 0, 0.7),
              height: 50,
            ),
          ),
          Center(
            child: Text(
                "Naughty",
              style: TextStyle(
                fontSize: 17,
                fontWeight: FontWeight.bold,
                color: Colors.white,
              ),
            ),
          ),
        ],
      ), // This trailing comma makes auto-formatting nicer for build methods.
    );
  }
}
