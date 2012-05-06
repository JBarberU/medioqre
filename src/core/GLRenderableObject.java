package core;

import javax.media.opengl.GLAutoDrawable;

public interface GLRenderableObject {

	/**
	 * Render the GLRenderableObject.
	 * @param object The rectangle representing where the object should be drawn.
	 * @param target The rectangle representing the surface to draw to. 
	 * @param canvas The canvas to draw to.
	 */
	public void render(Rectangle object, Rectangle target, GLAutoDrawable canvas);
	
	/**
	 * Updates the state of the GLRenderableObject.
	 * @param dt The time passed since last frame.
	 */
	public void update(double dt);
	
	/**
	 * Get the bounds of the GLRenderableObject.
	 * @return The Rectangle representing the bounds.
	 */
	public Rectangle getBounds();
}