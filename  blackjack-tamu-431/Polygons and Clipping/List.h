#ifndef LIST
#define LIST
#define NULL 0

#include "Points.h"
#include "Edge.h"

struct Node {
	Edge ele; 
	Node *next;
	Node(){}
};

class List {
	Node *head;
	int size;
public:

	List(){ 
		head = NULL;
		size = 0;
	}

	bool isempty(){return size == 0;} // check if its empty

	Node* retHead(){ return head;}

	Edge getElement(int i){             // get the element at i
		if (isempty() || i >= size) {
			Edge emptyE;
			return emptyE;}
		Node* index = head;
		for(int j = 0; j < i; j++)
			index = index->next; 
		return index->ele;
	}

	Edge remove(int i) {		 // remove an edge from the list
		if (isempty() || i >= size) {
			Edge emptyE;
			return emptyE;}
		if(i == 0){
			Node* temp = head; 
			head = temp->next; 
			Edge e = temp->ele; 
			delete temp;
			size --; 
			return e; 
		}
		else{
			Node* previous = NULL; 
			Node* current = head; 

			for( int j = 0; j < i; j++)
			{
				previous = current; 
				current = current->next;
			}
			Edge e= current->ele;
			previous->next = current->next;
			delete current;
			size --;
			return e; 
		}
	}	

	void addEdge(Edge edge){   // add an edge to the list
		Node* node = new Node; 
		node->ele = edge;
		if(isempty())
		{
			head = node; 
			size ++;
			return;
		}
			
		Node* previous = NULL; 
		Node* current = head; 
		int i = 0;

		while( (i < size) && (current->ele.showCurX() < edge.showCurX() || ((current->ele.showCurX() == edge.showCurX()) && (current->ele.showxInc() < edge.showxInc()))))
		{
			previous = current; 
			current = current->next;
			i++;
		}

		if(i ==0) head = node; 
		if(i!=0)previous->next = node; 
		node->next = current; 
		size ++; 
		return;
	}

	void MoveInc()  // inc the line for table
	{ 
		if(isempty())	return;
		
		Node* start = head; 

		start->ele.IncX();

		for(int j = 1 ; j < size; j++)
		{
			start = start->next; 
			start->ele.IncX();
		}

	}

	int showSize(){     // return the size
		return size;
	}
};



#endif LIST