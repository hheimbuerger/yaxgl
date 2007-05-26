using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;

namespace de.yaxgl
{
    public class Button : Control
    {
       
        public Button(Container owner,string ID)
        {
            this.owner = owner;
            this.ID = ID;
            this.control = new System.Windows.Forms.Button();

            //register events
            this.control.Click += new System.EventHandler(clickEvent);
            this.control.GotFocus += new System.EventHandler(focusEvent); 
        }
        
        public string getLabel()
        {
            return this.control.Text;
        }

        public void setLabel(string label)
        {
            this.control.Text = label;
        }

    }
}
