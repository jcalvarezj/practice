"""
This script is a simple example for making requests with several libraries such
as urllib3, requests, and grequests. It retrieves a random image (its url) from
The Cat API (https://thecatapi.com/).
"""
import json
import urllib_reqs
import requests_reqs

url = 'https://api.thecatapi.com/v1/images/search'

if __name__ == '__main__':
    print('Hello. Please choose your preferred request library:')
    print('1. urllib3\n2. requests\n3. grequests')
    try:
        option = int(input())

        if option == 1:
            make_request = urllib_reqs.make_request
        elif option == 2:
            make_request = requests_reqs.make_request
        elif option == 3:
            pass
            #make_request = urllib_reqs.make_request
        else:
            raise ValueError()

        dict_response = make_request(url)

        print(f'Your picture is at {dict_response[0]["url"]}')
    except ValueError:
        print('Hey, only options 1 to 3!!!')
