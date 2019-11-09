import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class PlaceInformation extends StatelessWidget {

  final _title;
  final _description;
  final _steps;

  PlaceInformation(this._title, this._description, this._steps);

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Container(
        width: 250,
        height: 115,
        decoration: BoxDecoration(
          shape: BoxShape.rectangle,
          borderRadius: BorderRadius.all(Radius.circular(10)),
          color: Colors.white,
          boxShadow: <BoxShadow>[
            BoxShadow(
              color: Colors.black,
              blurRadius: 15,
              offset: Offset(0.0,7.0),
            )
          ],
        ),
        child: Container (
          width: 220,
          margin: EdgeInsets.all(10),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: <Widget>[
              Container(
                margin: EdgeInsets.only(
                  top: 10,
                  bottom: 3,
                  right: 10,
                  left: 10,
                ),
                child: Text(
                  _title,
                  style: TextStyle(
                    fontWeight: FontWeight.bold,
                    fontSize: 16,
                  ),
                ),
              ),
              Container(
                width: 120,
                margin: EdgeInsets.only(
                  top: 3,
                  bottom: 3,
                  right: 10,
                  left: 10,
                ),
                child: Text(
                  _description,
                  style: TextStyle(
                    color: Color(0xFFB1B2B4),
                    fontSize: 12,
                  ),
                ),
              ),
              Container(
                margin: EdgeInsets.only(
                  top: 3,
                  bottom: 3,
                  right: 10,
                  left: 10,
                ),
                child: Text(
                  "Steps $_steps",
                  style: TextStyle(
                    color: Color(0xFFDFA059),
                    fontSize: 15,
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }

}