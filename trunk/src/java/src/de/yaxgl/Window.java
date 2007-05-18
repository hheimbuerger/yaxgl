/**
 * 
 */
package de.yaxgl;

import java.awt.Rectangle;

/**
 * @author Cort
 *
 */
public class Window extends Container {
	
	public Window(String filename) {
		parseXML(filename);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPosition(int x, int y) {
		// TODO Auto-generated method stub
		
	}
	
	public void show() {
		
	}

	// Parameter benoetigt?: auf welches Fenster modal oeffnen
	
	public void showModal() {
		
	}
	
	public void hide() {
		
	}
}
