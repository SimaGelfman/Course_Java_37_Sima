package com.gelfman.courseJava.sandbox;

public class MyFirstProject {
	public static void main ( String args[] ) {

		print ( "Hello, friends" );

		Square s = new Square (3.5);
		s.setL ( 5.5 );
		print("Square area with side " + s.getL ()  + " is "  + s.area( ));

		Rectangle r =  new Rectangle (5.5, 6.5);
		print("Rectangle area with sides a = " + r.getA () + " and b = "+ r.getB ()  + " is "  + r.area( ));

		Point p1 = new Point ( 0, 2 );
		Point p2 = new Point ( 1, 1 );

		print ( "Distance between p1: (" + p1.getX () + ", " + p1.getY ()
									+ ") and p2: (" + p2.getX () + " ," + p2.getY () + ") is " + p1.distance ( p2 ) );

		print ( "Distance between p1: (" + p1.getX () + ", " + p1.getY ()
						+ ") and p2: (" + p2.getX () + " ," + p2.getY () + ") is " + distance (p1,  p2 ) );



	}

	public static void print(String something){
		System.out.println ( something );
	}

	public static double area(double l){
		return l * l;
	}

	public static double area(double a, double b){
		return a * b;
	}

	public static double distance(Point p1, Point p2){
		return Math.sqrt((p2.getX () - p1.getX ()) * (p2.getX () - p1.getX ()) + (p2.getY () - p1.getY ()) * (p2.getY () - p1.getY ()));
	}
}