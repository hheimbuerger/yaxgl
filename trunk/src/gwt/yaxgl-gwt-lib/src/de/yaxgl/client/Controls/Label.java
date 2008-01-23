package de.yaxgl.client.Controls;

import com.google.gwt.xml.client.Element;

import de.yaxgl.client.Base.Control;
import de.yaxgl.client.Container.Container;
import de.yaxgl.client.EventListener.ClickListener;

public class Label extends Control {

	public Label(Container owner, String ID) {
		this.owner = owner;
		this.ID = ID;
		this.control = new com.google.gwt.user.client.ui.Label();
		
		control.addStyleName("yaxgl-label");
		
		owner.add(this);
	}

	public void initializeNativeControl(Element xmlElement) {

		setBounds(Integer.valueOf(xmlElement.getAttribute("xpos")), Integer
				.valueOf(xmlElement.getAttribute("ypos")), Integer
				.valueOf(xmlElement.getAttribute("width")), Integer
				.valueOf(xmlElement.getAttribute("height")));

		setLabel(xmlElement.getAttribute("label"));

	}

	public String getLabel() {
		return ((com.google.gwt.user.client.ui.Label) this.control).getText();
	}

	public void setLabel(String label) {
		((com.google.gwt.user.client.ui.Label) this.control).setText(label);
	}
	
	
    /* methods for dealing with the EventListener Interfaces */
    public void addClickListener(ClickListener clickListener) {
   	 ((com.google.gwt.user.client.ui.Label)control).addClickListener(clickListener);
    }
    public void removeClickListener(ClickListener clickListener) {
   	 ((com.google.gwt.user.client.ui.Label)control).removeClickListener(clickListener);
    }

    
}
