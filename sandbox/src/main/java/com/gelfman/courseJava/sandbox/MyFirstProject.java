package com.gelfman.courseJava.sandbox;

public class MyFirstProject {
	public static void main ( String args[] ) {

		print ( "Hello, friends" );

		double l = 5.5;
		print("Square area with side " + l  + " is "  + area(l));

		double a = 5.5;
		double b = 4.5;
		print("Rectangle area with side " + l  + " is "  + area(a,b));

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