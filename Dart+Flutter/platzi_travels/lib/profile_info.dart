import 'package:flutter/material.dart';

class ProfileInfo extends StatelessWidget {
  final String name;
  final String email;
  final String photoPath;

  const ProfileInfo(this.name, this.email, this.photoPath);

  @override
  Widget build(BuildContext context) {
    final photo = Container(
      height: 80,
      width: 80,
      //margin: EdgeInsets.all(5),
      decoration: BoxDecoration(
        image: DecorationImage(
          image: AssetImage(photoPath),
          fit: BoxFit.cover,
        ),
        shape: BoxShape.circle,
        border: Border.all(
          width: 1,
          color: Colors.white,
        )
      ),
    );
    
    final textInfo = Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: <Widget>[
        Container(
          margin: EdgeInsets.only(left: 15),
          child: Text(
            name,
            style: TextStyle(
              color: Colors.white,
              fontWeight: FontWeight.bold,
              fontSize: 18,
            ),
          ),
        ),
        Container(
          margin: EdgeInsets.only(left: 15),
          child: Text(
            email,
            style: TextStyle(
              color: Color(0xFF818FE8),
              fontWeight: FontWeight.bold,
            ),
          ),
        ),
      ],
    );
    
    return Row(
      children: <Widget>[
        photo,
        textInfo,
      ],  
    );
  }
}