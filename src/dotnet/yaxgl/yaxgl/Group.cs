using System;
using System.Collections.Generic;
using System.Text;

namespace de.yaxgl
{
    public class Group : Container,Containable
    {
        Container owner = null;
        
        public Group(Container owner,string ID)
        {
            this.owner = owner;
            this.ID = ID;
            this.control = new System.Windows.Forms.Panel();

            //System.Windows.Forms.GroupBox b = new System.Windows.Forms.GroupBox();
            //parseXML(filename);
            parseXMLG("");
            System.Console.WriteLine("Soviele:" + this.components.Count);
            initialiceContainer();
        }

        public System.Windows.Forms.Control getBaseControl()
        {
            return this.control;
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
