using System;
using System.Collections.Generic;
using System.Text;
using System.Xml;
namespace de.yaxgl
{
    //TODO: we need an other name for group
    public class Group : Container,Containable
    {
        private Container owner = null;
        
        public Group(string xmlfile,Container owner,string ID)
        {
            this.owner = owner;
            this.ID = ID;
            this.control = new System.Windows.Forms.Panel();
            
            XmlDocument xmlDocument = new XmlDocument();

            //TODO: Exception
            xmlDocument.Load(xmlfile);
            XmlElement rootElement = xmlDocument.DocumentElement;

            parseXML(rootElement);
            
            //register GroupEvents

            initialiceContainer();
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
