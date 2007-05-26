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
                    EventType eventType=((EventHandler)attributes[0]).eventType;
                    string eventID=((EventHandler)attributes[0]).eventID;
                    
                    // now we need to check whether the signature of the annotated method is long enough
				    if(method.GetParameters().Length != 2) {
					    //TODO: geeignete Exception werfen
                        throw new Exception("Event handler must have exactly 2 Arguments.");
				    }
    				
				    // we also need to check whether the signature of the annotated method is what we expect it to be
                    Type componentParameter = method.GetParameters()[0].ParameterType;
				    Type argParameter = method.GetParameters()[1].ParameterType;
				    if((componentParameter!=typeof(Component) || componentParameter != typeof(Component)) || argParameter != typeof(EventArgs))
                    {
                        throw new Exception("Event Handler must have 2 Arguments with Type " + typeof(EventType).ToString() + " and " + typeof(string).ToString() + ".");
                    }
                    
                    EventHandlerMethod eventHandlerMethod = new EventHandlerMethod(eventReciever, method, new EventArgs(eventType,eventID));
                    eventHandlerMethods.Add(eventHandlerMethod);
                }
            }
        }
        
        public void invokeHandlers(Component component, EventArgs eventArgs) {
		    foreach(EventHandlerMethod eventHandlerMethod in eventHandlerMethods) {
                if(eventHandlerMethod.isMatching(eventArgs)) {
				    eventHandlerMethod.invokeMethod(component,eventArgs);
			    }
		}
	}

    } 
} // END NAMESPACE
