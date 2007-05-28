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
            else if (xmlElement.Name.Equals("yaxgl:textbox"))
            {
                component = new TextBox(owner, xmlElement.Attributes["id"].InnerText);
                ((TextBox)component).setBounds(Convert.ToInt32(xmlElement.Attributes["xpos"].InnerText),
                                    Convert.ToInt32(xmlElement.Attributes["ypos"].InnerText), Convert.ToInt32(xmlElement.Attributes["width"].InnerText),
                                Convert.ToInt32(xmlElement.Attributes["height"].InnerText));
                ((TextBox)component).setText(xmlElement.Attributes["text"].InnerText);
                ((TextBox)component).setMaxLength(Convert.ToInt32(xmlElement.Attributes["maxlength"].InnerText));
            }
            else if (xmlElement.Name.Equals("yaxgl:checkbox"))
            {
                component = new CheckBox(owner, xmlElement.Attributes["id"].InnerText);
                ((CheckBox)component).setBounds(Convert.ToInt32(xmlElement.Attributes["xpos"].InnerText),
                                    Convert.ToInt32(xmlElement.Attributes["ypos"].InnerText), Convert.ToInt32(xmlElement.Attributes["width"].InnerText),
                                Convert.ToInt32(xmlElement.Attributes["height"].InnerText));
                ((CheckBox)component).setLabel(xmlElement.Attributes["label"].InnerText);
                if (xmlElement.HasAttribute("checked"))
                {
                    if (xmlElement.Attributes["checked"].InnerText.Equals("true"))
                        ((CheckBox)component).setChecked(true);
                    else if (xmlElement.Attributes["checked"].InnerText.Equals("false"))
                        ((CheckBox)component).setChecked(false);
                }
            }
            else if (xmlElement.Name.Equals("yaxgl:imagebox"))
            {
                component = new ImageBox(owner, xmlElement.Attributes["id"].InnerText);
                ((ImageBox)component).setBounds(Convert.ToInt32(xmlElement.Attributes["xpos"].InnerText),
                                    Convert.ToInt32(xmlElement.Attributes["ypos"].InnerText), Convert.ToInt32(xmlElement.Attributes["width"].InnerText),
                                Convert.ToInt32(xmlElement.Attributes["height"].InnerText));
                ((ImageBox)component).loadImage(xmlElement.Attributes["source"].InnerText);
            }
            else if (xmlElement.Name.Equals("yaxgl:combobox"))
            {
                component = new ComboBox(owner, xmlElement.Attributes["id"].InnerText);
                ((ComboBox)component).setBounds(Convert.ToInt32(xmlElement.Attributes["xpos"].InnerText),
                                    Convert.ToInt32(xmlElement.Attributes["ypos"].InnerText), Convert.ToInt32(xmlElement.Attributes["width"].InnerText),
                                Convert.ToInt32(xmlElement.Attributes["height"].InnerText));

                foreach (XmlNode xmlNode in xmlElement.ChildNodes)
                {
                    if (xmlNode.NodeType == XmlNodeType.Element)
                    {
                        XmlElement itemElement = (XmlElement)xmlNode;
                        ((ComboBox)component).addItem(itemElement.Attributes["label"].InnerText);
                    }
                }

                if (xmlElement.HasAttribute("selected"))
                {
                    ((ComboBox)component).select(xmlElement.Attributes["selected"].InnerText);
                }
            }
            else if (xmlElement.Name.Equals("yaxgl:listbox"))
            {
                component = new ListBox(owner, xmlElement.Attributes["id"].InnerText);
                ((ListBox)component).setBounds(Convert.ToInt32(xmlElement.Attributes["xpos"].InnerText),
                                    Convert.ToInt32(xmlElement.Attributes["ypos"].InnerText), Convert.ToInt32(xmlElement.Attributes["width"].InnerText),
                                Convert.ToInt32(xmlElement.Attributes["height"].InnerText));

                if (xmlElement.Attributes["multiselect"].InnerText.Equals("true"))
                    ((ListBox)component).setMultiselection(true);
                else if (xmlElement.Attributes["multiselect"].InnerText.Equals("false"))
                    ((ListBox)component).setMultiselection(false);


                foreach (XmlNode xmlNode in xmlElement.ChildNodes)
                {
                    if (xmlNode.NodeType == XmlNodeType.Element)
                    {
                        XmlElement itemElement = (XmlElement)xmlNode;
                        string item = itemElement.Attributes["label"].InnerText;
                        ((ListBox)component).addItem(item);
                        if (itemElement.HasAttribute("selected"))
                        {
                            if (itemElement.Attributes["selected"].InnerText.Equals("true"))
                                ((ListBox)component).select(item);
                        }
                    }
                }
            }
            else if (xmlElement.Name.Equals("yaxgl:radiobutton"))
            {
                component = new RadioButton(owner, xmlElement.Attributes["id"].InnerText);
                ((RadioButton)component).setBounds(Convert.ToInt32(xmlElement.Attributes["xpos"].InnerText),
                                    Convert.ToInt32(xmlElement.Attributes["ypos"].InnerText), Convert.ToInt32(xmlElement.Attributes["width"].InnerText),
                                Convert.ToInt32(xmlElement.Attributes["height"].InnerText));
                ((RadioButton)component).setLabel(xmlElement.Attributes["label"].InnerText);

                if (xmlElement.HasAttribute("checked"))
                {
                    if (xmlElement.Attributes["checked"].InnerText.Equals("true"))
                        ((RadioButton)component).setChecked(true);
                    else if (xmlElement.Attributes["checked"].InnerText.Equals("false"))
                        ((RadioButton)component).setChecked(false);
                }
            }
            else if (xmlElement.Name.Equals("yaxgl:groupref"))
            {
                component = new Group(xmlElement.Attributes["source"].InnerText, owner, xmlElement.Attributes["id"].InnerText);
                Position position = new Position(Convert.ToInt32(xmlElement.Attributes["xpos"].InnerText),
                                    Convert.ToInt32(xmlElement.Attributes["ypos"].InnerText));
                ((Group)component).setPosition(position);
            }
            else if (xmlElement.Name.Equals("yaxgl:groupbox"))
            {
                component = new GroupBox(xmlElement, owner, xmlElement.Attributes["id"].InnerText);
                ((GroupBox)component).setBounds(Convert.ToInt32(xmlElement.Attributes["xpos"].InnerText),
                                    Convert.ToInt32(xmlElement.Attributes["ypos"].InnerText), Convert.ToInt32(xmlElement.Attributes["width"].InnerText),
                                Convert.ToInt32(xmlElement.Attributes["height"].InnerText));
                ((GroupBox)component).setTitle(xmlElement.Attributes["title"].InnerText);
            }
            return component;
        }
    
    }
}
