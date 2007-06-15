/**
 * 
 */
package de.yaxgl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cort
 *
 */
public abstract class Container extends Component implements Serializable {
	private List<Containable> controls = new ArrayList<Containable>();
	
	private Control getControlById(String ID)
	{
		return null;
	}
	
	protected void parseXML(String filename) {
		// fuelle controls-Liste mit Daten aus XML-Datei
	}
}
