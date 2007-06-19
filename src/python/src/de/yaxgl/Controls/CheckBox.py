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
            this.control.GotFocus += new System.EventHandler(gotFocusEvent);
            this.control.LostFocus += new System.EventHandler(lostFocusEvent);
        }

        public override void initializeNativeControl(System.Xml.XmlElement xmlElement)
        {
            setBounds(Convert.ToInt32(xmlElement.Attributes["xpos"].InnerText),
                      Convert.ToInt32(xmlElement.Attributes["ypos"].InnerText),
                      Convert.ToInt32(xmlElement.Attributes["width"].InnerText),
                      Convert.ToInt32(xmlElement.Attributes["height"].InnerText));
            setLabel(xmlElement.Attributes["label"].InnerText);
            setChecked(Boolean.Parse(xmlElement.Attributes["checked"].InnerText));
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
