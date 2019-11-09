import "package:flutter/material.dart";
import 'package:platzi_travels_app/constants.dart';

class GradientBackground extends StatelessWidget {
  final String title;
  final double height;
  final gradient;

  GradientBackground({this.title, this.height, this.gradient});

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Text(
        title,
        style: TextStyle(
          fontFamily: Constants.TEXT_FONT,
          fontSize: 30,
          color: Colors.white,
          fontWeight: FontWeight.bold,
        ),
      ),

      alignment: Alignment(-0.9,-0.6),
      height: height,
      decoration: BoxDecoration(
        gradient: gradient,
      ),
    );
  }

}