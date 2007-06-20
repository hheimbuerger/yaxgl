from de.yaxgl.Controls.Button import Button
from de.yaxgl.Controls.CheckBox import CheckBox
from de.yaxgl.Controls.Label import Label
from de.yaxgl.Controls.ComboBox import ComboBox



class NoImplementationForXmlElementError(Exception):
    pass



class SimpleComponentFactory:
    
    def __init__(self):
        return(None)
    
    @classmethod
    def createComponent(cls, owner, xmlElement):
        component = None
        
        if(xmlElement.localName == "button"):
            component = Button(owner, xmlElement.getAttribute("id"))
        elif(xmlElement.localName == "checkbox"):
            component = CheckBox(owner, xmlElement.getAttribute("id"))
        elif(xmlElement.localName == "label"):
            component = Label(owner, xmlElement.getAttribute("id"))
        elif(xmlElement.localName == "combobox"):
            component = ComboBox(owner, xmlElement.getAttribute("id"))
#===============================================================================
#            else if (xmlElement.LocalName.Equals("editbox"))
#            {
#                component = new EditBox(owner, xmlElement.Attributes["id"].InnerText);
#            }
#            else if (xmlElement.LocalName.Equals("textbox"))
#            {
#                component = new TextBox(owner, xmlElement.Attributes["id"].InnerText);
#            }
#            else if (xmlElement.LocalName.Equals("imagebox"))
#            {
#                component = new ImageBox(owner, xmlElement.Attributes["id"].InnerText);
#            }
#            else if (xmlElement.LocalName.Equals("listbox"))
#            {
#                component = new ListBox(owner, xmlElement.Attributes["id"].InnerText);
#            }
#            else if (xmlElement.LocalName.Equals("radiobutton"))
#            {
#                component = new RadioButton(owner, xmlElement.Attributes["id"].InnerText);
#            }
#            else if (xmlElement.LocalName.Equals("groupref"))
#            {
#                component = new Group(xmlElement.Attributes["source"].InnerText, owner, xmlElement.Attributes["id"].InnerText);
#            }
#            else if (xmlElement.LocalName.Equals("groupbox"))
#            {
#                component = new GroupBox(xmlElement, owner, xmlElement.Attributes["id"].InnerText);
#            }
#            else if (xmlElement.LocalName.Equals("radiogroup"))
#            {
#                component = new RadioGroup(xmlElement, owner, xmlElement.Attributes["id"].InnerText);
#            }
#===============================================================================
        else:
            raise NoImplementationForXmlElementException("Error on creating component: No implementation for " + xmlElement.LocalName + " yet available in this library.");
            
        # init the component with the in xml given attributes
        component.initializeNativeControl(xmlElement)
        
        return(component)
