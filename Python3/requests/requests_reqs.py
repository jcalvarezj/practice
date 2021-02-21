"""
Module for making requests via the requests library
"""
import requests

def make_request(url):
    """
    Performs a 'requests' request on the specified URL and returns the raw string of the
    response
    """
    response = requests.get(url)
    return response.json()
