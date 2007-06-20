import re
from de.yaxgl.EventDispatcher.Decorator.EventType import EventType



class EventHandlerMethod:
    
    def __init__(self, eventReceiver, method, eventType, eventID, regexOn):
        self.eventReceiver = eventReceiver;
        self.method = method;
        self.eventType = eventType;
        self.eventID = eventID;
        self.regexOn = regexOn;
        
    def isMatching(self, eventID):
        if(self.regexOn):
            return(re.match("^%s$" % (self.eventID), eventID) != None)
        else:
            return(self.eventID == eventID)

    def isTypeOf(self, eventType):
        return(self.eventType == EventType.Any or self.eventType == eventType)

    def invokeMethod(self, component, eventArgs):
        self.method(self.eventReceiver, component, eventArgs)
