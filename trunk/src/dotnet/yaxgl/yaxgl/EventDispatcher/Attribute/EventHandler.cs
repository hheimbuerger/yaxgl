using System;
using System.Collections.Generic;
using System.Text;

namespace de.yaxgl
{
    [System.AttributeUsage(System.AttributeTargets.Method,AllowMultiple=true)]
    public class EventHandler : System.Attribute
    {

        /* this is to anotate like
         * [de.yaxgl.EventHandler(eventType=EventType.Click,eventID="button1")]
         * that so Regulare Expressions are off
         * or like this
         * [de.yaxgl.EventHandler(eventType = EventType.GotFocus, eventID = ".*",regexOn=true)]
         * so regulare expressions are on
         * **/
        public string eventID;
        public EventType eventType;
        public bool regexOn=false;

        public EventHandler() 
        { 
        
        }

        /* this is for anotade like
         * [de.yaxgl.EventHandler(EventType.SelectionChanged, "listbox1")]
         * this.
         * Regulare expressions are off for this method
         * **/
        public EventHandler(EventType eventType, string eventID)
        {
            this.eventID = eventID;
            this.eventType = eventType;
        }

        /* or you can do it like this
         *  [de.yaxgl.EventHandler(EventType.Click, "radio\\d",true)]
         * so regulare expressions ar also on
         * */
        public EventHandler(EventType eventType, string eventID,bool regexOn)
        {
            this.eventID = eventID;
            this.eventType = eventType;
            this.regexOn = regexOn;
        }
    }
         
}
