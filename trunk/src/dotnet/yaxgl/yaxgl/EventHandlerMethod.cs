using System;
using System.Collections.Generic;
using System.Text;
using System.Reflection;

namespace de.yaxgl
{

    public class EventHandlerMethod
    {
        private Object eventReciever;
        private MethodInfo methodInfo;
        private EventArgs eventArgs;

        public EventHandlerMethod(Object eventReciever, MethodInfo methodInfo, EventArgs eventArgs)
        {
            this.eventReciever = eventReciever;
            this.methodInfo = methodInfo;
            this.eventArgs = eventArgs;
        }


        public bool isMatching(EventArgs eventArgs)
        {
            if (eventArgs == this.eventArgs) return true;
            else return false;
        }

        public void invokeMethod(Component component, EventArgs eventArgs)
        {
            Object[] arg ={ (Object)component, eventArgs };
            methodInfo.Invoke(eventReciever, arg);

        }
    }
}// END NAMESPACE