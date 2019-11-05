import 'package:flutter/material.dart';
import 'package:platzi_travels_app/home_view.dart';
import 'package:platzi_travels_app/profile_view.dart';
import 'package:platzi_travels_app/search_view.dart';

class PlatziTravels extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _PlatziTravels();
  }

}

class _PlatziTravels extends State<PlatziTravels> {
  int _index = 0;

  final List<Widget> _views = [
    HomeView(),
    SearchView(),
    ProfileView()
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: _views[_index],
      bottomNavigationBar: Theme(
        data: Theme.of(context).copyWith(
          canvasColor: Colors.white,
          primaryColor: Colors.purple,
        ),
        child: BottomNavigationBar(
          onTap: onTapTapped,
          currentIndex: _index,
          items: [
            BottomNavigationBarItem(
              icon: Icon(Icons.home),
              title: Text(""),
            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.search),
              title: Text(""),
            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.person),
              title: Text(""),
            ),
          ],
        ),
      ),
    );
  }

  void onTapTapped(int index) {
    setState(() {
      this._index = index;
    });
  }
}