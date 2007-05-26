using System;
using System.Collections.Generic;
using System.Text;

//TODO: Liste und regex
namespace de.yaxgl
{
    [System.AttributeUsage(System.AttributeTargets.Method)]
    public class EventHandler : System.Attribute
    {
        public string eventID;
        public EventType eventType;

        public EventHandler(EventType eventType, string eventID)
        {
            this.eventID = eventID;
            this.eventType = eventType;
        }

    
    }
         
}
