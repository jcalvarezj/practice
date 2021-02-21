"""
Module for making requests via the requests library
"""
import requests


def get_request(url):
    """
    Performs a 'requests' GET request on the specified URL and returns a JSON
    response, or None if it failed
    """
    try:
        response = requests.get(url)

        if response.status_code == 200:
            return response.json()
        else:
            print(f'The request failed with code {response[0].status_code}')
            return None
    except Exception as e:
        print('A problem occurred with the request')
        print(e)
        return None


def post_request(url, dict_data):
    """
    Performs a 'requests' POST request on the specified URL with the input data,
    and returns a JSON response, or None if it failed
    """
    response = requests.post(url, json = dict_data)

    if response.status_code == 200:
        return response.json()
    else:
        print(f'The request failed with code {response[0].status_code}')
        return None
