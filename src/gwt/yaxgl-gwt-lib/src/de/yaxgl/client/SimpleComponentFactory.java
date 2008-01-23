package de.yaxgl.client;


import com.google.gwt.core.client.GWT;
import com.google.gwt.xml.client.Element;

import de.yaxgl.client.Base.*;
import de.yaxgl.client.Container.*;
import de.yaxgl.client.Controls.*;


public class SimpleComponentFactory {

	
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
          else if (xmlElement.getNodeName().equals("yaxgl:checkbox"))
          {
              component = new CheckBox(owner, xmlElement.getAttribute("id"));
          }
          else if (xmlElement.getNodeName().equals("yaxgl:combobox"))
          {
              component = new ComboBox(owner, xmlElement.getAttribute("id"));
          }
          else if (xmlElement.getNodeName().equals("yaxgl:editbox"))
          {
              component = new EditBox(owner, xmlElement.getAttribute("id"));
          }
          else if (xmlElement.getNodeName().equals("yaxgl:imagebox"))
          {
              component = new ImageBox(owner, xmlElement.getAttribute("id"));
          }
          else if (xmlElement.getNodeName().equals("yaxgl:image"))
          {
              component = new ImageBox(owner, xmlElement.getAttribute("id"));
          }
          else if (xmlElement.getNodeName().equals("yaxgl:label"))
          {
              component = new Label(owner, xmlElement.getAttribute("id"));
          }
          else if (xmlElement.getNodeName().equals("yaxgl:listbox"))
          {
              component = new ListBox(owner, xmlElement.getAttribute("id"));
          }
          else if (xmlElement.getNodeName().equals("yaxgl:radiobutton"))
          {
              component = new RadioButton(owner, xmlElement.getAttribute("id"));
          }
          else if (xmlElement.getNodeName().equals("yaxgl:textbox"))
          {
              component = new TextBox(owner, xmlElement.getAttribute("id"));
          }
          
          else if (xmlElement.getNodeName().equals("yaxgl:page"))
          {
              component = new Page(owner, xmlElement.getAttribute("id"));
              ((Container)component).parseXML(xmlElement);
          }
          else if (xmlElement.getNodeName().equals("yaxgl:group"))
          {
              component = new Group(owner, xmlElement.getAttribute("id"));
              ((Container)component).parseXML(xmlElement);
          }
          else if (xmlElement.getNodeName().equals("yaxgl:groupbox"))
          {
            //  component = new GroupBox(xmlElement, owner, xmlElement.getAttribute("id"));
          }
          else if (xmlElement.getNodeName().equals("yaxgl:radiogroup"))
          {
              component = new RadioGroup(owner, xmlElement.getAttribute("id"));
              ((Container)component).parseXML(xmlElement);
          }
          else
          {
              //throw new NoImplementationForXmlElementException("Error on creating component: No implementation for " + xmlElement.getNodeName() + " jet available in this library.");
              GWT.log("NoImplementationForXmlElementException", new Throwable());
          }
          
          
          
          /*init the component with the in xml given attributes*/
          if (component!=null)
        	  ((Component)component).initializeNativeControl(xmlElement);
          
          if (component instanceof Component) {
        	  GlobalIDManager.addComponent((Component)component);
          }
          if (component instanceof Page) {
        	  NavigationHandler.getInstance().addPage((Page)component);
          }
          
          
          return component;
      }
      
      
}
