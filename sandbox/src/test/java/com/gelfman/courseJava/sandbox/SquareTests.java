package com.gelfman.courseJava.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Sima.Gelfman on 1/31/2017.
 */
public class SquareTests {

	@Test
	public void testArea(){

		Square s = new Square ( 6 );
		Assert.assertEquals (s.area (), 36.0  );

	}

}
