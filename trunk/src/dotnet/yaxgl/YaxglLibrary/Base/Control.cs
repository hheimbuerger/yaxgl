using System;
using System.Collections.Generic;
using System.Text;

namespace de.yaxgl
{
    public abstract class Control : Component,Containable
    {
        
        protected void clickEvent(object sender, System.EventArgs e)
        {
            owner.notifyEvent(this, new EventArgs(EventType.Click, this.ID));
        }

        protected void gotFocusEvent(object sender, System.EventArgs e)
        {
            owner.notifyEvent(this,new EventArgs(EventType.GotFocus, this.ID));
        }

        protected void lostFocusEvent(object sender, System.EventArgs e)
        {
            owner.notifyEvent(this, new EventArgs(EventType.LostFocus, this.ID));
        }
        
        protected void selectionChangedEvent(object sender, System.EventArgs e)
        {
            owner.notifyEvent(this, new EventArgs(EventType.SelectionChanged, this.ID));
        }

        public void setEnabled(bool enabled)
        {
            this.control.Enabled = enabled;
        }

        public bool isEnabled()
        {
            return this.control.Enabled;
        }   
    }
}
