package de.yaxgl.Controls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.w3c.dom.Element;

import de.yaxgl.Base.Control;
import de.yaxgl.Container.Container;

public class Label extends Control {

	public Label(Container owner,String ID)
	{
		this.owner=owner;
		this.ID=ID;	
	
		Composite composite=(org.eclipse.swt.widgets.Composite)this.owner.getNativeComponent();
		this.control=new org.eclipse.swt.widgets.Label(composite,SWT.NONE);
		
		//TODO:Label no click event in swt
		
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
        return ((org.eclipse.swt.widgets.Label)this.control).getText();
    }

    public void setLabel(String label)
    {
    	((org.eclipse.swt.widgets.Label)this.control).setText(label);
    }
}
