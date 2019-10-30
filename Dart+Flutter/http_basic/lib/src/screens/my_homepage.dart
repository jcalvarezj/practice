import 'package:flutter/material.dart';
import 'package:http_example/src/api/api.dart';
import 'package:http_example/src/models/photo.dart';

class MyHomePage extends StatefulWidget {
  MyHomePage({Key key, this.title}) : super(key: key);

  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int _counter = 0;
  AsyncSnapshot<List<Photo>> snapshot;

  void _incrementCounter() {
    setState(() {
      // This call to setState tells the Flutter framework that something has
      // changed in this State, which causes it to rerun the build method below
      // so that the display can reflect the updated values. If we changed
      // _counter without calling setState(), then the build method would not be
      // called again, and so nothing would appear to happen.
      _counter++;
    });
  }

  Widget buildFuture(BuildContext context, AsyncSnapshot<List<Photo>> snapshot) {
    this.snapshot = snapshot;
    if(snapshot.hasData && snapshot.connectionState == ConnectionState.done)
      return ListView.builder(
          itemCount: snapshot.data.length,
          itemBuilder: buildList,
      );
    else
      return Center(child: CircularProgressIndicator());
  }

  Widget buildList(BuildContext context, int index) {
    return Card(
      child: ListTile(
        leading: CircleAvatar(
          radius: 30,
          backgroundImage: NetworkImage(snapshot.data[index].thumbnailUrl),
        ),
        title: Text(snapshot.data[index].id.toString()),
        subtitle: Text(snapshot.data[index].title),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    API api = API();

   return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(
        child: FutureBuilder<List<Photo>>(
          future: api.getPhotos(),
          builder: buildFuture,
        )
      ),
    );
  }


}
