// Kevin McFarlen
// CSCE 441 SRPING 2012
// 118000899

#include <iostream>
#include <gl/glut.h>
#include <gl/gl.h>
#include <vector>
#include <list>
#include <math.h>
#include <time.h>
#include "Polygon.h"
#include "Table.h"

using namespace std;
/******************************************************************
	Notes:
	Image size is 400 by 400 by default.  You may adjust this if
		you want to.
	You can assume the window will NOT be resized.
	Call clearFramebuffer to clear the entire framebuffer.
	Call setFramebuffer to set a pixel.  This should be the only
		routine you use to set the color (other than clearing the
		entire framebuffer).  drawit() will cause the current
		framebuffer to be displayed.
	As is, your scan conversion should probably be called from
		within the display function.  There is a very short sample
		of code there now.
	You may add code to any of the subroutines here,  You probably
		want to leave the drawit, clearFramebuffer, and
		setFramebuffer commands alone, though.
  *****************************************************************/

#define ImageW 400
#define ImageH 400

float framebuffer[ImageH][ImageW][3];


vector<int>positionX;  // vector for X values
vector<int>positionY;  // bector for Y values
vector<CPoint> points; 

bool clippingON = false;

vector<CPolygon> polygons;

CPolygon clipwindow;

bool NewPoly = true ; 

class Color {    // color class, used to randomize the polygons
	float r,b,g;
	int color; 
public:
	Color(){color = 6;}
	void setColor(int i)
	{
		color = i;
		switch(color){
			case 1:  r = 1.0; b=0.0; g= 0.0; glColor3f ( 1,0,0); break;  // red
			case 2:  r = 0.0; b=1.0; g= 0.0; glColor3f ( 0,1,0); break;  // green
			case 3:  r = 1.0; b=1.0; g= 0.0; glColor3f ( 1,1,0); break;  // yellow
			case 4:  r = 0.0; b=0.0; g= 1.0; glColor3f ( 0,0,1); break;  // blue 
			case 5:  r = 1.0; b=0.0; g= 1.0; glColor3f ( 1,0,1); break;  // pink
			case 6:  r = 0.0; b=1.0; g= 1.0; glColor3f ( 0,1,1); break;  // light blue
			case 7:	 r = 1.0; b=1.0; g= 1.0; glColor3f ( 1,1,1); color = 1;   break;
		}
	}
	int showColor(){return color;}
	void incColor(){color++;
		switch(color){
			case 1:  r = 1.0; b=0.0; g= 0.0; glColor3f ( 1,0,0); break;  // red
			case 2:  r = 0.0; b=1.0; g= 0.0; glColor3f ( 0,1,0); break;  // green
			case 3:  r = 1.0; b=1.0; g= 0.0; glColor3f ( 1,1,0); break;  // yellow
			case 4:  r = 0.0; b=0.0; g= 1.0; glColor3f ( 0,0,1); break;  // blue 
			case 5:  r = 1.0; b=0.0; g= 1.0; glColor3f ( 1,0,1); break;  // pink
			case 6:  r = 0.0; b=1.0; g= 1.0; glColor3f ( 0,1,1); break;  // light blue
			case 7:	 r = 1.0; b=1.0; g= 1.0; glColor3f ( 1,1,1); color = 1;   break;}
	}
	float showRed(){return r;}
	float showBlue(){return b;}
	float showGreen(){return g;}
};

// Draws the scene
void drawit(void)
{
   glDrawPixels(ImageW,ImageH,GL_RGB,GL_FLOAT,framebuffer);
}

// Clears framebuffer to black
void clearFramebuffer()
{
	int i,j;

	for(i=0;i<ImageH;i++) {
		for (j=0;j<ImageW;j++) {
			framebuffer[i][j][0] = 0.0;
			framebuffer[i][j][1] = 0.0;
			framebuffer[i][j][2] = 0.0;
		}
	}
}

// Sets pixel x,y to the color RGB
// I've made a small change to this function to make the pixels match
// those returned by the glutMouseFunc exactly - Scott Schaefer 
void setFramebuffer(int x, int y, float R, float G, float B)
{
	// changes the origin from the lower-left corner to the upper-left corner
	y = ImageH - 1 - y;
	if (R<=1.0)
		if (R>=0.0)
			framebuffer[y][x][0]=R;
		else
			framebuffer[y][x][0]=0.0;
	else
		framebuffer[y][x][0]=1.0;
	if (G<=1.0)
		if (G>=0.0)
			framebuffer[y][x][1]=G;
		else
			framebuffer[y][x][1]=0.0;
	else
		framebuffer[y][x][1]=1.0;
	if (B<=1.0)
		if (B>=0.0)
			framebuffer[y][x][2]=B;
		else
			framebuffer[y][x][2]=0.0;
	else
		framebuffer[y][x][2]=1.0;
}

