import 'package:flutter/material.dart';
import 'package:reto3/monster_data.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Final Fantasy Bestiary App',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        primarySwatch: Colors.teal,
      ),
      home: MyHomePage(title: "Narshe's Mines Bestiary"),
    );
  }
}

class MyHomePage extends StatelessWidget {
  MyHomePage({this.title}) : super();

  final String title;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(title),
        leading: Container(
          padding: EdgeInsets.all(5),
          child: Icon(
            Icons.menu,
            color: Colors.white,
          ),
        ),
      ),
      body: Column(
        children: <Widget>[
          Flexible(
            child: ListView(
              children: <Widget>[
                MonsterData("Guard",10,false,"assets/img/01-guard.png"),
                MonsterData("Silver Lobo",20,true,"assets/img/02-silver-lobo.png"),
                MonsterData("Megalodoth",3,false,"assets/img/03-megalodoth.png"),
                MonsterData("Wererat",5,true,"assets/img/04-wererat.png"),
                MonsterData("Spritzer",4,false,"assets/img/05-spritzer.png"),
              ],
            ),
          ),
          Container(
            height: 30,
            color: Colors.black54,
            child: Center(
              child: Text(
                "Creatures belong to Square Enix",
                style: TextStyle(
                  color: Colors.white,
                  fontSize: 14,
                ),
              ),
            ),
          )
        ],
      ),
    );
  }
}
