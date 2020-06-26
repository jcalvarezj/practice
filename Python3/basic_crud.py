#!/usr/bin/python3
"""
Simple Python script with CRUD operations on a list
"""

clients = []


def create_client(client_name):
    clients.append(client_name)
    print('Created')


def update_client(client_name, new_name):
    found_index = find_client_index(client_name)
    if found_index != None:
        print(f'Found {clients[found_index]} at {found_index}. Modifying...')
        clients[found_index] = new_name
        print('Modified.')
    else:
        print(f'{client_name} not found')


def delete_client(client_name):
    found_index = find_client_index(client_name)
    if found_index != None:
        del clients[found_index]
        print('Deleted')
    else:
        print(f'{client_name} not found')


def find_client_index(client_name):
    return next((i for i, x in enumerate(clients) if x == client_name), None)


def list_clients():
    print(clients)


def print_welcome():
    print('WELCOME TO THE SALES SYSTEM')
    print('*' * 50)
    print('What would you like to do?')
    print('[C]reate')
    print('[L]ist')
    print('[U]pdate')
    print('[D]elete')
    print('E[x]it')


if __name__ == '__main__':
    finished = False
    while not finished:
        print_welcome()
        option = input().upper()

        if option == 'C':
            create_client(input('Enter the name of the client: '))
        elif option == 'L':
            list_clients()
        elif option == 'X':
            finished = True
        elif option == 'U':
            search_client = input('Enter the name of the client to modify: ')
            new_client = input('Enter the new name: ')
            update_client(search_client, new_client)
        elif option == 'D':
            delete_client(input('Enter the name of the client to delete: '))
        else:
            print('Invalid option')

