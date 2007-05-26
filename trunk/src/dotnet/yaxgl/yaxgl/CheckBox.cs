using System;
using System.Collections.Generic;
using System.Text;

namespace de.yaxgl
{
    public class CheckBox : Control
    {
        public CheckBox(Container owner,string ID)
        {
            this.owner = owner;
            this.ID = ID;
            this.control = new System.Windows.Forms.CheckBox();
            //register events
            this.control.Click += new System.EventHandler(clickEvent);
            this.control.GotFocus += new System.EventHandler(focusEvent);
        }

        public void setChecked(bool checkedState)
        {
            ((System.Windows.Forms.CheckBox)this.control).Checked=checkedState;
        }

        public bool isChecked()
        {
            return ((System.Windows.Forms.CheckBox)this.control).Checked;
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
