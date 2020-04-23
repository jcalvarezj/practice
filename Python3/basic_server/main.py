"""
A very basic Flask server
Remember to run in a virtual environment and install dependencies using
pip install -r requirements.txt
"""

from flask import Flask

app = Flask(__name__)

@app.route('/')
def greet():
    return "<b>Hello World</b>"


if __name__ == "__main__":
    app.run()