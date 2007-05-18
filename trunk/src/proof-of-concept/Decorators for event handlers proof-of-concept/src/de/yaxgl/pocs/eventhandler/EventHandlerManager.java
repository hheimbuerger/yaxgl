package de.yaxgl.pocs.eventhandler;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import de.yaxgl.pocs.framework.Button;

/*
 * Manages the event handler, allows to add new ones and to invoke them
 */
public class EventHandlerManager {
	private List<EventHandlerMethod> eventReceivers;
	
	/*
	 * We're throwing this exception if, during a call to registerEventHandlers(), we detect a method
	 * that is annotated with @EventHandler but doesn't have the signature we expect it to have 
	 */
	@SuppressWarnings("serial")
	/*inner*/ class EventHandlerWithIncorrectSignature extends RuntimeException {
		private String errorMessage;
		public EventHandlerWithIncorrectSignature(String errorMessage) {
			this.errorMessage = errorMessage;
		}
		public String toString() {
			return(errorMessage);
		}
	}
	
	/*
	 * Constructor
	 */
	public EventHandlerManager() {
		eventReceivers = new ArrayList<EventHandlerMethod>();
	}
	
	/*
	 * Register all event handlers for the given object, check if the event handlers have the
	 * correct signatures
	 * TODO: should we check, if the event handler is public!? Technically it doesn't matter,
	 *       we can call private event handlers as well
	 */
	@SuppressWarnings("unchecked")
	public void registerEventHandlers(Object eventReceiver) {
		
		// iterate over all methods of the given object
		for(Method method: eventReceiver.getClass().getMethods()) {
			
			// determine if they have the @EventHandler annotation, otherwise we just ignore them
			EventHandler annotation = method.getAnnotation(EventHandler.class);
			if(annotation != null) {
				
				// now we need to check whether the signature of the annotated method is long enough
				if(method.getParameterTypes().length != 2) {
					throw new EventHandlerWithIncorrectSignature("Event handler must have exactly two parameters of types EventHandler and String, but event handler with " + String.valueOf(method.getParameterTypes().length) + " Parameter(s) was tried to register.");
				}
				
				// we also need to check whether the signature of the annotated method is what we expect it to be
				Class typeParameter = method.getParameterTypes()[0];
				Class idParameter = method.getParameterTypes()[1];
				if(typeParameter != EventType.class || idParameter != String.class) {
					throw new EventHandlerWithIncorrectSignature("Event handler must have exactly two parameters of types EventHandler and String, but event handler with parameters " + typeParameter.getName() + " and " + idParameter.getName() + " was tried to register.");
				}
						
				// we're cool, the signature is fine, now we can register the event handler
				eventReceivers.add(new EventHandlerMethod(eventReceiver, method, annotation.type(), annotation.IDFilterRE()));
				System.out.println("Registered event handler for type '" + annotation.type().toString() + "' for the ID filter '" + annotation.IDFilterRE() + "'.");
			}
		}
	}

	/*
	 * Find all event handlers to the given event and invoke them
	 */
	public void invokeHandlers(Button button, EventType type) {
		for(EventHandlerMethod eventReceiverMethod: eventReceivers) {
			if(eventReceiverMethod.isOfType(type)
				&& eventReceiverMethod.isMatchingIDFilter(button.getId())) {
				eventReceiverMethod.invokeMethod(type, button.getId());
			}
		}
	}
}