package de.yaxgl.client.Controls;

import com.google.gwt.xml.client.Element;

import de.yaxgl.client.Base.Control;
import de.yaxgl.client.Container.Container;
import de.yaxgl.client.EventListener.ClickListener;
import de.yaxgl.client.EventListener.FocusListener;

public class CheckBox extends Control {

	public CheckBox(Container owner,String ID)
	{
		this.owner=owner;
		this.ID=ID;
		this.control = new com.google.gwt.user.client.ui.CheckBox();
		
		control.addStyleName("yaxgl-checkbox");
		
		owner.add(this);
	}
	
	
	public void initializeNativeControl(Element xmlElement) {
		
		setBounds(Integer.valueOf(xmlElement.getAttribute("xpos")),
				Integer.valueOf(xmlElement.getAttribute("ypos")),
				Integer.valueOf(xmlElement.getAttribute("width")),
				Integer.valueOf(xmlElement.getAttribute("height")));

        setLabel(xmlElement.getAttribute("label"));
        setChecked(Boolean.valueOf(xmlElement.getAttribute("checked")).booleanValue());
	}
	
	public void setChecked(boolean checkedState)
    {
		((com.google.gwt.user.client.ui.CheckBox)this.control).setChecked(checkedState);
    }

    public boolean isChecked()
    {
        return ((com.google.gwt.user.client.ui.CheckBox)this.control).isChecked();
    }

    public String getLabel()
    {
        return ((com.google.gwt.user.client.ui.CheckBox)this.control).getText();
    }

    public void setLabel(String label)
    {
   	 ((com.google.gwt.user.client.ui.CheckBox)this.control).setText(label);
    }
    
    
    /* methods for dealing with the EventListener Interfaces */
    public void addClickListener(ClickListener clickListener) {
   	 ((com.google.gwt.user.client.ui.CheckBox)control).addClickListener(clickListener);
    }
    public void removeClickListener(ClickListener clickListener) {
   	 ((com.google.gwt.user.client.ui.CheckBox)control).removeClickListener(clickListener);
    }
    public void addFocusListener(FocusListener focusListener) {
   	 ((com.google.gwt.user.client.ui.CheckBox)control).addFocusListener(focusListener);
    }
    public void removeFocusListener(FocusListener focusListener) {
   	 ((com.google.gwt.user.client.ui.CheckBox)control).removeFocusListener(focusListener);
    }
    
}