vector<CPoint> clippingP;


void clipwindowF (){
	
	glColor3f ( 1,1,1);
	GLfloat vert1[3] = {clipwindow.showPoints()[0].Xvalue(),clipwindow.showPoints()[0].Yvalue(),0};
	GLfloat vert2[3] = {clipwindow.showPoints()[1].Xvalue(),clipwindow.showPoints()[1].Yvalue(),0};
	GLfloat vert3[3] = {clipwindow.showPoints()[2].Xvalue(),clipwindow.showPoints()[2].Yvalue(),0};
	GLfloat vert4[3] = {clipwindow.showPoints()[3].Xvalue(), clipwindow.showPoints()[3].Yvalue(), 0};
	
	glBegin(GL_LINES);
		glVertex3fv(vert1);
		glVertex3fv(vert2);
	
		glVertex3fv(vert1);
		glVertex3fv(vert4);

		glVertex3fv(vert2);
		glVertex3fv(vert3);

		glVertex3fv(vert3);
		glVertex3fv(vert4);
	glEnd();
	glFlush();
	}
void display(void)
{
	drawit();
	if (clippingON)
		glutDisplayFunc(clipwindowF);

	glFlush();
}

void init(void)
{
	gluOrtho2D ( 0, ImageW - 1, ImageH - 1, 0 );
	clearFramebuffer();
}

void keyboard ( unsigned char key, int x, int y ) // when the user presses the keys on the keyboard this function is called
{
	switch (key) {
			case 'c': if(clippingON == false) {clippingON = true; break;} 
					  else if(clippingON == true){clippingON = false; glutDisplayFunc(display);  break;}
					  break;
			
	}
}	
Color col;

void fillPolygon(CPolygon pol)
{
	Color filler; 
	filler.setColor(pol.showColor());
	int line = 0;
	EdgeTable table(ImageH);
	List list;
	vector<Edge> tempVector = pol.edges();
	
	while(tempVector.size() != 0){				//whiles list not empty
		line = tempVector[0].showMinY();		// store int line = minY
		table.addEdge(tempVector[0],line);		// add first edge to table at line
		tempVector.erase(tempVector.begin());	// erase that edge
	
		for(int i = 0; i <  tempVector.size(); i++){

			if (list.getElement(i).showMinY() == line)
			{
				table.addEdge(pol.edges()[i],line);		//   if (edge [i] minY == line) add it to the table at Line
				table.removeEList(i);					//	erase it
				--i;
			}
		}
	}
	line = 0; 
	while (line < ImageH ){
		
		while(!table.isListEmpty(line))// Add edges to Active Edge List from Active Edge Table starting at line
		{
			list.addEdge(table.removeEList(line));
		}

		for(int i =0; i < list.showSize(); i++ )//Remove edges that end at line
		{
			if(list.getElement(i).showMaxY() == line){
				list.remove(i);
				i--;}
		}
		
		
		for ( int i = 0; i < list.showSize()/2; i++){ //Fill pixels
			int x = list.getElement(2*i).showCurX();
			int x2 = list.getElement(2*i + 1).showCurX();
			
			while(x < x2){
				
				setFramebuffer( x++, line, filler.showRed(), filler.showBlue(), filler.showGreen());
			}
		}
		list.MoveInc();//Increment x-values on edges in Active Edge List
		line++;//Increment line
	}

} ////////////////////////////////// error here ///////////////////////////
	
