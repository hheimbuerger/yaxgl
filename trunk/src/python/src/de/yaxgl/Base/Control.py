from de.yaxgl.Base.Component import Component
from de.yaxgl.EventDispatcher.EventArgs import EventArgs
from de.yaxgl.EventDispatcher.Decorator.EventType import EventType



# abstract
class Control(Component):
    
    def clickEvent(self, sender, e):
        self.owner.notifyEvent(self, EventArgs(EventType.Click, self.ID))
        
    def gotFocusEvent(self, sender, e):
        self.owner.notifyEvent(self, EventArgs(EventType.GotFocus, self.ID))
        
    def lostFocusEvent(self, sender, e):
        self.owner.notifyEvent(self, EventArgs(EventType.LostFocus, self.ID))
        
    def selectionChangedEvent(self, sender, e):
        self.owner.notifyEvent(self, EventArgs(EventType.SelectionChanged, self.ID))
        
    def setEnabled(self, enabled):
        self.control.Enabled = enabled
        
    def isEnabled(self):
        return(self.control.Enabled) 
