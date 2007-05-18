package de.yaxgl.pocs.eventhandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Represents a registered object/method combination for a specific EventType (may be anyEvent) and
 * a specific ID-Filter (may be .*)
 */
public class EventHandlerMethod {
	private Object object;
	private Method method;
	private EventType type;
	private Pattern idFilterRE;
	
	/*
	 * Instantiates the event handler and prepares the RE
	 */
	public EventHandlerMethod(Object eventReceiver, Method method, EventType type, String idFilterRE) {
		this.object = eventReceiver;
		this.method = method;
		this.type = type;
		Pattern p = Pattern.compile("^"+idFilterRE+"$");
		this.idFilterRE = p;
	}
	
	/*
	 * Checks if the given ID matches the filter of this event handler
	 */
	public Boolean isMatchingIDFilter(String ID) {
		Matcher m = idFilterRE.matcher(ID);
		return(m.matches());
	}
	
	/*
	 * Checks if the given type matches the type filter of this event handler
	 */
	public Boolean isOfType(EventType type) {
		return(this.type == EventType.anyEvent || this.type == type);
	}
	
	/*
	 * Invokes the event handler
	 * TODO: Throw specific exceptions
	 */
	public void invokeMethod(EventType type, String ID) {
		try {
			System.out.println("Invoking method '" + method.getName() + "' of '" + object.getClass().getName() + "' instance with type '" + type.toString() + "' and ID '" + ID + "'.");
			method.invoke(object, type, ID);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
