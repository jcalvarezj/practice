import 'package:flutter/material.dart';

import 'constants.dart';

class MyButton extends StatelessWidget {
  String text;

  MyButton(this.text);

  @override
  Widget build(BuildContext context) {
    final boton = Container(
      height: 50,
      width: 180,
      margin: EdgeInsets.only(
        top: 30,
        right: 20,
        left: 20,
      ),
      decoration: BoxDecoration(
        gradient: LinearGradient(
          begin: FractionalOffset(0.1,0.5),
          end: FractionalOffset(0.8,0.1),
          colors: [
            Colors.red,
            Colors.green,
            Colors.blue,
          ],
          stops: [0, 0.5, 1],
        ),
        borderRadius: BorderRadius.circular(30),
      ),
      child: InkWell(
        onTap: () {
          Scaffold.of(context).showSnackBar(
              SnackBar(
                content: Text("Estoy navegando!!!"),
              )
          );
        },
        child: Center(
          child: Text(
            text,
            style: TextStyle(
              fontFamily: Constants.TEXT_FONT,
              color: Colors.white,
            ),
          ),
        ),
      ),
    );

    return boton;
  }
  
}