using System;
using System.Collections.Generic;
using System.Text;


namespace de.yaxgl
{
    public class GroupBox : Container,Containable
    {
        
        public GroupBox(System.Xml.XmlElement rootElement, Container owner, string ID)
        {
            this.owner = owner;
            this.ID = ID;
            this.control = new System.Windows.Forms.GroupBox();
            /*register events*/
            
            parseXML(rootElement);
        }

        public override void initializeNativeControl(System.Xml.XmlElement xmlElement)
        {
            setBounds(Convert.ToInt32(xmlElement.Attributes["xpos"].InnerText),
                      Convert.ToInt32(xmlElement.Attributes["ypos"].InnerText), 
                      Convert.ToInt32(xmlElement.Attributes["width"].InnerText),
                      Convert.ToInt32(xmlElement.Attributes["height"].InnerText));
            setTitle(xmlElement.Attributes["title"].InnerText);
        }
        
        public override void notifyEvent(Component control, EventArgs eventArgs)
        {
            owner.notifyEvent(control, eventArgs);
        }

        /*returns the container title**/
        public string getTitle()
        {
            return this.control.Text;
        }


        /*sets the container title**/
        public void setTitle(string title)
        {
            this.control.Text = title;
        }

    
    }





}
