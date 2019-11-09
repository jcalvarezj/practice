import 'package:flutter/material.dart';
import 'card_image.dart';
import 'constants.dart';

class CardImageList extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      height: 350,
      child: ListView(
        padding: EdgeInsets.all(25),
        scrollDirection: Axis.horizontal,
        children: <Widget>[
          CardImage("assets/img/bettertips.jpg",Constants.HOME_VIEW_INDEX),
          CardImage("assets/img/flowerfield.jpg",Constants.HOME_VIEW_INDEX),
          CardImage("assets/img/mountains.jpg",Constants.HOME_VIEW_INDEX),
        ],
      ),
    );
  }

}