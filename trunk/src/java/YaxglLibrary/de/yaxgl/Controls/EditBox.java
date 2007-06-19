package de.yaxgl.Controls;

import org.eclipse.swt.SWT;
import org.w3c.dom.Element;

import de.yaxgl.Base.Control;
import de.yaxgl.Container.Container;

public class EditBox extends Control {

	
	public EditBox(Container owner,String ID)
	{
		this.owner=owner;
		this.ID=ID;
		
	}
	
	@Override
	public void initializeNativeControl(Element xmlElement) {
		//styles CENTER, LEFT, MULTI, PASSWORD, SINGLE, RIGHT, READ_ONLY, WRAP 
		int style=(SWT.SINGLE|SWT.BORDER);
		this.control=new org.eclipse.swt.widgets.Text((org.eclipse.swt.widgets.Composite)owner.getNativeComponent(),style);
		
		/*register Events*/
		((org.eclipse.swt.widgets.Text)this.control).addSelectionListener(clickEvent(this));
		this.control.addFocusListener(focusEvent(this));
		
		/* interesting
		 * addModifyListener(ModifyListener listener) 
          Adds the listener to the collection of listeners who will be notified when the receiver's text is modified, by sending it one of the messages defined in the ModifyListener interface. 
 void addSelectionListener(SelectionListener listener) 
          Adds the listener to the collection of listeners who will be notified when the control is selected, by sending it one of the messages defined in the SelectionListener interface.  
 void addVerifyListener(VerifyListener listener) 
          Adds the listener to the collection of listeners who will be notified when the receiver's text is verified, by sending it one of the messages defined in the VerifyListener interface. 

		 */
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
