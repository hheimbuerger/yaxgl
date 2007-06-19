using System;
using System.Collections.Generic;
using System.Text;

namespace de.yaxgl
{
    public class EditBox :Control
    {
        public EditBox(Container owner, string ID)
        {
            this.owner = owner;
            this.ID = ID;

            this.control = new System.Windows.Forms.TextBox();
            this.control.Click += new System.EventHandler(clickEvent);
            this.control.GotFocus += new System.EventHandler(gotFocusEvent);
            this.control.LostFocus += new System.EventHandler(lostFocusEvent);
        }

        public override void  initializeNativeControl(System.Xml.XmlElement xmlElement)
        {
            setBounds(Convert.ToInt32(xmlElement.Attributes["xpos"].InnerText),
                      Convert.ToInt32(xmlElement.Attributes["ypos"].InnerText),
                      Convert.ToInt32(xmlElement.Attributes["width"].InnerText),
                      Convert.ToInt32(xmlElement.Attributes["height"].InnerText));
            setText(xmlElement.Attributes["text"].InnerText);
            setMaxLength(Convert.ToInt32(xmlElement.Attributes["maxlength"].InnerText));
        }
    
        
        
        public void setText(string text)
        {
            this.control.Text = text;
        }

        public string getText()
        {
            return this.control.Text;
        }
        
        public void setMaxLength(int length) 
        {
            ((System.Windows.Forms.TextBox)this.control).MaxLength = length;
        
        }

        public int getMaxLength()
        {
            return  ((System.Windows.Forms.TextBox)this.control).MaxLength;
        }
    }
}
