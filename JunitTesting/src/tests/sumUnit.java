package tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class sumUnit {

	@Test
	public void test() {
		UnitTesting obj1 = new UnitTesting();
		int output_f = obj1.sum(4,5);
		
		//Test the output
		assertEquals(9,output_f);
	}

}
