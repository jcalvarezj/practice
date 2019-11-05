import "package:flutter/material.dart";
import 'package:platzi_travels_app/constants.dart';

class Review extends StatelessWidget {

  String imagePath = "assets/img/earth.jpg";
  String name = "Pepito Perez";
  String details = "# Reviews - # Photos";
  String comment = "Comentario";
  double rating = 3.5;

  Review(this.name, this.details, this.comment, this.rating, this.imagePath);

  @override
  Widget build(BuildContext context) {
    final profilePicture = Container(
      width: 80,
      height: 80,
      margin: EdgeInsets.only(
        top: 20,
        left: 20,
      ),
      decoration: BoxDecoration(
        shape: BoxShape.circle,
        image: DecorationImage(
          image: AssetImage(imagePath),
          fit: BoxFit.fill,
        ),
      ),
      //child: Image.asset("name"),
    );

    final userName = Container(
      margin: EdgeInsets.only(
        left: 20,
      ),
      child: Text(
        name,
        textAlign: TextAlign.left,
        style: TextStyle(
          fontFamily: Constants.TEXT_FONT,
          fontSize: 17,
        ),
      ),
    );

    final userInfo = Container(
      margin: EdgeInsets.only(
        left: 20,
      ),
      child: Text(
        details,
        textAlign: TextAlign.left,
        style: TextStyle(
          fontFamily: Constants.TEXT_FONT,
          fontSize: 13,
          color: Color(0xFFa3a5a7),
        ),
      ),
    );

    final userComment = Container(
      margin: EdgeInsets.only(
        left: 20,
      ),
      child: Text(
        comment,
        textAlign: TextAlign.left,
        style: TextStyle(
          fontFamily: Constants.TEXT_FONT,
          fontSize: 13,
          fontWeight: FontWeight.w900,
        ),
      )
    );

    final half_star = Container(
      margin: EdgeInsets.only(
        right: 2,
      ),
      child: Icon(
        Icons.star_half,
        color: Colors.yellow,
      ),
    );

    final empty_star = Container(
      margin: EdgeInsets.only(
        right: 2,
      ),
      child: Icon(
        Icons.star_border,
        color: Colors.yellow,
      ),
    );

    final full_star = Container(
      margin: EdgeInsets.only(
        right: 2,
      ),
      child: Icon(
        Icons.star,
        color: Colors.yellow,
      ),
    );

    final content = Row(
      children: <Widget>[
        profilePicture,
        Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
            userName,
            Row(
              children: <Widget>[
                userInfo,
                Row(
                  children: put_stars(full_star, half_star, empty_star),
                ),
              ],
            ),
            userComment,
          ],
        )
      ],
    );

    return content;
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