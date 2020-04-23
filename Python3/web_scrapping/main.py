"""
Basic Web Scraping Example
"""

import requests
import urllib.request
from bs4 import BeautifulSoup


def main():
    response = requests.get('https://xkcd.com/{}'.format(8))
    soup = BeautifulSoup(response.content, 'html.parser')

    image_div = soup.find(id='comic')
    image_url = image_div.find('img')['src']
    image_name = image_url.split('/')[-1]

    print('Downloading image {} from {}'.format(image_name, 'https:{}'.format(image_url)))
    urllib.request.urlretrieve('https:{}'.format(image_url), image_name)


if __name__ == "__main__":
    main()