/*
 * Basic sockets example. Server code. Requires port number as program argument.
 *
 * @author J. Alvarez
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <arpa/inet.h>
#include <netinet/in.h>

#define MAX_CONNECTIONS 5

int main(int argc, char ** args) {
	int exitCode = 0;
	if(argc != 2) {
		printf("Sorry, we need only one argument: Port Number\n");
		exitCode = -1;
	}
	else {
		int port = atoi(args[1]);
		int clientMsgLength = sizeof(struct sockaddr_in);
		int serverSocket, clientSocket;

		struct sockaddr_in server, client;

		server.sin_family = AF_INET; // IPv4
		server.sin_port = htons(port); // Set port
		server.sin_addr.s_addr = INADDR_ANY; // Accept from any address
		bzero(&(server.sin_zero), 8); // Clean bytes to avoid problems

		printf("Trying to create the socket...\n");

		serverSocket = socket(AF_INET, SOCK_STREAM, 0); // new TCP/IP socke

		if(serverSocket == -1) {
			fprintf(stderr,"Socket creation failed\n");
			exitCode = -2;
		}
		else {
			printf("Trying to open port %d to socket %d\n", port, serverSocket);

			int binding = bind(serverSocket, (struct sockaddr *) &server,
					sizeof(struct sockaddr));

			if(binding == -1) {
				fprintf(stderr,"Port opening failed... Firewall? Used?\n");
				exitCode = -3;
			}
			else {
				printf("Starting to listen on socket %d\n", serverSocket);

				int listening = listen(serverSocket, MAX_CONNECTIONS);

				if(listening == -1) {
					fprintf(stderr,"Could not listen\n");
					exitCode = -4;
				}
				else {
					printf("Waiting for a client...\n");

					clientSocket = accept(serverSocket,	(struct sockaddr *) 
						   &client, &clientMsgLength);

					if(clientSocket == -1) {
						fprintf(stderr,"The connection could not be accepted\n");
						exitCode = -5;
					}
					else {
						char message[] = "Hola cliente, ¡¡bienvenido!!\n";
						char address[INET_ADDRSTRLEN];
						
						inet_ntop(AF_INET, &(client.sin_addr), address,
								INET_ADDRSTRLEN);
	
						printf("A client connected from %s:%d!!!\n", address,
								client.sin_port);

						send(clientSocket, message, strlen(message), 0);

						shutdown(clientSocket,2);
						shutdown(serverSocket,2);
					}
				}
			}
		}
	}

	return exitCode;
}

