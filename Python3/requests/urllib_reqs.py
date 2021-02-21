"""
Module for making requests via urllib3
"""
from urllib3 import PoolManager

http = PoolManager()

def make_request(url):
    """
    Performs a request on the specified URL and returns the raw string of the
    response
    """
    response = http.request('GET', url)
    return response.data.decode('utf-8')