int get_case(CPoint subj_one, CPoint subj_two, char side) {
	switch(side) {
		case 'l' :
			if(subj_one.Xvalue() >= clipwindow.minX()) {
				if(subj_two.Xvalue() >= clipwindow.minX())
					return 2;
				else
					return 3;
			}
			else {
				if(subj_two.Xvalue() >= clipwindow.minX())
					return 4;
				else
					return 1;
			}
			break;
		case 'r' : 
			
			if(subj_one.Xvalue() <= clipwindow.maxX()) {
				if(subj_two.Xvalue() <= clipwindow.maxX())
					return 2;
				else
					return 3;
			}
			else {
				if(subj_two.Xvalue() <= clipwindow.maxX())
					return 4;
				else
					return 1;
			}
			break;
		case 'b' : 
			if(subj_one.Yvalue() <= clipwindow.maxY()) {
				if(subj_two.Yvalue() <= clipwindow.maxY())
					return 2;
				else
					return 3;
			}
			else {
				if(subj_two.Yvalue() <= clipwindow.maxY())
					return 4;
				else
					return 1;
			}
			break;
		case 't' : 
			if(subj_one.Yvalue() >= clipwindow.minY()) {
				if(subj_two.Yvalue() >= clipwindow.minY())
					return 2;
				else
					return 3;
			}
			else {
				if(subj_two.Yvalue() >= clipwindow.minY())
					return 4;
				else
					return 1;
			}
			break;
	}
	return 0;
}

// Logic for Clipping came from CSCE 441 Clipping Polygons Slide Show, and some with Andy Hamptons assistance.
CPolygon get_clipped_polygon(CPolygon poly) {  // used to clip the window
	
	CPolygon p;
	p.setColor(poly.showColor());
	char clipping_side = 'l';  // Current side being clipped to
									
	list<CPoint> L, R, B, T, result; // Lists for each Edge
	
	for(int i = 0; i < poly.showPoints().size(); i++) { // Initialize Left list with all points
		L.push_front(poly.showPoints()[i]);
	}
	L.push_front(poly.showPoints()[0]);

	
	while(clipping_side != 'q') {// Run until done
		int size;
	
		switch(clipping_side) { // set size
			case 'l' : size = L.size() - 1; break;
			case 'r' : size = R.size() - 1; break;
			case 'b' : size = B.size() - 1; break;
			case 't' : size = T.size() - 1; break;
		}

		for(int i = 0; i < size; i++) {
			double m;
			int xValues, yValues;
			CPoint one, two;
			// Set Point one and two appropriately
			switch(clipping_side) {
				case 'l' : one = L.back(); L.pop_back(); two = L.back(); break;
				case 'r' : one = R.back(); R.pop_back(); two = R.back(); break;
				case 'b' : one = B.back(); B.pop_back(); two = B.back(); break;
				case 't' : one = T.back(); T.pop_back(); two = T.back(); break;
			}
			

			switch(get_case(one, two, clipping_side)) {
				case 1 : 
					// No Output
					break;
				case 2 : 
					// Output Two
					switch(clipping_side) {
						case 'l' : R.push_front(two); break;
						case 'r' : B.push_front(two); break;
						case 'b' : T.push_front(two); break;
						case 't' : result.push_front(two); break;
					}
					break;
				case 3 : 
					// Output Intersection
					m = (double)(two.Yvalue() - one.Yvalue()) / (double)(two.Xvalue() - one.Xvalue());
					switch(clipping_side) {
						case 'l' : 
							xValues = clipwindow.minX();
							yValues = (int)floor(one.Yvalue() + (m * (xValues - one.Xvalue())) + .05);
							
							R.push_front(CPoint(xValues, yValues,0));
							break;
						case 'r' : 
							xValues = clipwindow.maxX();
							yValues = (int)floor(one.Yvalue() + (m * (xValues - one.Xvalue())) + .05);	
							
							B.push_front(CPoint(xValues, yValues,0));
							break;
						case 'b' : 
							yValues = clipwindow.maxY();
							xValues = (int)floor(one.Xvalue() + ((yValues - one.Yvalue()) / m) + .05);			
							
							T.push_front(CPoint(xValues, yValues,0));
							break;
						case 't' : 
							yValues = clipwindow.minY();
							xValues = (int)floor(one.Xvalue() + ((yValues - one.Yvalue()) / m) + .05);			
							
							result.push_front(CPoint(xValues, yValues,0));
							break;
					}
					break;
				case 4 : 
					// Output Intersection and Two
					m = (double)(two.Yvalue() - one.Yvalue()) / (double)(two.Xvalue() - one.Xvalue());
					switch(clipping_side) {
						case 'l' : 
							xValues = clipwindow.minX();
							yValues = (int)floor(one.Yvalue() + (m * (xValues - one.Xvalue())) + .05);
							R.push_front(CPoint(xValues, yValues,0));
							R.push_front(two);
							break;
						case 'r' : 
							xValues = clipwindow.maxX();
							yValues = (int)floor(one.Yvalue() + (m * (xValues - one.Xvalue())) + .05);			
							B.push_front(CPoint(xValues, yValues,0)); 
							B.push_front(two);
							break;
						case 'b' : 
							yValues = clipwindow.maxY();
							xValues = (int)floor(one.Xvalue() + ((yValues - one.Yvalue()) / m) + .05);			
							T.push_front(CPoint(xValues, yValues,0));
							T.push_front(two); 
							break;
						case 't' : 
							yValues = clipwindow.minY();
							xValues = (int)floor(one.Xvalue() + ((yValues - one.Yvalue()) / m) + .05);			
							result.push_front(CPoint(xValues, yValues,0));
							result.push_front(two); 
							break;
					}
					break;
			}
		}
		// Loop list around
		switch(clipping_side) {
		case 'l' :if(!R.size()==0)R.push_front(R.back()); clipping_side = 'r'; break;
		case 'r' :if(!B.size()==0)B.push_front(B.back()); clipping_side = 'b'; break;
		case 'b' :if(!T.size()==0)T.push_front(T.back()); clipping_side = 't'; break;
		case 't' : clipping_side = 'q'; break;
		}
	}

	// Finish creating new polygon
	while(result.size() != 0) {
		CPoint cur = result.back();
		result.pop_back();
		p.addPolygon(cur);
	}
	return p;
}


