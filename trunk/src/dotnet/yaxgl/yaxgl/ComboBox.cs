using System;
using System.Collections.Generic;
using System.Text;

namespace de.yaxgl
{
    public class ComboBox:Control
    {
        public ComboBox(Container owner, string ID)
        {
            this.owner = owner;
            this.ID = ID;

            this.control = new System.Windows.Forms.ComboBox();
            this.control.GotFocus += new System.EventHandler(focusEvent);
        }



    }
}
