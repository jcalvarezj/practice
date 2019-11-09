import 'package:flutter/material.dart';

class ProfileButton extends StatelessWidget {
  final bool isMini;
  final bool isEnabled;
  final icon;

  ProfileButton({this.isMini, this.isEnabled, this.icon});

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: EdgeInsets.symmetric(horizontal: 9),
      child: FloatingActionButton(
        mini: isMini,
        backgroundColor: isEnabled ? Colors.white : Color(0xFFA8B2E5),
        child: Icon(
            icon,
            color: Color(0xFF5551CA),
        ),
      ),
    );
  }

}