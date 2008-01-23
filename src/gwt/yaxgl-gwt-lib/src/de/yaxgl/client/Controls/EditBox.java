package de.yaxgl.client.Controls;

import com.google.gwt.xml.client.Element;

import de.yaxgl.client.Base.Control;
import de.yaxgl.client.Container.Container;
import de.yaxgl.client.EventListener.ClickListener;
import de.yaxgl.client.EventListener.FocusListener;

public class EditBox extends Control {

	
	public EditBox(Container owner,String ID)
	{
		this.owner=owner;
		this.ID=ID;
		this.control = new com.google.gwt.user.client.ui.TextBox();
		
		control.addStyleName("yaxgl-editbox");
		
		owner.add(this);
	}
	
	public void initializeNativeControl(Element xmlElement) {

		setBounds(Integer.valueOf(xmlElement.getAttribute("xpos")),
				Integer.valueOf(xmlElement.getAttribute("ypos")),
				Integer.valueOf(xmlElement.getAttribute("width")),
				Integer.valueOf(xmlElement.getAttribute("height")));
		
		 setText(xmlElement.getAttribute("text"));
         //setMaxLength(Integer.valueOf(xmlElement.getAttribute("maxlength")).intValue());
	}

    public void setText(String text)
    {
    	((com.google.gwt.user.client.ui.TextBox)this.control).setText(text);
    }

    public String getText()
    {
        return ((com.google.gwt.user.client.ui.TextBox)this.control).getText();
    }
    
    public void setMaxLength(int length) 
    {
    	((com.google.gwt.user.client.ui.TextBox)this.control).setMaxLength(length);
    }

    public int getMaxLength()
    {
    	return ((com.google.gwt.user.client.ui.TextBox)this.control).getMaxLength();
    }
    
    
    
    /* methods for dealing with the EventListener Interfaces */
    public void addClickListener(ClickListener clickListener) {
   	 ((com.google.gwt.user.client.ui.TextBox)control).addClickListener(clickListener);
    }
    public void removeClickListener(ClickListener clickListener) {
   	 ((com.google.gwt.user.client.ui.TextBox)control).removeClickListener(clickListener);
    }
    public void addFocusListener(FocusListener focusListener) {
   	 ((com.google.gwt.user.client.ui.TextBox)control).addFocusListener(focusListener);
    }
    public void removeFocusListener(FocusListener focusListener) {
   	 ((com.google.gwt.user.client.ui.TextBox)control).removeFocusListener(focusListener);
    }
    
}
