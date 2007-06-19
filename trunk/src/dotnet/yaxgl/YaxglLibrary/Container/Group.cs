using System;
using System.Collections.Generic;
using System.Text;
using System.Xml;
namespace de.yaxgl
{
    //TODO: we need an other name for group
    public class Group : Container,Containable
    {
        
        public Group(string xmlfile,Container owner,string ID)
        {
            this.owner = owner;
            this.ID = ID;
            this.control = new System.Windows.Forms.Panel();

            XmlElement rootElement = null;

            rootElement = validateXmlDocument(xmlfile);

            parseXML(rootElement);
            
            //TODO:register GroupEvents
            
        }

        public override void initializeNativeControl(XmlElement xmlElement)
        {
            Location location = new Location(Convert.ToInt32(xmlElement.Attributes["xpos"].InnerText),
                                 Convert.ToInt32(xmlElement.Attributes["ypos"].InnerText));
            setLocation(location);

        }

        public override void notifyEvent(Component control, EventArgs eventArgs)
        {
            owner.notifyEvent(control, eventArgs);    
        }

        /* setting border to group true=border false=noneborder*/
        public void setBorder(bool border)
        {
            if (border)
            {
                ((System.Windows.Forms.Panel)this.control).BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            }
            else
            {
                ((System.Windows.Forms.Panel)this.control).BorderStyle = System.Windows.Forms.BorderStyle.None;
            }
        
        }
    
    }
}
