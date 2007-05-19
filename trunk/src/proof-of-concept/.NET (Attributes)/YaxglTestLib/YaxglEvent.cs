using System;
using System.Collections.Generic;
using System.Text;


namespace YaxglTestLib
{
    [System.AttributeUsage(System.AttributeTargets.Method)]
    public class YaxglEvent : System.Attribute
    {
        public string eventID;
        public EventType eventType;

        public YaxglEvent(EventType eventType, string eventID)
        {
            this.eventID = eventID;
            this.eventType = eventType;
        }
    
    }
         
}
