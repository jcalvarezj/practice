import 'package:flutter/material.dart';
import 'package:platzi_travels_app/place_description.dart';
import 'package:platzi_travels_app/review_list.dart';

import 'constants.dart';
import 'header.dart';

class HomeView extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Stack(
      children: <Widget>[
        ListView(
          children: <Widget>[
            PlaceDescription("Duwili Ella", 4.1, Constants.LOREM),
            ReviewList(),
          ],
        ),
        Header(),
      ],
    );
  }

}