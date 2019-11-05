import 'dart:developer';

import 'package:flutter/material.dart';

class FavButton extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _FavButton();
  }
}

class _FavButton extends State<FavButton> {
  bool _isFavorite = false;

  @override
  Widget build(BuildContext context) {
    final icon = _isFavorite ? Icons.favorite : Icons.favorite_border;

    return FloatingActionButton(
      backgroundColor: Color(0xFF11DA53),
      mini: true,
      tooltip: "Fav",
      child: Icon(
        icon,
        color: Colors.white,
      ),
      onPressed: onPressedFav,
    );
  }

  void onPressedFav() {
    setState(() {
      if(!_isFavorite) {
        _isFavorite = true;
        Scaffold.of(context).showSnackBar(
            SnackBar(
              content: Text("Agregado como Favorito!!"),
            )
        );
      }
      else {
        _isFavorite = false;
        Scaffold.of(context).showSnackBar(
            SnackBar(
              content: Text("Ya no es favorito!!"),
            )
        );
      }
    });

  }

}