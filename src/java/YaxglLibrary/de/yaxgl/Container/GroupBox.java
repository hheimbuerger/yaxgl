package de.yaxgl.Container;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.w3c.dom.Element;

import de.yaxgl.Base.Component;
import de.yaxgl.Base.Containable;
import de.yaxgl.EventDispatcher.EventArgs;

@SuppressWarnings("serial")
public class GroupBox extends Container implements Containable{

	public GroupBox(Element rootElement,Container owner,String ID)
	{
		this.owner=owner;
		this.ID=ID;
		
		int style=SWT.NONE;
		Composite composite=(Composite)this.owner.getNativeComponent();
		this.control= new org.eclipse.swt.widgets.Group(composite,style);
		try {
			parseXML(rootElement);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void initializeNativeControl(Element xmlElement) {
				
		setBounds(Integer.valueOf(xmlElement.getAttribute("xpos")),
				Integer.valueOf(xmlElement.getAttribute("ypos")),
				Integer.valueOf(xmlElement.getAttribute("width")),
				Integer.valueOf(xmlElement.getAttribute("height")));
		
		setTitle(xmlElement.getAttribute("title"));
		
	}
	
	
	@Override
	public void notifyEvent(Component control, EventArgs eventArgs) {
		this.owner.notifyEvent(control, eventArgs);
	}

	/*returns the container title**/
    public String getTitle()
    {
        return ((org.eclipse.swt.widgets.Group)this.control).getText();
    }

    /*sets the container title**/
    public void setTitle(String title)
    {
    	((org.eclipse.swt.widgets.Group)this.control).setText(title);
    }

}
