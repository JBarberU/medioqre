/**
*	TestPortal.java
*
*	@author Johan
*/

package model;

import static org.junit.Assert.*;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import model.weapon.Portal;
import model.weapon.PortalGun.Mode;

import org.junit.Before;
import org.junit.Test;

public class TestPortal {

	private Portal portal;
	
	@Before
	public void setUp() throws Exception {
		this.portal = new Portal(Mode.BLUE, new Rectangle(20, 20), new Dimension(20, 20), 0, 0);
		this.portal.setPosition(20, 20);
	}

	@Test
	public void testPosition() {
		assertEquals(new Point(20,20), this.portal.getPosition());
	}
	
	@Test
	public void testCenter() {
		this.portal.center();
		
		assertEquals(new Point(10, 10), this.portal.getPosition());
	}
	
	@Test
	public void testPositionFromCenter() {
		this.portal.setPositionFromCenter(new Point(30, 30));
		assertEquals(new Point(20, 20), this.portal.getPosition());
	}
}
