#!/usr/bin/python3

"""
This program computes whether a string contains a character that is not
repeated. It should return the first non-repeating character, if it exists, and
an underscore (_), if it doesn't.
@author J. Alvarez
"""

def prompt_user(text):
    """
    This function prompts the user to input something and returns that input.
    """
    print(text)
    return input()


def first_non_repeating_string(text):
    """
    This function returns the first non-repeating character in a string, or an
    underscore if no such character exists.
    """
    counts = {}
    found = '_'
    for letter in text:
        if letter in counts:
            counts[letter]+=1
        else:
            counts[letter] = 1
    print(counts)
    for key, value in counts.items():
        if value == 1:
            found = key
    return found


def main():
    string = prompt_user('Please write a string: ')
    result = first_non_repeating_string(string)
    print('The result is {}'.format(result))


if __name__ == '__main__':
    main()
