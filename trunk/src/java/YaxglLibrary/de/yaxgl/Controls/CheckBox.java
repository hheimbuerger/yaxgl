package de.yaxgl.Controls;

import org.eclipse.swt.SWT;
import org.w3c.dom.Element;

import de.yaxgl.Base.Control;
import de.yaxgl.Container.Container;

public class CheckBox extends Control {

	public CheckBox(Container owner,String ID)
	{
		this.owner=owner;
		this.ID=ID;
		
	}
	
	
	@Override
	public void initializeNativeControl(Element xmlElement) {
		this.control=new org.eclipse.swt.widgets.Button((org.eclipse.swt.widgets.Composite)owner.getNativeComponent(),SWT.CHECK);
		
		/*register Events*/
		((org.eclipse.swt.widgets.Button)this.control).addSelectionListener(clickEvent(this));
		this.control.addFocusListener(focusEvent(this));
		
		setBounds(Integer.valueOf(xmlElement.getAttribute("xpos")),
				Integer.valueOf(xmlElement.getAttribute("ypos")),
				Integer.valueOf(xmlElement.getAttribute("width")),
				Integer.valueOf(xmlElement.getAttribute("height")));

        setLabel(xmlElement.getAttribute("label"));
        setChecked(Boolean.valueOf(xmlElement.getAttribute("checked")));
	}
	
	public void setChecked(boolean checkedState)
    {
		((org.eclipse.swt.widgets.Button)this.control).setSelection(checkedState);
    }

    public boolean isChecked()
    {
        return ((org.eclipse.swt.widgets.Button)this.control).getSelection();
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
