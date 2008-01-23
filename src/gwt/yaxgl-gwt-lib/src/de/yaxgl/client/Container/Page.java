
package de.yaxgl.client.Container;

import com.google.gwt.xml.client.Element;

import de.yaxgl.client.Base.Containable;



public class Page extends Container implements Containable {
	
	private boolean showNavigation = false;
	
	public Page(Container owner, String ID) {
		this.owner = owner;
		this.ID = ID;
		this.control = new com.google.gwt.user.client.ui.AbsolutePanel();
		
		((com.google.gwt.user.client.ui.AbsolutePanel)control).addStyleName("yaxgl-page");
		
		owner.add(this);
	}

	public void initializeNativeControl(Element xmlElement) {
		
		setBounds(Integer.valueOf(xmlElement.getAttribute("xpos")), Integer
				.valueOf(xmlElement.getAttribute("ypos")), Integer
				.valueOf(xmlElement.getAttribute("width")), Integer
				.valueOf(xmlElement.getAttribute("height")));
		
		showNavigation = Boolean.valueOf( xmlElement.getAttribute("showNavigation") ).booleanValue();
		
		setPageVisible(false);

	}
	
	public void setPageVisible(boolean visible) {
		this.control.setVisible(visible);
	}
	
	public boolean isPageWithNavigation() {
		return showNavigation;
	}
	

}
