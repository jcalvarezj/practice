import 'package:http/http.dart';
import 'package:http_example/src/models/photo.dart';

class API {
  static const url = 'https://jsonplaceholder.typicode.com/photos';

  final Client _client = Client();

  Future<List<Photo>> getPhotos() async {
    List<Photo> photos;

    final response = await _client.get(url);
    photos = photoFromJson(response.body);

    return photos;
  }
}