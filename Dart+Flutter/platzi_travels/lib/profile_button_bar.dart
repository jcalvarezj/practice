import 'package:flutter/material.dart';

import 'profile_button.dart';

class ProfileButtonBar extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      margin: EdgeInsets.only(
        top: 5,
        bottom: 5,
      ),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          ProfileButton(
            isMini: true,
            isEnabled: true,
            icon: Icons.bookmark_border,
          ),
          ProfileButton(
            isMini: true,
            isEnabled: false,
            icon: Icons.calendar_today,
          ),
          ProfileButton(
            isMini: false,
            isEnabled: true,
            icon: Icons.add,
          ),
          ProfileButton(
            isMini: true,
            isEnabled: false,
            icon: Icons.mail,
          ),
          ProfileButton(
            isMini: true,
            isEnabled: false,
            icon: Icons.person,
          ),
        ],
      ),
    );
  }

}