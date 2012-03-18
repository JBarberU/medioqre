/**
*	TestPosition.java
*
*	@author Johan
*/

package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPosition {

	private Position position;
	
	@Before
	public void setUp() throws Exception {
		this.position = new Position(1,3);
	}
	
	@Test
	public void testPosition() {
		assertEquals(this.position.getX(), 1);
		assertEquals(this.position.getY(), 3);
	}
	
	@Test
	public void testEquals(){
		Position other = new Position(1,3);
		Position other2 = position;
		Position other3 = new Position(other);
		
		assertTrue(this.position.equals(other));
		assertTrue(this.position.equals(other3));
		assertTrue(!this.position.equals(null));
		assertTrue(this.position == other2);
	}
	

}
