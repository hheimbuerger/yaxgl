using System;
using System.Collections.Generic;
using System.Text;
using System.Reflection;


namespace de.yaxgl
{
    public class EventHandlerManager
    {
        IList<EventHandlerMethod> eventHandlerMethods = null;
        
        public EventHandlerManager()
        {
            eventHandlerMethods = new List<EventHandlerMethod>();
        }
        

        public void registerEventHandlers(Object eventReciever)
        {
            MethodInfo[] methods = eventReciever.GetType().GetMethods();
            foreach (MethodInfo method in methods)
            {
                
                Object[] attributes = method.GetCustomAttributes(typeof(EventHandler), false);
                if (attributes.Length > 0)
                {
                    foreach (Object attribute in attributes)
                    {
                        EventType eventType = ((EventHandler)attribute).eventType;
                        string eventID = ((EventHandler)attribute).eventID;
                        bool regexOn = ((EventHandler)attribute).regexOn;
                        
                        // now we need to check whether the signature of the annotated method is long enough
                        // 2 for nomal use 3 with option regexON=true or off=false standart is off
                        if (method.GetParameters().Length < 2 && method.GetParameters().Length > 3)
                        {
                            //TODO: geeignete Exception werfen
                            throw new Exception("Event handler must have exactly 2 Arguments.");
                        }

                        // we also need to check whether the signature of the annotated method is what we expect it to be
                        Type componentParameter = method.GetParameters()[0].ParameterType;
                        Type argParameter = method.GetParameters()[1].ParameterType;
                        if (componentParameter != typeof(Component) || argParameter != typeof(EventArgs))
                        {
                            throw new Exception("Event Handler must have 2 Arguments with Type " + typeof(EventType).ToString() + " and " + typeof(string).ToString() + ".");
                        }

                        EventHandlerMethod eventHandlerMethod = new EventHandlerMethod(eventReciever, method, eventType, eventID,regexOn);
                        eventHandlerMethods.Add(eventHandlerMethod);
                    }
                }
            }
        }
        
        public void invokeHandlers(Component component, EventArgs eventArgs) {
		    foreach(EventHandlerMethod eventHandlerMethod in eventHandlerMethods) {
                if(eventHandlerMethod.isTypeOf(eventArgs.getType()) && eventHandlerMethod.isMatching(eventArgs.getID())) {
				    eventHandlerMethod.invokeMethod(component,eventArgs);
			    }
		}
	}

    } 
} // END NAMESPACE
