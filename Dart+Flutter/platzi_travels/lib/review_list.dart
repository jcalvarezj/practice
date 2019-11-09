import "package:flutter/material.dart";
import "review.dart";

class ReviewList extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Column(
      children: <Widget>[
        Review("Pepito Perez","4 Reviews - 2 Photos","Este lugar es fascinante",3.5,"assets/img/earth.jpg"),
        Review("Pepa Carvajal","3 Reviews - 5 Photos","Bellisimo, 5 de 5",5,"assets/img/default.png"),
        Review("Lolo Lala","1 Review - 2 Photos","Meh. Mala experiencia",2.5,"assets/img/grey.jpg"),
      ],
    );
  }

}