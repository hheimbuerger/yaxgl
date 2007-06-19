package de.yaxgl.EventDispatcher;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

import de.yaxgl.Base.*;
import de.yaxgl.EventDispatcher.Attribute.*;

public class EventHandlerManager {
	List<EventHandlerMethod> eventHandlerMethods = null;
    
    public EventHandlerManager()
    {
        eventHandlerMethods = new ArrayList<EventHandlerMethod>();
    }
    
    public void registerEventHandlers(Object eventReciever) throws Exception
    {    
        for(Method method : eventReciever.getClass().getMethods())
        {
	    	Annotation[] annotations = method.getAnnotations();   
            if (annotations.length > 0)
            {
                for(Annotation annotation : annotations)
                {
                    if(annotation.getClass()==EventHandler.class)
                    {
                    	EventType eventType = ((EventHandler)annotation).eventType();
                    	String eventID = ((EventHandler)annotation).eventID();
                    	boolean regexOn = ((EventHandler)annotation).regexOn();
                    	
                    	// now we need to check whether the signature of the annotated method is long enough
                    	// 2 for nomal use 3 with option regexON=true or off=false standart is off
                    	if ((method.getParameterTypes().length < 2) && (method.getParameterTypes().length > 3))
                    	{
                    		//TODO: geeignete Exception werfen
                    		throw new Exception("Event handler must have exactly 2 Arguments.");
                    	}

                    // we also need to check whether the signature of the annotated method is what we expect it to be
                    Class componentParameter = method.getParameterTypes()[0];
                    Class argParameter = method.getParameterTypes()[1];
                    if (componentParameter != Component.class || argParameter != EventArgs.class)
                    {
                        throw new Exception("Event Handler must have 2 Arguments with Type " + EventType.class.toString() + " and " + String.class.toString() + ".");
                    }

                    EventHandlerMethod eventHandlerMethod = new EventHandlerMethod(eventReciever, method, eventType, eventID,regexOn);
                    eventHandlerMethods.add(eventHandlerMethod);
                    }
                 }
            }
        }
    }
    
    
    public void invokeHandlers(Component component, EventArgs eventArgs) {
	    for(EventHandlerMethod eventHandlerMethod : eventHandlerMethods) {
            if(eventHandlerMethod.isTypeOf(eventArgs.getType()) && eventHandlerMethod.isMatching(eventArgs.getID())) {
			    eventHandlerMethod.invokeMethod(component,eventArgs);
		    }
	}
}



}
