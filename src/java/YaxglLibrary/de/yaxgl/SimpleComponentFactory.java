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

          if (xmlElement.getNodeName().equals("yaxgl:button"))
          {
              component = new Button(owner, xmlElement.getAttribute("id"));
          }
          else if (xmlElement.getLocalName().equals("label"))
          {
              //component = new Label(owner, xmlElement.getAttribute("id"));
          }
          else if (xmlElement.getLocalName().equals("editbox"))
          {
              //component = new EditBox(owner, xmlElement.getAttribute("id"));
          }
          else if (xmlElement.getLocalName().equals("textbox"))
          {
              //component = new TextBox(owner, xmlElement.getAttribute("id"));
          }
          else if (xmlElement.getLocalName().equals("checkbox"))
          {
             // component = new CheckBox(owner, xmlElement.getAttribute("id"));
          }
          else if (xmlElement.getLocalName().equals("imagebox"))
          {
             // component = new ImageBox(owner, xmlElement.getAttribute("id"));
          }
          else if (xmlElement.getLocalName().equals("combobox"))
          {
             // component = new ComboBox(owner, xmlElement.getAttribute("id"));
          }
          else if (xmlElement.getLocalName().equals("listbox"))
          {
             // component = new ListBox(owner, xmlElement.getAttribute("id"));
          }
          else if (xmlElement.getLocalName().equals("radiobutton"))
          {
             // component = new RadioButton(owner, xmlElement.getAttribute("id"));
          }
          else if (xmlElement.getLocalName().equals("groupref"))
          {
             // component = new Group(xmlElement.getAttribute("source"), owner, xmlElement.getAttribute("id"));
          }
          else if (xmlElement.getLocalName().equals("groupbox"))
          {
            //  component = new GroupBox(xmlElement, owner, xmlElement.getAttribute("id"));
          }
          else if (xmlElement.getLocalName().equals("radiogroup"))
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
