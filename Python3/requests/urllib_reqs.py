"""
Module for making requests via urllib3
"""
import json
from urllib3 import PoolManager

http = PoolManager()


def get_request(url):
    """
    Performs a urllib3 GET request on the specified URL and returns the JSON
    response
    """
    try:
        response = http.request('GET', url)
        if response.status == 200:
            return json.loads(response.data.decode('utf-8'))
        else:
            print(f'The request failed with code {response.status}')
            return None
    except Exception as e:
        print('A problem occurred with the request')
        print(e)
        return None


def post_request(url, dict_data):
    """
    Performs a urllib3 POST request on the specified URL with the input data,
    and returns a JSON response, or None if it failed
    """
    encoded_data = json.dumps(dict_data).encode('utf-8')

    try:
        response = http.request('POST', url, body = encoded_data,
                                headers = {'Content-Type': 'application/json'})
        if response.status == 200:
            return json.loads(response.data.decode('utf-8'))
        else:
            print(f'The request failed with code {response.status}')
            return None
    except Exception as e:
        print('A problem occurred with the request')
        print(e)
        return None
