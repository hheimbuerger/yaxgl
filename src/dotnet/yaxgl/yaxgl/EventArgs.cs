using System;
using System.Collections.Generic;
using System.Text;

namespace de.yaxgl
{
    public class EventArgs
    {
        private string eventID;
        private EventType eventType;

        public EventArgs(EventType eventType, string eventID)
        {
            this.eventType = eventType;
            this.eventID = eventID;
        }

        public static bool operator ==(EventArgs a, EventArgs b)
        {
             if (a.eventID.Equals(b.eventID) && a.eventType == b.eventType) return true;
                else return false;
        }

        public static bool operator !=(EventArgs a, EventArgs b)
        {
            if (!a.eventID.Equals(b.eventID) || a.eventType != b.eventType) return true;
            else return false;
        }
        
        
        public string getID()
        {
            return this.eventID;
        }

        public EventType getType()
        {
            return this.eventType;
        }

        public override bool Equals(object obj)
        {
            if (this == (EventArgs)obj) return true;
            else return false;
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }
        
        public override string ToString()
        {
            return base.ToString() + "(eventType=" + this.eventType + ",eventID="+this.eventID+")";
        }

    }
}
