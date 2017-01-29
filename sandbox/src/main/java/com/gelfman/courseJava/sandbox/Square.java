package com.gelfman.courseJava.sandbox;

/**
 * Created by Sima.Gelfman on 1/29/2017.
 */
public class Square {

	private double l;


	public Square ( double l ) {
		this.l = l;
	}

	public double area( Square s){
		return s.getL () *s.getL ();
	}

	public void setL ( double l ) {
		this.l = l;
	}

	public double getL () {
		return l;
	}
}
