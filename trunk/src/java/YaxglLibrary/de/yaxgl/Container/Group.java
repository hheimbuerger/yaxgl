
package de.yaxgl.Container;

import org.eclipse.swt.SWT;
import org.w3c.dom.Element;

import de.yaxgl.Base.*;
import de.yaxgl.EventDispatcher.*;
import de.yaxgl.Helper.*;


@SuppressWarnings("serial")
public class Group extends Container implements Containable {

	public Group(String xmlfile,Container owner,String ID)
	{
		this.owner = owner;
		this.ID=ID;
		org.eclipse.swt.widgets.Composite composite=(org.eclipse.swt.widgets.Composite)this.owner.getNativeComponent();                
        this.control = new org.eclipse.swt.widgets.Composite(composite,SWT.NONE); 
        Element rootElement = validateXmlDocument(xmlfile);
        try {
			parseXML(rootElement);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	@Override
	public void initializeNativeControl(Element xmlElement) {
		Location location=new Location(Integer.valueOf(xmlElement.getAttribute("xpos")),Integer.valueOf(xmlElement.getAttribute("ypos")));
        setLocation(location);
       
	}
	
	@Override
	public void notifyEvent(Component control, EventArgs eventArgs) {
		this.owner.notifyEvent(control, eventArgs);
	}
	

	

}
