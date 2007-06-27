package de.yaxgl.Controls;

import org.eclipse.swt.SWT;
import org.w3c.dom.Element;

import de.yaxgl.Base.Control;
import de.yaxgl.Container.Container;

public class TextBox extends Control {

	public TextBox(Container owner,String ID)
	{
		this.owner=owner;
		this.ID=ID;
//		| SWT.H_SCROLL means horizontal sroll bar
		int style=(SWT.MULTI |SWT.BORDER  | SWT.V_SCROLL);
		
		this.control=new org.eclipse.swt.widgets.Text((org.eclipse.swt.widgets.Composite)owner.getNativeComponent(),style);
		
		/*register Events*/
		((org.eclipse.swt.widgets.Text)this.control).addSelectionListener(clickEvent(this));
		this.control.addFocusListener(focusEvent(this));

	}
	
	
	@Override
	public void initializeNativeControl(Element xmlElement) {
		
		setBounds(Integer.valueOf(xmlElement.getAttribute("xpos")),
				Integer.valueOf(xmlElement.getAttribute("ypos")),
				Integer.valueOf(xmlElement.getAttribute("width")),
				Integer.valueOf(xmlElement.getAttribute("height")));
		
		 setText(xmlElement.getAttribute("text"));
         setMaxLength(Integer.valueOf(xmlElement.getAttribute("maxlength")));
	}
	
	public void setText(String text)
    {
    	((org.eclipse.swt.widgets.Text)this.control).setText(text);
    }

    public String getText()
    {
        return ((org.eclipse.swt.widgets.Text)this.control).getText();
    }
    
    public void setMaxLength(int length) 
    {
    	((org.eclipse.swt.widgets.Text)this.control).setTextLimit(length);
    }

    public int getMaxLength()
    {
    	return ((org.eclipse.swt.widgets.Text)this.control).getTextLimit();
    }
}
