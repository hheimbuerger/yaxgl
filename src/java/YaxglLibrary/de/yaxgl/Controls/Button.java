/**
 * 
 */
package de.yaxgl.Controls;

import org.w3c.dom.Element;

import org.eclipse.swt.*;
import de.yaxgl.Base.Control;
import de.yaxgl.Container.Container;


public class Button extends Control {

	public Button(Container owner,String ID)
	{
		this.ID=ID;
		this.owner=owner;
		/*thats stress*/
		this.control=new org.eclipse.swt.widgets.Button((org.eclipse.swt.widgets.Composite)owner.getNativeComponent(),SWT.PUSH);
		((org.eclipse.swt.widgets.Button)this.control).addSelectionListener(clickEvent(this));
	}
	
	@Override
	public void initializeNativeControl(Element xmlElement) {
		setBounds(Integer.valueOf(xmlElement.getAttribute("xpos")),
				Integer.valueOf(xmlElement.getAttribute("ypos")),
				Integer.valueOf(xmlElement.getAttribute("width")),
				Integer.valueOf(xmlElement.getAttribute("height")));

        setLabel(xmlElement.getAttribute("label"));
		
	}
	
	public String getLabel()
     {
         return ((org.eclipse.swt.widgets.Button)this.control).getText();
     }

     public void setLabel(String label)
     {
    	 ((org.eclipse.swt.widgets.Button)this.control).setText(label);
     }

}
