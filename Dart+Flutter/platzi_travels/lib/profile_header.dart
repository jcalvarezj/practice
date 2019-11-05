import 'package:flutter/material.dart';
import 'package:platzi_travels_app/gradient_background.dart';
import 'package:platzi_travels_app/profile_button_bar.dart';
import 'package:platzi_travels_app/profile_info.dart';

class ProfileHeader extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final background = GradientBackground(
      title: "Profile",
      height: 400,
      gradient: RadialGradient(
        center: Alignment(1,1),
        radius: 0.9,
        colors: [
          Color(0xFF574EC1),
          Color(0xFF506CCD),
        ],
        stops: [0.4, 1.0],
        tileMode: TileMode.clamp,
      ),
    );

    final profileInfo = Column(
      children: <Widget>[
        ProfileInfo("Locke Cole","treasurehunter@figaro.com","assets/img/Locke Cole.jpg"),
      ],
    );

    final configButton = Align(
      alignment: Alignment.topRight,
      child: Container(
        margin: EdgeInsets.only(
          top: 90,
          right: 20,
        ),
        child: Icon(
          Icons.settings,
          color: Colors.white,
          size: 15,
        ),
      ),
    );

    final profileInfoAndButtonBar = Container(
        margin: EdgeInsets.only(
          top: 130,
          left: 15,
        ),
        child: Column(
          children: <Widget>[
            profileInfo,
            ProfileButtonBar(),
          ],
        ),
    );

    return Stack(
      children: <Widget>[
        background,
        configButton,
        profileInfoAndButtonBar
      ],
    );
  }

}