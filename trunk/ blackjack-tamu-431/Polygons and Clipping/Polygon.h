#ifndef POLYGON
#define POLYGON

#include <vector>
#include "Edge.h"
#include <climits>

using namespace std;

class CPolygon{
	vector<CPoint> points;  
	int color;
public:
	
	CPolygon(){ color = 0;}   // init color

	void addPolygon(CPoint p)  // add points to the Polygon class
	{
		points.push_back(p);
	}

	void set(int i, CPoint p) {    //set the point on the list; 

		points[i] = p;
	}

	int setColor(int i){        // set the color
		color = i;
		return color;
	}
	int showColor(){             // accsess the color
		return color;
	}

	vector<CPoint> showPoints(){           // show the points 
		return points;
	}

	int minX()                                    // find the minX, maxX, minY, maxY
	{ 
		int min = INT_MAX; 
		for(int i= 0; i < points.size(); i++)
			if(points[i].Xvalue() < min)
				min = points[i].Xvalue();
		return min;
	}

	int	maxX() {		
		int max = INT_MIN; 
	    for(int i= 0; i < points.size(); i++)
			if(points[i].Xvalue() > max)
				max = points[i].Xvalue();
		return max;
	}
	int	minY() {
		int min = INT_MAX; 
		for(int i= 0; i < points.size(); i++)
		if(points[i].Yvalue() < min)
		min = points[i].Yvalue();
		return min;
	}
	int	maxY() {
			int max = INT_MIN; 
			for(int i= 0; i < points.size(); i++)
			if(points[i].Yvalue() > max)
				max = points[i].Yvalue();
			return max;
	}

	vector<Edge> edges()     // make a vector of edges from the Polygon. 
	{
		vector<Edge> e;
		Edge edge;

		if (points.size() != 0){
		for(int i = 0; i < points.size()-1; i++){ 
			edge = Edge(points[i],points[i+1]);
		 if(edge.showHorizontal() == false)
				e.push_back(edge);
		}
		edge = Edge(points[0], points[points.size()-1]);
			if(edge.showHorizontal() == false)
				e.push_back(edge);
			return e;
			}
	}

	void clear()
	{
		points.clear();
	}

};


#endif POLYGON