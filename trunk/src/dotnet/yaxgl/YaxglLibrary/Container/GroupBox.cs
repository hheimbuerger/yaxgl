using System;
using System.Collections.Generic;
using System.Text;
using System.Xml;

namespace de.yaxgl
{
    public class GroupBox : Container,Containable
    {
        private Container owner = null;

        public GroupBox(XmlElement rootElement, Container owner, string ID)
        {
            this.owner = owner;
            this.ID = ID;
            this.control = new System.Windows.Forms.GroupBox();
            /*register events*/
            
            parseXML(rootElement);
            /*init*/
            initializeContainer();
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
