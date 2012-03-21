package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import model.character.*;
import model.character.Character;
import constants.Direction;
import controller.IObservable;

/**
 * Model for a game.
 * 
 * @author Johan
 *
 */
public class GameModel implements IObservable {
	
	private Character player;
	private boolean isPlayerMoving;
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	
	public GameModel() {
		this.player = new Player(10);
		this.isPlayerMoving = false;
	}
	
	public void pressedState(boolean state) {
		boolean old = this.isPlayerMoving;
		this.isPlayerMoving = state;
		this.pcs.firePropertyChange("isPlayerMoving", old, this.isPlayerMoving);
	}
	
	public void updateDirection(Direction dir) {
		Direction oldDir = this.player.getDirection();
		this.player.setDirection(dir);
		this.pcs.firePropertyChange("playerDidChangeDirection", oldDir, dir);
	}
	
	
	@Override
	public void addObserver(PropertyChangeListener listener) {
		this.pcs.addPropertyChangeListener(listener);
	}

	@Override
	public void removeObservers() {
		for(PropertyChangeListener l : this.pcs.getPropertyChangeListeners()) {
			this.pcs.removePropertyChangeListener(l);
		}
	}

	@Override
	public void removeObserver(PropertyChangeListener listener) {
		this.pcs.removePropertyChangeListener(listener);
	}
	
}
