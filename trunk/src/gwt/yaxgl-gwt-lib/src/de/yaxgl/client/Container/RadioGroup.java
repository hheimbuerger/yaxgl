package de.yaxgl.client.Container;

import com.google.gwt.xml.client.Element;

import de.yaxgl.client.Base.Containable;


public class RadioGroup extends Container implements Containable {

	public RadioGroup(Container owner, String ID) {
		this.owner = owner;
		this.ID = ID;
//		this.control = owner.getNativeComponent();
		this.control = new com.google.gwt.user.client.ui.AbsolutePanel();
		
		((com.google.gwt.user.client.ui.AbsolutePanel)control).addStyleName("yaxgl-radiogroup");
		
		owner.add(this);
	}

	public void initializeNativeControl(Element xmlElement) {
		
		setBounds(Integer.valueOf(xmlElement.getAttribute("xpos")), Integer
				.valueOf(xmlElement.getAttribute("ypos")), Integer
				.valueOf(xmlElement.getAttribute("width")), Integer
				.valueOf(xmlElement.getAttribute("height")));

	}

}
