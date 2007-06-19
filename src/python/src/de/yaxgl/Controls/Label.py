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

        public override void initializeNativeControl(System.Xml.XmlElement xmlElement)
        {
            setBounds(Convert.ToInt32(xmlElement.Attributes["xpos"].InnerText),
                      Convert.ToInt32(xmlElement.Attributes["ypos"].InnerText),
                      Convert.ToInt32(xmlElement.Attributes["width"].InnerText),
                      Convert.ToInt32(xmlElement.Attributes["height"].InnerText));
            setLabel(xmlElement.Attributes["label"].InnerText);
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
