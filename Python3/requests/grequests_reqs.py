"""
Module for making requests via the grequests library
"""
import grequests

def make_request(url):
    """
    Performs a 'grequests' request on the specified URL and returns the raw string of the
    response
    """
    pending_requests = [grequests.get(url)]  # List of "Promises"

    responses = grequests.map(pending_requests)

    return responses[0].json()
