/*
 * Basic queue example
 *
 * @author J. Alvarez
 */

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#define MAX_STR_SIZE 50

typedef char String[MAX_STR_SIZE];

typedef struct Node {
	String info;
	int pos;
	struct Node * next;
} Node;

typedef struct Queue {
	Node * front;
	Node * rear;
	int size;
} Queue;

Node * createNode(String data);
void printNode(Node * node);
Queue * createQueue();
void enqueue(Queue ** queue, Node * node);
Node * dequeue(Queue * queue); //TODO
Node * peek(Queue * queue);
void printQueue(Queue * queue);
void freeQueueMemory(Queue * queue);

int main() {

	Node * n1 = createNode("Pepe");
	Node * n2 = createNode("Andrea");
	Node * n3 = createNode("Steven");

	Queue * q = createQueue();

	enqueue(&q,n1);
	enqueue(&q,n2);
	enqueue(&q,n3);

	printQueue(q);

	printf("The front of the queue is: ");
	printNode(peek(q));

//	q = dequeue();

//	printQueue(q);
	freeQueueMemory(q);

	return 0;
}

Node * createNode(String data) {
	Node * node = malloc(sizeof(Node));
	
	strcpy(node->info,data);
	node->pos = -1;
	node->next = NULL;
}

void printNode(Node * node) {
	printf("[%d]: %s\n",node->pos,node->info);
}

Queue * createQueue() {
	Queue * queue = malloc(sizeof(Queue));
	queue->front = NULL;
	queue->rear = NULL;
}

void enqueue(Queue ** queue, Node * node) {
	if(!((*queue)->rear)) {
		node->pos = 0;

		(*queue)->rear = node;
		(*queue)->front = node;

		(*queue)->size = 1;
	}
	else {
		node->pos = (*queue)->rear->pos + 1;
		(*queue)->rear->next = node;
		(*queue)->rear = node;

		(*queue)->size++;
	}
}

Node * dequeue(Queue * queue) {
	return NULL;
}

Node * peek(Queue * queue) {
	if(!queue)
		return NULL;
	else 
		return queue->front;
}

void printQueue(Queue * queue) {
	Node * aux = queue->front;

	if(!queue->front)
		printf("The queue is empty\n");
	else {
		char * plural = queue->size == 1 ? "element" : "elements";
		printf("The queue has %d %s and is as follows:\n",queue->size, plural);
		printNode(aux);
		while(aux->next) {
			printNode(aux->next);
			aux = aux->next;
		}
	}	
}

void freeQueueMemory(Queue * queue) {
	if(queue) {
		if(!(queue->front)) {
			free(queue);
		}
		else {
			Node * initial = queue->front;
			while(initial->next) {
				Node * aux = initial;
				initial = aux->next;	
				free(aux);
			}
			free(initial);
			free(queue);
		}
	}
}
