package de.yaxgl.EventDispatcher;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.yaxgl.Base.*;
import de.yaxgl.EventDispatcher.Attribute.*;

public class EventHandlerMethod {
	 private Object eventReciever;
     private Method methodInfo;
     private EventType eventType;
     private String eventID;
     private boolean regexOn;

     public EventHandlerMethod(Object eventReciever, Method methodInfo, EventType eventType,String eventID,boolean regexOn)
     {
         this.eventReciever = eventReciever;
         this.methodInfo = methodInfo;
         this.eventType = eventType;
         this.eventID = eventID;
         this.regexOn = regexOn;
     }

     
     public boolean isMatching(String eventID)
     {
         boolean retVal;
         if (regexOn)
         {
        	 Pattern p = Pattern.compile("^"+this.eventID+"$");
        	 Matcher m = p.matcher(eventID);
        	 retVal = m.matches();
         }
         else 
         {
             retVal=this.eventID.equals(eventID);   
         }
         return retVal;
     }

     public boolean isTypeOf(EventType eventType)
     {
         if (this.eventType == eventType)
             return true;
         else
             return false;
     
     }

     public void invokeMethod(Component component, EventArgs eventArgs)
     {
         Object[] arg ={ (Object)component, eventArgs };
         try {
			methodInfo.invoke(eventReciever, arg);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

     }
}
