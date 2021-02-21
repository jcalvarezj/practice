"""
Module for making requests via urllib3
"""
import json
from urllib3 import PoolManager

http = PoolManager()

def make_request(url):
    """
    Performs a urllib3 request on the specified URL and returns the raw string of the
    response
    """
    response = http.request('GET', url)
    return json.loads(response.data.decode('utf-8'))
