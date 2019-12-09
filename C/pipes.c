/*
 * Pipes basic example. The program reads the file entered as program argument
 * using the parent process, and sends information to its child process, so it
 * identifies which one is the biggest character in each chunk of data
 *
 * @author J. Alvarez
 */

#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <sys/wait.h>

#define MSG_SIZE 16

int main(int argc, char * argv[]) {
	if(argc != 2) {
		printf("I REQUIRE THE ARGUMENT OF FILE TO READ\n");
		return 1;
	}

	else {
		int pid, pipes[2];

		if(pipe(pipes) < 0) {
	
			printf("I could not create the pipes\n");
			return 1;
		}
		else {
			FILE * input = fopen(argv[1],"r");

			if (!input) {
				printf("I can't open that file");
				return 1;
			}
			else {
				pid = fork();

				if(pid) {
					char buffer[MSG_SIZE];
					printf("I am the parent process. Reading file contents\n");
					
					while(fgets(buffer,MSG_SIZE,input)) {
						printf("Parent just read %s", buffer);
						printf(" .%d, give me the biggest character\n", pid);

						write(pipes[1],buffer,MSG_SIZE);
					}
					fclose(input);
					close(pipes[1]);
					printf("Parent waiting child to process...\n");
					wait(NULL);
					close(pipes[0]);
				}
				else {
					close(pipes[1]);
					char buffer[MSG_SIZE];
					char max;
					int i;

					printf("I am the child process... Waiting for something ");
					printf("to appear in the pipe\n");

					while( read(pipes[0],buffer,MSG_SIZE) ) {
						printf("Child just read %s\n", buffer);
						max = buffer[0];
						for(i=0; i<MSG_SIZE; i++)
							if(buffer[i] > max)
								max = buffer[i];

						printf("Child detected biggest character in this line");
						printf(" is %c\n",max);
					}

					close(pipes[0]);	
				}

				return 0;
			}
		}
	}
}
