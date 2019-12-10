/*
 * Basic sockets example. Client side. Requires server IP and port number as 
 * program arguments (in that order).
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
#define BUFFER_SIZE 100

int main(int argc, char ** args) {
	int exitCode = 0;
	if(argc != 3) {
		printf("Sorry, we need two arguments: Port Number and IP Address\n");
		exitCode = -1;
	}
	else {
		int port = atoi(args[2]);
		char * serverIp = args[1];

		int clientSocket, bytes;

		struct sockaddr_in server;

		printf("Resolving IP address...\n");

		int validIp = inet_pton(AF_INET, serverIp, &server.sin_addr);

		if(validIp <= 0) {
			fprintf(stderr,"IP is not valid\n");
			exitCode = -2;
		}
		else {
			printf("Trying to open the client socket...\n");

			clientSocket = socket(AF_INET, SOCK_STREAM, 0);

			if(clientSocket < 0) {
				fprintf(stderr,"Could not open socket\n");
				exitCode = -3;
			}
			else {
				server.sin_family = AF_INET;
				server.sin_port = htons(port);
				bzero(&(server.sin_zero),8);

				printf("Trying to connect with server...\n");

				int connection = connect(clientSocket, (struct sockaddr *)
						&server, sizeof(struct sockaddr));

				if(connection < 0) {
					fprintf(stderr,"Could not connect to server\n");
					exitCode = -4;
				}
				else {
					printf("Trying to read from server...\n");

					char buffer[BUFFER_SIZE];
					int receivedBytes = recv(clientSocket, buffer, BUFFER_SIZE,
							0);

					if (receivedBytes < 0) {
						fprintf(stderr,"Read error\n");
						exitCode = -5;
					}
					else {
						buffer[receivedBytes] = '\0';

						printf("The server sent the following message:\n%s\n",
								buffer);

						shutdown(clientSocket, 2);
					}
				}
			}
		}
	}

	return exitCode;
}

