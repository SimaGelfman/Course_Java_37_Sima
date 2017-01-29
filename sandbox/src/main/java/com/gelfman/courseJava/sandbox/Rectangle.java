package com.gelfman.courseJava.sandbox;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by Sima.Gelfman on 1/29/2017.
 */
public class Rectangle {
	private double a;
	private double b;

	public Rectangle ( double a, double b ) {
		this.a = a;
		this.b = b;
	}

	public void setA ( double a ) {
		this.a = a;
	}

	public void setB ( double b ) {
		this.b = b;
	}

	public double getA () {
		return a;
	}

	public double area(Rectangle r){
		return r.getA () * r.getB ();
	}

	public double getB () {
		return b;
	}
}
