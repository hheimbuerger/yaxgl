using System;
using System.Collections.Generic;
using System.Text;
using System.Xml;

namespace de.yaxgl
{
    public class SimpleComponentFactory
    {
        
        public static Containable createComponent(Container owner,XmlElement xmlElement)
        {
            Containable component=null;
            if (xmlElement.Name.Equals("yaxgl:button"))
            {
                component = new Button(owner, xmlElement.Attributes["id"].InnerText);
                ((Button)component).setBounds(Convert.ToInt32(xmlElement.Attributes["xpos"].InnerText),
                    Convert.ToInt32(xmlElement.Attributes["ypos"].InnerText), Convert.ToInt32(xmlElement.Attributes["width"].InnerText),
                Convert.ToInt32(xmlElement.Attributes["height"].InnerText));
                ((Button)component).setLabel(xmlElement.Attributes["label"].InnerText);
            }
            else if (xmlElement.Name.Equals("yaxgl:label"))
            {
                component = new Label(owner, xmlElement.Attributes["id"].InnerText);
                ((Label)component).setBounds(Convert.ToInt32(xmlElement.Attributes["xpos"].InnerText),
                                    Convert.ToInt32(xmlElement.Attributes["ypos"].InnerText), Convert.ToInt32(xmlElement.Attributes["width"].InnerText),
                                Convert.ToInt32(xmlElement.Attributes["height"].InnerText));
                ((Label)component).setLabel(xmlElement.Attributes["label"].InnerText);
            }
            else if (xmlElement.Name.Equals("yaxgl:editbox"))
            {
                component = new EditBox(owner, xmlElement.Attributes["id"].InnerText);
                ((EditBox)component).setBounds(Convert.ToInt32(xmlElement.Attributes["xpos"].InnerText),
                                    Convert.ToInt32(xmlElement.Attributes["ypos"].InnerText), Convert.ToInt32(xmlElement.Attributes["width"].InnerText),
                                Convert.ToInt32(xmlElement.Attributes["height"].InnerText));
                ((EditBox)component).setText(xmlElement.Attributes["text"].InnerText);
                ((EditBox)component).setMaxLength(Convert.ToInt32(xmlElement.Attributes["maxlength"].InnerText));
            }
            else if (xmlElement.Name.Equals("yaxgl:checkbox"))
            {
                component = new CheckBox(owner, xmlElement.Attributes["id"].InnerText);
                ((CheckBox)component).setBounds(Convert.ToInt32(xmlElement.Attributes["xpos"].InnerText),
                                    Convert.ToInt32(xmlElement.Attributes["ypos"].InnerText), Convert.ToInt32(xmlElement.Attributes["width"].InnerText),
                                Convert.ToInt32(xmlElement.Attributes["height"].InnerText));
                ((CheckBox)component).setLabel(xmlElement.Attributes["label"].InnerText);
            
                if(xmlElement.Attributes["checked"].InnerText.Equals("true"))
                    ((CheckBox)component).setChecked(true);
                else if(xmlElement.Attributes["checked"].InnerText.Equals("false"))
                    ((CheckBox)component).setChecked(false);
                
            }
            else if (xmlElement.Name.Equals("yaxgl:combobox"))
            {
                component = new ComboBox(owner, xmlElement.Attributes["id"].InnerText);
                ((ComboBox)component).setBounds(Convert.ToInt32(xmlElement.Attributes["xpos"].InnerText),
                                    Convert.ToInt32(xmlElement.Attributes["ypos"].InnerText), Convert.ToInt32(xmlElement.Attributes["width"].InnerText),
                                Convert.ToInt32(xmlElement.Attributes["height"].InnerText));

                foreach (XmlNode xmlNode in xmlElement.ChildNodes)
                {
                    ((ComboBox)component).addItem(xmlNode.Attributes["label"].InnerText);
                }
                ((ComboBox)component).select(xmlElement.Attributes["selected"].InnerText);

            }
            else if (xmlElement.Name.Equals("yaxgl:groupref"))
            {
              

            }
            return component;
        }
    
    }
}
