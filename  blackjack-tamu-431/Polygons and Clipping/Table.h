#ifndef TABLE
#define TABLE
#include <vector>
#include "List.h"
#include <iostream>
using namespace std;

class EdgeTable{
	vector<List> list;

public:

	EdgeTable(){}

	EdgeTable(int size)           // set a table size (to avoid errors later on)
	{
		for(int i =0; i < size; i++)
		{
			List temp;
			list.push_back(temp);
		}
	}

	bool isListEmpty(int i)    // check is a list is empty in the table
	{
		if( i > list.size() )
			return true; 
		return list[i].isempty();
	}


	void addEdge(Edge e, int i)  /// add an edge to the table
	{
		if( i > list.size() )
			return;

		list[i].addEdge(e);		
	}


	Edge removeEList(int i)  /// remove an edge list from the table and return it
	{
		if( i > list.size() )
		{
			Edge emptyE;
			return emptyE;
		}

		return list[i].remove(0);
	}

};



#endif TABLE