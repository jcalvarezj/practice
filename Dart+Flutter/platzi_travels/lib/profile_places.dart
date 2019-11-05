import 'package:flutter/material.dart';
import 'package:platzi_travels_app/travel_entry.dart';

class ProfilePlaces extends StatelessWidget {
  @override
  Widget build(BuildContext context) {

    return Container(
      margin: EdgeInsets.only(
        top: 300,
      ),
      child: ListView(
        children: <Widget>[
          TravelEntry(
            title: "Mt. Kolts",
            description: "Perfect for training martial arts",
            steps: 12000,
            imagePath: "assets/img/mountains.jpg",
          ),
          TravelEntry(
            title: "Flower field",
            description: "A beautiful place for meditation",
            steps: 12000,
            imagePath: "assets/img/mountains.jpg",
          ),
          TravelEntry(
            title: "St. Karlo of Figaro",
            description: "Amazing views and excellent services",
            steps: 12000,
            imagePath: "assets/img/bettertips.jpg",
          ),
        ],
      ),
    );
  }

}