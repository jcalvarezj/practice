import "package:flutter/material.dart";
import 'package:platzi_travels_app/constants.dart';
import 'my_button.dart';

class PlaceDescription extends StatelessWidget {

  String placeName;
  double rating;
  String placeDescription;

  PlaceDescription(this.placeName, this.rating, this.placeDescription);

  @override
  Widget build(BuildContext context) {
    final description = Container(
      margin: EdgeInsets.only(
        top: 20,
        left: 20,
        right: 20,
      ),
      child: Text(
        placeDescription,
        style: TextStyle(
          fontFamily: Constants.TEXT_FONT,
          fontSize: 12,
          fontWeight: FontWeight.w500,
        ),
        textAlign: TextAlign.left,
      ),
    );

    final half_star = Container(
      margin: EdgeInsets.only(
        top: 323,
        right: 3,
      ),
      child: Icon(
        Icons.star_half,
        color: Colors.yellow,
      ),
    );

    final empty_star = Container(
      margin: EdgeInsets.only(
        top: 323,
        right: 3,
      ),
      child: Icon(
        Icons.star_border,
        color: Colors.yellow,
      ),
    );

    final full_star = Container(
      margin: EdgeInsets.only(
        top: 323,
        right: 3,
      ),
      child: Icon(
        Icons.star,
        color: Colors.yellow,
      ),
    );

    final title_stars = Row(
      children: <Widget>[
        Container(
          margin: EdgeInsets.only(
            top: 320,
            left: 20,
            right: 20,
          ),
          child: Text(
            placeName,
            style: TextStyle(
              fontFamily: Constants.TEXT_FONT,
              fontSize: 30,
              fontWeight: FontWeight.w900,
            ),
            textAlign: TextAlign.left,
          ),
        ),
        Row(
          children:put_stars(full_star, half_star, empty_star),
        )
      ],
    );

    final total_content = Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: <Widget>[
        title_stars,
        description,
        MyButton("Navigate"),
      ],
    );

    return total_content;
  }

  List<Widget> put_stars(Widget full_star, Widget half_star, Widget empty_star) {
    List<Widget> stars = [];
    var count = rating;
    int empty = (5-rating).floor();
    for(var i=1; i<=rating; i++) {
      stars.add(full_star);
      count--;
    }
    if(count > 0)
      stars.add(half_star);
    for(var i=1; i<=empty; i++)
      stars.add(empty_star);
    return stars;
  }
}