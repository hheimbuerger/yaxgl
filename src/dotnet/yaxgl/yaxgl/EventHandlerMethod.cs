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
        private Regex eventID;

        public EventHandlerMethod(Object eventReciever, MethodInfo methodInfo, EventType eventType,string eventID)
        {
            this.eventReciever = eventReciever;
            this.methodInfo = methodInfo;
            this.eventType = eventType;
            this.eventID = new Regex("^"+eventID+"$");
        }


        public bool isMatching(string eventID)
        {
            Match m = this.eventID.Match(eventID);
            return m.Success;
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