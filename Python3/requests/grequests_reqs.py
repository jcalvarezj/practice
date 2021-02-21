"""
Module for making requests via the grequests library
"""
import grequests


def handle_exception(request, exception):
    """
    Callback function to handle an exception at the moment of sending a request
    """
    print('Problem with the request')
    print(exception)


def get_request(url):
    """
    Sends a 'grequests' request using the GET method on the specified URL and
    returns a json response, or None if it failed
    """
    pending_requests = [grequests.get(url)]  # List of "Promises"

    responses = grequests.map(pending_requests,
                              exception_handler = handle_exception)

    if responses[0].status_code == 200:
        return responses[0].json()
    else:
        print(f'The request failed with code {response[0].status_code}')
        return None


def post_request(url, dict_data):
    """
    Sends a 'grequests' request using the POST method on the specified URL and
    the input data. Returns a json response or None if failed
    """
    pending_requests = [grequests.post(url, json = dict_data)]  # List of "Promises"

    responses = grequests.map(pending_requests,
                              exception_handler = handle_exception)

    if responses[0].status_code == 200:
        return responses[0].json()
    else:
        print(f'The request failed with code {response[0].status_code}')
        return None

