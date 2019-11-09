import 'package:flutter/material.dart';
import 'package:platzi_travels_app/card_image_list.dart';
import 'package:platzi_travels_app/home_view.dart';
import 'package:platzi_travels_app/platzi_travels.dart';
import 'package:platzi_travels_app/review_list.dart';
import 'place_description.dart';
import 'gradient_background.dart';
import 'header.dart';
import 'constants.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Proyecto Platzi Travels',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatelessWidget {
  MyHomePage({Key key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return PlatziTravels();

  }
}