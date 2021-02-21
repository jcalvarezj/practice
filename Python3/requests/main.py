"""
This script is a simple example for making requests with several libraries such
as urllib3, requests, and grequests. It retrieves a random image (its url) from
The Cat API (https://thecatapi.com/).
"""
import gevent.monkey
gevent.monkey.patch_all() # Supress warnings (from overlapping libraries import)

import json
import urllib_reqs
import requests_reqs
import grequests_reqs


url = 'https://api.thecatapi.com/v1/images/search'
data = { 'text': 'Hello World!' }
get_functions = (
    urllib_reqs.make_request,
    requests_reqs.make_request,
    grequests_reqs.make_request
)

def run():
    print('Hello. Please choose your preferred request library:')
    print('1. urllib3\n2. requests\n3. grequests')
    try:
        option = int(input())

        if option >= 1 and option <= 3:
            make_request = get_functions[option-1]
            dict_response = make_request(url)
            print(f'Your picture is at {dict_response[0]["url"]}')
        else:
            raise ValueError()
    except ValueError:
        print('Hey, only options 1 to 3!!!')


if __name__ == '__main__':
    run()
