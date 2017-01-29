package com.gelfman.courseJava.sandbox;

public class MyFirstProject {
	public static void main ( String args[] ) {

		print ( "Hello, friends" );

		Square s = new Square (3.5);
		s.setL ( 5.5 );
		print("Square area with side " + s.getL ()  + " is "  + s.area(s));

		Rectangle r =  new Rectangle (5.5, 6.5);
		print("Rectangle area with sides a = " + r.getA () + " and b = "+ r.getB ()  + " is "  + r.area(r));

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
}