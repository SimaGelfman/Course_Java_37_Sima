package com.gelfman.courseJava.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**}
 * Created by Sima.Gelfman on 2/1/2017.
 */
public class PointTests {

	@Test	public void destanceTests() {

		Point p1 = new Point ( 2, 0 );
		Point p2 = new Point ( 0, 0 );
		Assert.assertEquals ( p1.distance ( p2 ), 2.0 );
	}
	@Test
	public void destanceNegativTests() {

		Point p1 = new Point ( 2, 0 );
		Point p2 = new Point ( 0, 0 );
		Assert.assertFalse ( p1.distance ( p2 ) == 2.1 );
	}



}



