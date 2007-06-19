package de.yaxgl.EventDispatcher;

import de.yaxgl.EventDispatcher.Attribute.*;


public class EventArgs {
	 private String eventID;
     private EventType eventType;

     public EventArgs(EventType eventType, String eventID)
     {
         this.eventType = eventType;
         this.eventID = eventID;
     }
     
     public String getID()
     {
         return this.eventID;
     }

     public EventType getType()
     {
         return this.eventType;
     }

     public String toString()
     {
         return super.toString() + "(eventType=" + this.eventType + ",eventID="+this.eventID+")";
     }
}