void mouseMove (int x, int y ) //function called when the mouse is moving.
{

	if(clippingON){
		//glClear ( GL_COLOR_BUFFER_BIT );
		clearFramebuffer();
		drawit();
		clipwindow.set(1,CPoint(x, clipwindow.showPoints()[0].Yvalue(),0));
		clipwindow.set(2,CPoint(x,y,0));
		clipwindow.set(3,CPoint(clipwindow.showPoints()[0].Xvalue(), y, 0));
		
	       for(int i = 0; i < polygons.size(); i++) {
			CPolygon poly;
//			poly.clip( clipwindow.showPoints()[0].Xvalue(), clipwindow.showPoints()[0].Yvalue(), x, y);		
			poly = get_clipped_polygon(polygons[i]);
			//fillPolygon(polygons[i]);
			fillPolygon(poly);
		}
		
	}
	
	glutDisplayFunc(display);
	glutPostRedisplay ( );
}

void mouseClick(int button, int state, int x, int y){
	
	CPoint vertex;
	if(button == GLUT_LEFT_BUTTON && state == GLUT_DOWN) {
		
		if(!clippingON){
		vertex.make_point(x,y,0);
		points.push_back(vertex);
		}
		else {
			clipwindow.clear();
			clipwindow.addPolygon(CPoint(x,y,0)); //add 4 points for clipping window editing
			clipwindow.addPolygon(CPoint(x,y,0));
			clipwindow.addPolygon(CPoint(x,y,0));
			clipwindow.addPolygon(CPoint(x,y,0));
		}
			
}
	if(button == GLUT_RIGHT_BUTTON && state == GLUT_DOWN){
		
		if(!clippingON){
		vertex.make_point(x,y,0); // add last point
		points.push_back(vertex);

		CPolygon tempPoly; 

		for(int i = 0; i < points.size(); i++){  // printing out points of the polygons being drawn. 

			tempPoly.addPolygon(points[i]);
			cout << "(" << tempPoly.showPoints()[i].Xvalue() << "," << tempPoly.showPoints()[i].Yvalue() << ")" ;
		}
		cout << "\n";

		col.incColor(); // color ++ 

		tempPoly.setColor(col.showColor());

		fillPolygon(tempPoly);
		polygons.push_back(tempPoly);
		points.clear();
		tempPoly.clear();
		}
	}
	glutPostRedisplay ( );
}



int main(int argc, char** argv)
{
	srand(time(NULL));
	glutInit(&argc,argv);
	glutInitDisplayMode(GLUT_SINGLE|GLUT_RGB);
	glutInitWindowSize(ImageW,ImageH);
	glutInitWindowPosition(100,100);
	glutCreateWindow("Kevin McFarlen - Homework 2");
	init();		
	glutDisplayFunc(display);
	glutMouseFunc(mouseClick);
	glutMotionFunc ( mouseMove );
	glutKeyboardFunc (keyboard);  // gather keyboard key presses
	glutPostRedisplay ( );
	glutMainLoop();
	return 0;
}