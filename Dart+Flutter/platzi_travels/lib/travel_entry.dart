import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:platzi_travels_app/card_image.dart';
import 'package:platzi_travels_app/fav_button.dart';
import 'package:platzi_travels_app/place_information.dart';

import 'constants.dart';

class TravelEntry extends StatelessWidget {
  final imagePath;
  final title;
  final description;
  final steps;

  TravelEntry({this.imagePath, this.title, this.description, this.steps});

  @override
  Widget build(BuildContext context) {
    final image = CardImage.placeInfo(imagePath, Constants.PROFILE_VIEW_INDEX, title, description, steps);

    final placeInformation = PlaceInformation(title, description, steps);

    return Container(
      child: Stack(
        alignment: Alignment(0, 0.7),
        children: <Widget>[
          image,
          Stack(
            alignment: Alignment(0.53,1.1),
            children: <Widget>[
              placeInformation,
              FavButton(),
            ],
          ),
        ],
      ),
    );
  }
  
}