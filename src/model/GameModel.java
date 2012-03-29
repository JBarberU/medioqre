package model;

import model.character.*;
import model.character.Character;
import constants.Direction;

/**
 * Model for a game.
 * 
 * @author Johan
 *
 */
public class GameModel implements IGameModel {
	
	private Character player;
	
	public GameModel() {
		this.player = new Player();
	}
	
	/**
	 * Updates the game model.
	 * @param dt The time since the last update.
	 */
	public void update(double dt) {

		this.player.move(dt);
	}
	
	/**
	 * Updates the player's direction.
	 * 
	 * @param dir The direction
	 * @see Direction
	 */
	public void updateDirection(Direction dir) {
		this.player.setDirection(dir);
	}
	
	public void stopPlayer(){
		this.player.stop();
	}
	
	
}
