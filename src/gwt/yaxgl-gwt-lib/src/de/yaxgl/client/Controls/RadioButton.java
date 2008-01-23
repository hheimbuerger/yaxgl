package de.yaxgl.client.Controls;

import com.google.gwt.xml.client.Element;

import de.yaxgl.client.Base.Control;
import de.yaxgl.client.Container.Container;
import de.yaxgl.client.EventListener.ClickListener;
import de.yaxgl.client.EventListener.FocusListener;

public class RadioButton extends Control {

	public RadioButton(Container owner, String ID)
	{
		this.ID=ID;
		this.owner=owner;
		this.control = new com.google.gwt.user.client.ui.RadioButton( owner.getID() );
		
		control.addStyleName("yaxgl-radiobutton");
		
		owner.add(this);
	}
	
	
	public void initializeNativeControl(Element xmlElement) {
		setBounds(Integer.valueOf(xmlElement.getAttribute("xpos")),
				Integer.valueOf(xmlElement.getAttribute("ypos")),
				Integer.valueOf(xmlElement.getAttribute("width")),
				Integer.valueOf(xmlElement.getAttribute("height")));

        setLabel(xmlElement.getAttribute("label"));
		
	}
	
	 public void setChecked(boolean checkedState)
     {
		 ((com.google.gwt.user.client.ui.RadioButton)this.control).setChecked(checkedState);
     }

     public boolean isChecked()
     {
    	 return ((com.google.gwt.user.client.ui.RadioButton)this.control).isChecked();
     }
	
	public String getLabel()
    {
		return ((com.google.gwt.user.client.ui.RadioButton)this.control).getText();
    }

    public void setLabel(String label)
    {
    	((com.google.gwt.user.client.ui.RadioButton)this.control).setText(label);
    }
    
    
    /* methods for dealing with the EventListener Interfaces */
    public void addClickListener(ClickListener clickListener) {
   	 ((com.google.gwt.user.client.ui.RadioButton)control).addClickListener(clickListener);
    }
    public void removeClickListener(ClickListener clickListener) {
   	 ((com.google.gwt.user.client.ui.RadioButton)control).removeClickListener(clickListener);
    }
    public void addFocusListener(FocusListener focusListener) {
   	 ((com.google.gwt.user.client.ui.RadioButton)control).addFocusListener(focusListener);
    }
    public void removeFocusListener(FocusListener focusListener) {
   	 ((com.google.gwt.user.client.ui.RadioButton)control).removeFocusListener(focusListener);
    }
    
}