using System;
using System.Collections.Generic;
using System.Text;
using System.Xml;
namespace de.yaxgl
{
    public class RadioGroup : Container,Containable
    {
        
        public RadioGroup(XmlElement rootElement,Container owner, string ID) 
        {
            this.owner = owner;
            this.ID = ID;
            this.control = new System.Windows.Forms.Panel();
            
            /*register events*/

            parseXML(rootElement);
            
        }

        public override void initializeNativeControl(XmlElement xmlElement)
        {
            setBounds(Convert.ToInt32(xmlElement.Attributes["xpos"].InnerText),
                      Convert.ToInt32(xmlElement.Attributes["ypos"].InnerText),
                      Convert.ToInt32(xmlElement.Attributes["width"].InnerText),
                      Convert.ToInt32(xmlElement.Attributes["height"].InnerText));

            check(xmlElement.Attributes["checked"].InnerText);    
        }

        private void check(string radioButtonId)
        {
            if (components.ContainsKey(radioButtonId))
                ((RadioButton)components[radioButtonId]).setChecked(true);
        }

        public RadioButton getCheckedRadioButton()
        {
            RadioButton retVal=null;
            foreach (KeyValuePair<string,Containable> keyValue in components)
            {
                if (((RadioButton)keyValue.Value).isChecked())
                    retVal=(RadioButton)keyValue.Value;  
            }
            return retVal;
        }
        
        public override void notifyEvent(Component control, EventArgs eventArgs)
        {
            owner.notifyEvent(control, eventArgs);
        }

    }
}
