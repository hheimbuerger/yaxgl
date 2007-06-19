import re



class EventHandlerMethod:
    
    def __init__(self, eventReceiver, method, eventType, eventID, regexOn):
        self.eventReceiver = eventReceiver;
        self.method = method;
        self.eventType = eventType;
        self.eventID = eventID;
        self.regexOn = regexOn;
        
    def isMatching(self, eventID):
        if(self.regexOn):
            reResult = re.match("^%s$" % (this.eventID), eventID)
            return(reResult.matches())
        else:
            return(self.eventID == eventID)

    def isTypeOf(self, eventType):
        return(self.eventType == eventType)

    def invokeMethod(self, component, eventArgs):
        self.method(self.eventReceiver, component, eventArgs)
