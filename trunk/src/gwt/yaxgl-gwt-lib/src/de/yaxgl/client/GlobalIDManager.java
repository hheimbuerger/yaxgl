package de.yaxgl.client;

import java.util.HashMap;
import java.util.Map;

import de.yaxgl.client.Base.Component;

public class GlobalIDManager {

	private static Map components = new HashMap();
	
	public static void addComponent(Component component) {
		components.put(component.getID(), component);
	}
	
	public static void removeComponent(Component component) {
		components.remove(component.getID());
	}
	
	public static Component getComponentById(String ID) {
		if (components.containsKey(ID))
			return (Component) components.get(ID);
		else
			return null;
	}
	
}
