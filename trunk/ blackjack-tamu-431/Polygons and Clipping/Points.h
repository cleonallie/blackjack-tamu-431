#ifndef POINTS
#define POINTS

class CPoint{
	int x, y, z;
public:
	CPoint(){}
	CPoint(int a, int b, int c){ make_point(a,b,c);}   // constructor
	void make_point( int a, int b, int c)              // set values to the point
	{
		x = a;
		y = b;
		z = c;
	}
	int Xvalue(){return x;}								//accsess functions
	int Yvalue(){return y;}
	int Zvalue(){return z;}
};


#endif POINTS