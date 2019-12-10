/*
 * Basic queue example. Doesn't alter the queue elements' position value.
 * This queue is not limited to a fix number of maximum amount of elements.
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
void freeNodeMemory(Node * node);
Queue * createQueue();
void enqueue(Queue ** queue, Node * node);
Node * dequeue(Queue ** queue); //Please free that node's memory after used
Node * peek(Queue * queue);
void printQueue(Queue * queue);
void freeQueueMemory(Queue * queue);

int main() {

	Node * n1 = createNode("Pepe");
	Node * n2 = createNode("Andrea");
	Node * n3 = createNode("Steven");
	Node * n4 = createNode("Darla");

	Queue * q = createQueue();

	enqueue(&q,n1);
	enqueue(&q,n2);
	enqueue(&q,n3);
	enqueue(&q,n4);

	printQueue(q);

	printf("The front of the queue is: ");
	printNode(peek(q));

	Node * nextInQ = dequeue(&q);

	printf("I have dequeued:");
	printNode(nextInQ);

	printf("Disposing it for good...\n");
	freeNodeMemory(nextInQ);

	printf("So the new front is: ");
	printNode(peek(q));

	printf("And now the queue is...\n");

	printQueue(q);

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
	if(!node)
		printf("NULL\n");
	else
		printf("[%d]: %s\n",node->pos,node->info);
}

void freeNodeMemory(Node * node) {
	if(node)
		free(node);
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
		printNode(node);
		node->pos = (*queue)->rear->pos + 1;
		(*queue)->rear->next = node;
		(*queue)->rear = node;

		(*queue)->size++;
	}
}

Node * dequeue(Queue ** queue) {
	if(!(*queue))
		return NULL;
	else {
		Node * head = (*queue)->front;

		if(!head->next) {
			(*queue)->front = NULL;
			(*queue)->rear = NULL;
		}
		else
			(*queue)->front = head->next;

		(*queue)->size--;

		return head;
	}
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
		do {
			printNode(aux);
			aux = aux->next;
		} while(aux->next);
		printNode(aux);
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
