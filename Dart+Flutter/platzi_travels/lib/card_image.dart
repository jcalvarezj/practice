import 'package:flutter/cupertino.dart';
import "package:flutter/material.dart";
import 'constants.dart';
import 'fav_button.dart';

class CardImage extends StatelessWidget {

  final String _imagePath;
  final int _view;

  String _title;
  int _steps;
  String  _description;

  CardImage(this._imagePath, this._view);

  CardImage.placeInfo(this._imagePath, this._view, this._title, this._description, this._steps);

  @override
  Widget build(BuildContext context) {
    var image;
    Widget card;

    if (_view == Constants.HOME_VIEW_INDEX) {
      image = Container(
        height: 350,
        width: 250,
        margin: EdgeInsets.only(
          top: 80,
          left: 20,
        ),
        decoration: BoxDecoration(
            borderRadius: BorderRadius.all(Radius.circular(10)),
            shape: BoxShape.rectangle,

            boxShadow: <BoxShadow>[
              BoxShadow(
                color: Colors.black,
                blurRadius: 15,
                offset: Offset(0.0,7.0),
              )
            ],

            image: DecorationImage(
              fit: BoxFit.cover,
              image: AssetImage(_imagePath),
            )
        ),
      );

      card = Stack(
        alignment: Alignment(0.9, 1.1),
        children: <Widget>[
          image,
          FavButton(),
        ],
      );
    }
    else {
      image = Container(
        height: 220,
        width: 320,
        margin: EdgeInsets.only(
          bottom: 100,
        ),
        decoration: BoxDecoration(
            borderRadius: BorderRadius.all(Radius.circular(10)),
            shape: BoxShape.rectangle,

            boxShadow: <BoxShadow>[
              BoxShadow(
                color: Colors.black,
                blurRadius: 15,
                offset: Offset(0.0, 7.0),
              )
            ],

            image: DecorationImage(
              fit: BoxFit.cover,
              image: AssetImage(_imagePath),
            )
        ),
      );
      card = image;
    }

    return card;
  }

}