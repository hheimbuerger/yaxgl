import types
from de.yaxgl.EventDispatcher.EventHandlerMethod import EventHandlerMethod



class EventHandlerManager:
    
    def __init__(self):
        self.eventHandlerMethods = []
        
    def registerEventHandlers(self, eventReceiver):
        for (name, method) in eventReceiver.__class__.__dict__.items():
            if(type(method) == types.FunctionType):
                if(method.__dict__.has_key("eventType") and method.__dict__.has_key("eventID") and method.__dict__.has_key("regexOn")):
                    # DEBUG: missing compatiblity of the method to check here (could also be done directly in decorator, I guess)
                    
#===============================================================================
#                    EventType eventType = ((EventHandler)attribute).eventType;
#                    string eventID = ((EventHandler)attribute).eventID;
#                    bool regexOn = ((EventHandler)attribute).regexOn;
#                    
#                    // now we need to check whether the signature of the annotated method is long enough
#                    // 2 for nomal use 3 with option regexON=true or off=false standart is off
#                    if (method.GetParameters().Length < 2 && method.GetParameters().Length > 3)
#                    {
#                        //TODO: geeignete Exception werfen
#                        throw new Exception("Event handler must have exactly 2 Arguments.");
#                    }
# 
#                    // we also need to check whether the signature of the annotated method is what we expect it to be
#                    Type componentParameter = method.GetParameters()[0].ParameterType;
#                    Type argParameter = method.GetParameters()[1].ParameterType;
#                    if (componentParameter != typeof(Component) || argParameter != typeof(EventArgs))
#                    {
#                        throw new Exception("Event Handler must have 2 Arguments with Type " + typeof(EventType).ToString() + " and " + typeof(string).ToString() + ".");
#                    }
#===============================================================================

                    eventType = method.__dict__["eventType"]
                    eventID = method.__dict__["eventID"]
                    regexOn = method.__dict__["regexOn"]
                    eventHandlerMethod = EventHandlerMethod(eventReceiver, method, eventType, eventID, regexOn)
                    self.eventHandlerMethods.append(eventHandlerMethod)

    def invokeHandlers(self, component, eventArgs):
        for eventHandlerMethod in self.eventHandlerMethods:
            if(eventHandlerMethod.isTypeOf(eventArgs.getType()) and eventHandlerMethod.isMatching(eventArgs.getID())):
                eventHandlerMethod.invokeMethod(component, eventArgs)
