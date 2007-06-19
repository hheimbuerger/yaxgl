# decorator
def EventHandler(eventType, eventID, regexOn=False):
    """
    /* this is to anotate like
     * [de.yaxgl.EventHandler(eventType=EventType.Click,eventID="button1")]
     * that so Regulare Expressions are off
     * or like this
     * [de.yaxgl.EventHandler(eventType = EventType.GotFocus, eventID = ".*",regexOn=true)]
     * so regulare expressions are on
     * **/
    """
    def decorate(decorated_function):
        decorated_function.eventType = eventType
        decorated_function.eventID = eventID
        decorated_function.regexOn = regexOn
        return(decorated_function)
    return decorate





# UNIT-TEST
if __name__ == "__main__":
    import types
    
    class Test:
        @EventHandler(eventType = "click", eventID = "myID")
        def handleThatEvent(self):
            print "handled!"
    
        def notAHandler(self):
            print "wtf? why did you call me?"

    test = Test()
    print test.__class__.__dict__
    print test.__class__.__dict__["handleThatEvent"]
    print str(type(test.__class__.__dict__["handleThatEvent"]))
    print test.__class__.__dict__["handleThatEvent"].__dict__
    print test.__class__.__dict__["handleThatEvent"].__dict__.has_key("eventType")
    
    for (name, method) in test.__class__.__dict__.items():
        if(type(method) == types.FunctionType):
            if(method.__dict__.has_key("eventType") and method.__dict__.has_key("eventID") and method.__dict__.has_key("regexOn")):
                method(test)
