using System;
using System.Collections.Generic;
using System.Text;

namespace de.yaxgl
{
    public class RadioButton : Control
    {
        public RadioButton(Container owner, string ID)
        {
            this.owner = owner;
            this.ID = ID;
            this.control = new System.Windows.Forms.RadioButton();
            /*register events*/
            this.control.Click += new System.EventHandler(clickEvent);
            this.control.GotFocus += new System.EventHandler(gotFocusEvent);
            this.control.LostFocus += new System.EventHandler(lostFocusEvent);
        }

        public void setChecked(bool checkedState)
        {
            
            ((System.Windows.Forms.RadioButton)this.control).Checked = checkedState;
        }

        public bool isChecked()
        {
            return ((System.Windows.Forms.RadioButton)this.control).Checked;
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
