#ifndef EDGE
#define EDGE
#include "Points.h"
class Edge{
	CPoint p1;
	CPoint p2;
	int maxY;
	int minY;
	double currentX;
	double xInc;
	bool horizontal;

public:
	Edge(){}
	Edge(CPoint p1,CPoint p2)     // make an edge from two points. 
	{
		this->p1 = p1;
		this->p2 = p2;
		if (p1.Yvalue() > p2.Yvalue()){
			maxY = p1.Yvalue();
			minY = p2.Yvalue();
			currentX = p2.Xvalue();
			
		}
		else 
			{maxY = p2.Yvalue();
			minY = p1.Yvalue();
			currentX = p1.Xvalue();
			}

		if ((p2.Yvalue()-p1.Yvalue()) == 0){    // handle horizontal edges. 
				horizontal= true; 
		}
		else
		{ 
		horizontal = false; 
		xInc = (double)(p2.Xvalue()-p1.Xvalue()) / (double)(p2.Yvalue()-p1.Yvalue());  // set xInc value and make sure to handle horizontal
		} 
	}
	CPoint returnp1(){return p1;}   // accsess functions
	CPoint returnp2(){return p2;}

	double showCurX() { return currentX;}
	double showxInc() {return xInc;}

	int showMinY() {return minY;}
	int showMaxY() {return maxY;}

	bool showHorizontal() {return horizontal;} 
	void IncX() {currentX += xInc;}

};


#endif EDGE