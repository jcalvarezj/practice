import 'package:flutter/material.dart';
import 'gradient_background.dart';
import 'card_image_list.dart';

class Header extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Stack(
      children: <Widget>[
        GradientBackground(
            title: "Bienvenido",
            height: 250,
            gradient: LinearGradient(
              colors: [
                Color(0xFF4268D3),
                Color(0xFF584CD1)
              ],
              begin: FractionalOffset(0.2, 0),
              end: FractionalOffset(1, 0.6),
              stops: [0.0, 0.6],
              tileMode: TileMode.clamp,
            ),
        ),
        CardImageList()
      ],
    );
  }

}