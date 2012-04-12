package model;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import tools.Logger;

import constants.Direction;

/**
 * The collidable object super class.
 * 
 * <p>Consists of a collision box, a size, and offsets. The size is the actual size of the object - picture it like
 * the area rendered on screen, including the sprite. The collision box is the rectangular area that actually determines
 * if the object hits another CollidableObject's collision box. You may not want the collision box to be positioned in
 * the upper left corner of the object, so there are two properties - the vertical and horizontal offset - to offset the
 * collision box from the corner. Thus, the object may have a collision box <u>smaller</u> than the object's size, and
 * may not cover the whole object's area.
 * 
 * @author Johan
 *
 */
public abstract class CollidableObject {
	
	private Rectangle collisionBox;
	private Dimension size;
	private int xoffset;
	private int yoffset;

	
	/**
	 * A collidable object with a collision box, size, and offsets for the 
	 * collision box.
	 * 
	 * The object will get its position from <code>collBox's</code> position.
	 * 
	 * @param collBox The collision box
	 * @param size The size of the model
	 * @param xoffset The X offset of the collision box
	 * @param yoffset The Y offset of the collision box
	 */
	public CollidableObject(Rectangle collBox, Dimension size, int xoffset, int yoffset){
		this.collisionBox = collBox;
		this.size = size;
		this.xoffset = xoffset;
		this.yoffset = yoffset;
	}
	
	
	/**
	 * Get the size of this object.
	 * 
	 * @return The size
	 */
	public Dimension getSize() {
		return this.size;
	}
	
	
	/**
	 * Get the position of the object in the game world.
	 * 
	 * @return The position
	 */
	public Point getPosition(){
		
		int x = this.collisionBox.x - xoffset;
		int y = this.collisionBox.y - yoffset;
		
		return new Point(x, y);
	}
	
	/**
	 * Set the position of the object in the game world.
	 * 
	 * @param pos The position
	 */
	public void setPosition(Point pos){

		this.collisionBox.x = pos.x + this.xoffset;
		this.collisionBox.y = pos.y + this.yoffset;
	}
	
	/**
	 * Set the position of the object in the game world.
	 * 
	 * @param x The X coordinate
	 * @param y The Y coordinate
	 */
	public void setPosition(int x, int y) {
		
		this.collisionBox.x = x + this.xoffset;
		this.collisionBox.y = y + this.yoffset;		
	}
	
	/**
	 * Get the horizontal offset.
	 * 
	 * The offset is how the collision box is positioned
	 * relative to the upper left corner.
	 * 
	 * @return The X offset
	 */
	public int getOffsetX() {
		return this.xoffset;
	}
	
	/**
	 * Get the vertical offset.
	 * 
	 * The offset is how the collision box is positioned
	 * relative to the upper left corner.
	 * 
	 * @return The Y offset
	 */
	public int getOffsetY() {
		return this.yoffset;
	}
	
	
	/**
	 * Get the collision box of the object.
	 * 
	 * @return The collision box
	 */
	public Rectangle getCollisionBox(){
		return this.collisionBox;
	}
	
	/**
	 * Check whether this object is colliding with another CollidableObject.
	 * 
	 * The objects are colliding if their collision boxes intersect.
	 * 
	 * @param obj The specified CollidableObject
	 * @return True if the objects are colliding, false otherwise
	 */
	public boolean isColliding(CollidableObject obj){
		
		return this.collisionBox.intersects(obj.getCollisionBox());
	}
	
	public Direction getCollisionDirection(CollidableObject obj) {
		
		int code = this.collisionBox.outcode(obj.getPosition());		
        Direction d = Direction.ORIGIN;
        
        if((code & Rectangle.OUT_TOP) == Rectangle.OUT_TOP)
            d = Direction.NORTH;
        if((code & Rectangle.OUT_RIGHT) == Rectangle.OUT_RIGHT)
            d = Direction.EAST;
        if((code & Rectangle.OUT_LEFT) == Rectangle.OUT_LEFT)
            d = Direction.WEST;
        if((code & Rectangle.OUT_BOTTOM) == Rectangle.OUT_BOTTOM)
            d = Direction.SOUTH;
        
		
		return d;
	}
}
