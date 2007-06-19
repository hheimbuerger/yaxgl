class EventArgs:
    
    def __init__(self, eventType, eventID):
        self.eventType = eventType
        self.eventID = eventID

    def __eq__(self, other):
        return (self.eventID == other.eventID and self.eventType == other.eventType)

    def __ne__(self, other):
        return (self.eventID != other.eventID or self.eventType != other.eventType)
        
    def getID(self):
        return(self.eventID)
    
    def getType(self):
        return(self.eventType)

    def __str__(self):
        return "(eventType=%s, eventID=%s" % (self.eventType, self.eventID)
