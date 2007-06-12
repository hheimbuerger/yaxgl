using System;
using System.Collections.Generic;
using System.Text;
using System.Reflection;
using System.Text.RegularExpressions;
namespace de.yaxgl

{

    public class EventHandlerMethod
    {
        private Object eventReciever;
        private MethodInfo methodInfo;
        private EventType eventType;
        private string eventID;
        private bool regexOn;

        public EventHandlerMethod(Object eventReciever, MethodInfo methodInfo, EventType eventType,string eventID,bool regexOn)
        {
            this.eventReciever = eventReciever;
            this.methodInfo = methodInfo;
            this.eventType = eventType;
            this.eventID = eventID;
            this.regexOn = regexOn;
                //new Regex("^"+eventID+"$");
        }

        
        public bool isMatching(string eventID)
        {
            bool retVal;
            if (regexOn)
            {
                Regex eventIDRegex = new Regex("^" + this.eventID + "$");
                Match m = eventIDRegex.Match(eventID);
                retVal = m.Success;
            }
            else 
            {
                retVal=this.eventID.Equals(eventID);   
            }
            return retVal;
        }

        public bool isTypeOf(EventType eventType)
        {
            if (this.eventType == eventType)
                return true;
            else
                return false;
        
        }

        public void invokeMethod(Component component, EventArgs eventArgs)
        {
            Object[] arg ={ (Object)component, eventArgs };
            methodInfo.Invoke(eventReciever, arg);

        }
    }
}// END NAMESPACE