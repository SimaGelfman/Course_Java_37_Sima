package com.gelfman.courseJava.sandbox;

/**
 * Created by Sima.Gelfman on 1/29/2017.
 */
public class Square {

	private double l;


	public Square ( double l ) {
		this.l = l;
	}

	public double area( ){
		return this.l * this.l;
	}

	public void setL ( double l ) {
		this.l = l;
	}

	public double getL () {
		return l;
	}
}
