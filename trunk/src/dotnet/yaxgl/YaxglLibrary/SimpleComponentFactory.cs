using System;
using System.Collections.Generic;
using System.Text;
using System.Xml;

namespace de.yaxgl
{
    public class SimpleComponentFactory
    {

        class NoImplementationForXmlElementException : Exception 
        {
            public NoImplementationForXmlElementException()
            {
            
            }
            public NoImplementationForXmlElementException(string message)
                : base(message)
            {
            
            }
            
            public NoImplementationForXmlElementException(string message, Exception inner)
            : base(message, inner)
            {
            
            }
        }

        public static Containable createComponent(Container owner,XmlElement xmlElement)
        {
            Containable component=null;
            
            if (xmlElement.LocalName.Equals("button"))
            {
                component = new Button(owner, xmlElement.Attributes["id"].InnerText);
            }            
            else if (xmlElement.LocalName.Equals("label"))
            {
                component = new Label(owner, xmlElement.Attributes["id"].InnerText);                
            }
            else if (xmlElement.LocalName.Equals("editbox"))
            {
                component = new EditBox(owner, xmlElement.Attributes["id"].InnerText);                
            }
            else if (xmlElement.LocalName.Equals("textbox"))
            {
                component = new TextBox(owner, xmlElement.Attributes["id"].InnerText);
             }
            else if (xmlElement.LocalName.Equals("checkbox"))
            {
                component = new CheckBox(owner, xmlElement.Attributes["id"].InnerText);                
            }
            else if (xmlElement.LocalName.Equals("imagebox"))
            {
                component = new ImageBox(owner, xmlElement.Attributes["id"].InnerText);
            }
            else if (xmlElement.LocalName.Equals("combobox"))
            {
                component = new ComboBox(owner, xmlElement.Attributes["id"].InnerText);                
            }
            else if (xmlElement.LocalName.Equals("listbox"))
            {
                component = new ListBox(owner, xmlElement.Attributes["id"].InnerText);                
            }
            else if (xmlElement.LocalName.Equals("radiobutton"))
            {
                component = new RadioButton(owner, xmlElement.Attributes["id"].InnerText);
            }
            else if (xmlElement.LocalName.Equals("groupref"))
            {
                component = new Group(xmlElement.Attributes["source"].InnerText, owner, xmlElement.Attributes["id"].InnerText);
            }
            else if (xmlElement.LocalName.Equals("groupbox"))
            {
                component = new GroupBox(xmlElement, owner, xmlElement.Attributes["id"].InnerText);
            }
            else if (xmlElement.LocalName.Equals("radiogroup"))
            {
                component = new RadioGroup(xmlElement,owner, xmlElement.Attributes["id"].InnerText);
            }
            else
            {
                throw new NoImplementationForXmlElementException("Error on creating component: No implementation for "+xmlElement.LocalName+ " jet available in this library." );
            }

            ((Component)component).initializeNativeControl(xmlElement);
            return component;
        }
    
    }
}
