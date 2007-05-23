using System;
using System.Collections.Generic;
using System.Text;

namespace de.yaxgl
{
    public abstract class Control : Component,Containable
    {
        protected Container owner = null;
        
        //public abstract void setVisible(bool visible);
        //public abstract bool isVisible();

        public void clickEvent(object sender, System.EventArgs e)
        {
            owner.notifyEvent(this, new EventArgs(EventType.Click, this.ID));
        }

        public void focusEvent(object sender, System.EventArgs e)
        {
            owner.notifyEvent(this,new EventArgs(EventType.Focus, this.ID));
        }
        
        public void selectionChangedEvent(object sender, System.EventArgs e)
        {
            owner.notifyEvent(this, new EventArgs(EventType.SelectionChanged, this.ID));
        }

        public string getLabel()
        {
            return this.control.Text;
        }

        public void setLabel(string label)
        {
            this.control.Text = label;
        }

        

        public void setEnabled(bool enabled)
        {
            this.control.Enabled = enabled;
        }

        public bool isEnabled()
        {
            return this.control.Enabled;
        }
        
        public System.Windows.Forms.Control getBaseControl()
        {
            return this.control;
        }
    }
}
