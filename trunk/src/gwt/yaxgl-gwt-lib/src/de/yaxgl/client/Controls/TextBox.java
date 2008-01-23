package de.yaxgl.client.Controls;

import com.google.gwt.xml.client.Element;

import de.yaxgl.client.Base.Control;
import de.yaxgl.client.Container.Container;
import de.yaxgl.client.EventListener.ClickListener;
import de.yaxgl.client.EventListener.FocusListener;

public class TextBox extends Control {

	public TextBox(Container owner,String ID)
	{
		this.owner=owner;
		this.ID=ID;
		this.control=new com.google.gwt.user.client.ui.TextArea();
		
		control.addStyleName("yaxgl-textbox");
		
		owner.add(this);
	}
	
	
	public void initializeNativeControl(Element xmlElement) {

		setBounds(Integer.valueOf(xmlElement.getAttribute("xpos")),
				Integer.valueOf(xmlElement.getAttribute("ypos")),
				Integer.valueOf(xmlElement.getAttribute("width")),
				Integer.valueOf(xmlElement.getAttribute("height")));
		
		 setText(xmlElement.getAttribute("text"));
//         setMaxLength(Integer.valueOf(xmlElement.getAttribute("maxlength")));
	}
	
	public void setText(String text)
    {
    	((com.google.gwt.user.client.ui.TextArea)this.control).setText(text);
    }

    public String getText()
    {
        return ((com.google.gwt.user.client.ui.TextArea)this.control).getText();
    }
    
//    public void setMaxLength(int length) 
//    {
//    	((com.google.gwt.user.client.ui.TextArea)this.control).setTextLimit(length);
//    }
//
//    public int getMaxLength()
//    {
//    	return ((com.google.gwt.user.client.ui.TextArea)this.control).getTextLimit();
//    }
    
    
    /* methods for dealing with the EventListener Interfaces */
    public void addClickListener(ClickListener clickListener) {
   	 ((com.google.gwt.user.client.ui.TextArea)control).addClickListener(clickListener);
    }
    public void removeClickListener(ClickListener clickListener) {
   	 ((com.google.gwt.user.client.ui.TextArea)control).removeClickListener(clickListener);
    }
    public void addFocusListener(FocusListener focusListener) {
   	 ((com.google.gwt.user.client.ui.TextArea)control).addFocusListener(focusListener);
    }
    public void removeFocusListener(FocusListener focusListener) {
   	 ((com.google.gwt.user.client.ui.TextArea)control).removeFocusListener(focusListener);
    }
    
    
}
