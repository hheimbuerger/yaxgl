package de.yaxgl.client.Controls;



import com.google.gwt.xml.client.Element;

import de.yaxgl.client.Base.Control;
import de.yaxgl.client.Container.Container;

public class ImageBox extends Control {

	public ImageBox(Container owner,String ID)
	{
		this.owner=owner;
		this.ID=ID;
		this.control = new com.google.gwt.user.client.ui.Image();
		
		control.addStyleName("yaxgl-imagebox");
		
		this.owner.add(this);
	}
	

	public void initializeNativeControl(Element xmlElement) {
		
		setBounds(Integer.valueOf(xmlElement.getAttribute("xpos")),
				Integer.valueOf(xmlElement.getAttribute("ypos")),
				Integer.valueOf(xmlElement.getAttribute("width")),
				Integer.valueOf(xmlElement.getAttribute("height")));
		
		loadImage(xmlElement.getAttribute("source"));
		
	}
	
	public void loadImage(String fileImage)
    {
		((com.google.gwt.user.client.ui.Image)this.control).setUrl(fileImage);
    }
}
