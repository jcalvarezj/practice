import 'package:flutter/material.dart';

class MonsterData extends StatelessWidget {

  final String name;
  final int numberKilled;
  final bool isNear;
  final String imagePath;

  MonsterData(this.name, this.numberKilled, this.isNear, this.imagePath);

  @override
  Widget build(BuildContext context) {
    String nearText = isNear ? "NEAR" : "FAR";

    final monsterPicture = Container(
        decoration: BoxDecoration(
          border: Border.all(
            width: 1,
            color: Colors.black54,
          ),
        ),
      child: Container(
        height: 80,
        width: 80,
        margin: EdgeInsets.all(10),
        decoration: BoxDecoration(
          shape: BoxShape.circle,
          image: DecorationImage(
            image: AssetImage(imagePath),
            fit: BoxFit.scaleDown,
          ),
        ),
      )
    );

    final monsterText = Container(
      width: 150,
      decoration: BoxDecoration(
        border: Border.all(
          width: 1,
          color: Colors.black54,
        ),
      ),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          Container(
            margin: EdgeInsets.all(5),
            child: Text(
              name,
              style: TextStyle(
                fontSize: 16,
                fontWeight: FontWeight.bold,
                color: Color(0xFF747474),
              ),
            ),
          ),
          Container(
            margin: EdgeInsets.all(5),
            child: Text(
              "Number beaten: $numberKilled",
              style: TextStyle(
                fontSize: 12,
                color: Color(0xFFAFAFAF),
              ),
            ),
          )
        ],
      ),
    );

    final monsterNearInfo = Expanded(
        child: Container(
          height: 100,
          decoration: BoxDecoration(
            border: Border.all(
              width: 1,
              color: Colors.black54,
            ),
          ),
          child: Container(
            margin: EdgeInsets.only(
              left: 5,
            ),
            child: Row(
              children: <Widget>[
                monsterNearIcon(),
                Text(nearText),
              ],
            ),
          )
        )
    );

    return Container(
      height: 100,
      decoration: BoxDecoration(
        border: Border.all(
          width: 1,
          color: Colors.grey,
        )
      ),
      child: Row(
        children: <Widget>[
          monsterPicture,
          Center(child: monsterText),
          monsterNearInfo,
        ],
      ),
    );
  }

  Widget monsterNearIcon() {
    Color color = isNear ? Colors.red : Colors.black;

    return Container(
      margin: EdgeInsets.all(5),
      height: 40,
      width: 40,
      child: Icon(
        Icons.gps_fixed,
        color: Colors.white,
      ),
      decoration: BoxDecoration(
        shape: BoxShape.circle,
        color: color,
      ),
    );
  }
}