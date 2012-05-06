/**
*	Projectile.java
*
*	@author Johan
*/

package model.weapon;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import constants.Direction;

import model.Entity;
import model.character.AbstractCharacter;


public class Projectile extends Entity {
	
	private int damage;
	private Range range;
	private AbstractWeapon owner;
	
	private double distanceTravelled;
	
	/**
	 * A enum for ranges.
	 * 
	 * @author Johan
	 *
	 */
	public enum Range {
		SHORT_RANGE(40), MEDIUM_RANGE(200), FAR_RANGE(1500);
		
		private final double distance;
		
		/**
		 * Create new range.
		 * 
		 * @param distance The distance
		 */
		Range(double distance) {
			this.distance = distance;
		}
		
		/**
		 * Get the distance.
		 * @return The distance
		 */
		public double getDistance() {
			return this.distance;
		}
	}
	
	/**
	 * Create a new projectile.
	 * 
	 * @param owner The projectile's owner (a weapon)
	 * @param width The width
	 * @param height The height
	 * @param damage The damage this should do
	 * @param range The range
	 * @param movementSpeed The speed
	 */
	public Projectile(AbstractWeapon owner, int width, int height, int damage, Range range, int movementSpeed) {
		super(new Rectangle(width, height), new Dimension(width, height), 0, 0, movementSpeed);
		
		this.owner = owner;
		this.damage = damage;
		this.range = range;
		this.distanceTravelled = 0;
		
		AbstractCharacter p = this.owner.getOwner();
		
		int x = p.getPosition().x-10;
		int y = p.getPosition().y+20;
		
		if(p.getDirection() == Direction.SOUTH) {
			y = (int) p.getCollisionBox().getMaxY();
		}
		
		setPosition(x, y);
		setDirection(this.owner.getOwner().getDirection());	
	}
	
	public Projectile(Projectile p) {
		this(p.owner, p.getCollisionBox().width, p.getCollisionBox().height, p.damage, p.range, p.getMovementSpeed());
	}
	
	/**
	 * Get the damage
	 * 
	 * @return The damage
	 */
	public int getDamage() {
		return this.damage;
	}
	
	/**
	 * Get the range
	 * 
	 * @return The range
	 */
	public Range getRange() {
		return this.range;
	}
	
	/**
	 * Get the distance travelled while moving from the starting position.
	 * 
	 * @return The distance travelled
	 */
	public double getDistanceTravelled() {
		return this.distanceTravelled;
	}
	
	/**
	 * Refresh the distance travelled.
	 */
	public void updateDistanceTravelled(double dt) {
		int x = (int) (this.getDirection().getXRatio() * (double) this.getMovementSpeed() * dt);		
		int y = (int) (this.getDirection().getYRatio() * (double) this.getMovementSpeed() * dt);
		this.distanceTravelled += Math.abs(x) + Math.abs(y);
	}
	
	/**
	 * Get this projectile's owner.
	 * 
	 * @return The owner
	 */
	public AbstractWeapon getOwner() {
		return this.owner;
	}
	
	@Override
	public String toString() {
		return super.toString() + " [owner/type:"+this.owner+"] [range: "+this.range +"] [damage: "+this.damage+"]";
	}
	
	@Override
	public void move(double dt) {
		super.move(dt);

		this.updateDistanceTravelled(dt);
	}
	
}


