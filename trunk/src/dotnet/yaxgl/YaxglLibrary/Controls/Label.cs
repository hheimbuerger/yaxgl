using System;
using System.Collections.Generic;
using System.Text;

namespace de.yaxgl
{
    public class Label : Control
    {
        
        public Label(Container owner, string ID)
        {
            this.owner = owner;
            this.ID = ID;
            this.control = new System.Windows.Forms.Label();
            this.control.Click += new System.EventHandler(clickEvent);
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
