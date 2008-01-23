/**
 * 
 */
package de.yaxgl.client.Controls;

import com.google.gwt.xml.client.Element;

import de.yaxgl.client.Base.Control;
import de.yaxgl.client.Container.Container;
import de.yaxgl.client.EventListener.ClickListener;
import de.yaxgl.client.EventListener.FocusListener;


public class Button extends Control {

	public Button(Container owner,String ID)
	{
		this.ID=ID;
		this.owner=owner;
		this.control = new com.google.gwt.user.client.ui.Button();
		
		control.addStyleName("yaxgl-button");
		
		owner.add(this);
	}
	
	public void initializeNativeControl(Element xmlElement) {
		
		setBounds(Integer.valueOf(xmlElement.getAttribute("xpos")),
				Integer.valueOf(xmlElement.getAttribute("ypos")),
				Integer.valueOf(xmlElement.getAttribute("width")),
				Integer.valueOf(xmlElement.getAttribute("height")));

        setLabel(xmlElement.getAttribute("label"));
		
	}
	
	public String getLabel()
     {
         return ((com.google.gwt.user.client.ui.Button)this.control).getText();
     }

     public void setLabel(String label)
     {
    	 ((com.google.gwt.user.client.ui.Button)this.control).setText(label);
     }
     
     
     /* methods for dealing with the EventListener Interfaces */
     public void addClickListener(ClickListener clickListener) {
    	 ((com.google.gwt.user.client.ui.Button)control).addClickListener(clickListener);
     }
     public void removeClickListener(ClickListener clickListener) {
    	 ((com.google.gwt.user.client.ui.Button)control).removeClickListener(clickListener);
     }
     public void addFocusListener(FocusListener focusListener) {
    	 ((com.google.gwt.user.client.ui.Button)control).addFocusListener(focusListener);
     }
     public void removeFocusListener(FocusListener focusListener) {
    	 ((com.google.gwt.user.client.ui.Button)control).removeFocusListener(focusListener);
     }
     
}
