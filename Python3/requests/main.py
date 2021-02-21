"""
This script is a simple example for making requests with several libraries such
as urllib3, requests, and grequests. For GET requests, it retrieves a random
image url from the Cat API (https://thecatapi.com/); for POST requests, it
sends a small dictionary of data to the Postman Echo service
(https://postman-echo.com), which will echoed that data as a response
"""
import gevent.monkey
gevent.monkey.patch_all() # Supress warnings (from overlapping libraries import)

import json
import urllib_reqs
import requests_reqs
import grequests_reqs


urls = (
    'https://api.thecatapi.com/v1/images/search',
    'https://postman-echo.com/post'
)
data = { 'text': 'Hello World!' }
get_functions = (
    urllib_reqs.get_request,
    requests_reqs.get_request,
    grequests_reqs.get_request
)

def run():
    print('Hello. Please choose the request method:')
    print('1. GET (random cat image URL)\n2. POST (echo data)')
    try:
        url_option = int(input())

        if url_option >= 1 and url_option <= 2:
            chosen_url = urls[url_option-1]

            print('Now choose your preferred request library:')
            print('1. urllib3\n2. requests\n3. grequests')

            method_option = int(input())

            if method_option >= 1 and method_option <= 3:
                make_request = get_functions[method_option-1]
                dict_response = make_request(chosen_url)
                print(f'Your picture is at {dict_response[0]["url"]}')
            else:
                raise ValueError('Only options are 1 to 3!!!')
        else:
            raise ValueError('Only options are 1 and 2!!!')
    except ValueError as ve:
        print(ve)


if __name__ == '__main__':
    run()
