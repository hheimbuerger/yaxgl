package de.yaxgl;


import org.w3c.dom.Element;

import de.yaxgl.Base.*;
import de.yaxgl.Container.*;
import de.yaxgl.Controls.*;


public class SimpleComponentFactory {
	  
	@SuppressWarnings("serial")
	public class NoImplementationForXmlElementException extends Exception
      {
          public NoImplementationForXmlElementException()
          {

          }
          public NoImplementationForXmlElementException(String message)
          {
        	  super(message);
          }

          public NoImplementationForXmlElementException(String message, Exception inner)
          {
        	  super(message,inner);
          }
      }

      public static Containable createComponent(Container owner, Element xmlElement) 
      {
          Containable component = null;

          //TODO: the thing with the namespce uri and the localElementName
          if (xmlElement.getNodeName().equals("yaxgl:button"))
          {
              component = new Button(owner, xmlElement.getAttribute("id"));
          }
          else if (xmlElement.getNodeName().equals("yaxgl:label"))
          {
              component = new Label(owner, xmlElement.getAttribute("id"));
          }
          else if (xmlElement.getNodeName().equals("yaxgl:editbox"))
          {
              component = new EditBox(owner, xmlElement.getAttribute("id"));
          }
          else if (xmlElement.getNodeName().equals("textbox"))
          {
              //component = new TextBox(owner, xmlElement.getAttribute("id"));
          }
          else if (xmlElement.getNodeName().equals("yaxgl:checkbox"))
          {
              component = new CheckBox(owner, xmlElement.getAttribute("id"));
          }
          else if (xmlElement.getNodeName().equals("imagebox"))
          {
             // component = new ImageBox(owner, xmlElement.getAttribute("id"));
          }
          else if (xmlElement.getNodeName().equals("yaxgl:combobox"))
          {
              component = new ComboBox(owner, xmlElement.getAttribute("id"));
          }
          else if (xmlElement.getNodeName().equals("listbox"))
          {
             // component = new ListBox(owner, xmlElement.getAttribute("id"));
          }
          else if (xmlElement.getNodeName().equals("radiobutton"))
          {
             // component = new RadioButton(owner, xmlElement.getAttribute("id"));
          }
          else if (xmlElement.getNodeName().equals("groupref"))
          {
             // component = new Group(xmlElement.getAttribute("source"), owner, xmlElement.getAttribute("id"));
          }
          else if (xmlElement.getNodeName().equals("groupbox"))
          {
            //  component = new GroupBox(xmlElement, owner, xmlElement.getAttribute("id"));
          }
          else if (xmlElement.getNodeName().equals("radiogroup"))
          {
             // component = new RadioGroup(xmlElement, owner, xmlElement.getAttribute("id"));
          }
          else
          {
             // throw new NoImplementationForXmlElementException("Error on creating component: No implementation for " + xmlElement.getLocalName() + " jet available in this library.");
			
          }

          /*init the component with the in xml given attributes*/
          ((Component)component).initializeNativeControl(xmlElement);
          return component;
      }
}
