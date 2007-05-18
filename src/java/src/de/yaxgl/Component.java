/**
 * 
 */
package de.yaxgl;

import java.awt.Rectangle;

/**
 * @author Cort
 *
 */
public abstract class Component {
	private String ID;
	abstract public Rectangle getBounds();
	abstract public void setPosition(int x, int y);
}
