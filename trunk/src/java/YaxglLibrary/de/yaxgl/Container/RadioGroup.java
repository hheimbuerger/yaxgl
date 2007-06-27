package de.yaxgl.Container;

import org.eclipse.swt.SWT;
import org.w3c.dom.Element;

import de.yaxgl.Base.Component;
import de.yaxgl.Base.Containable;
import de.yaxgl.Controls.RadioButton;
import de.yaxgl.EventDispatcher.EventArgs;

@SuppressWarnings("serial")
public class RadioGroup extends Container implements Containable{

	public RadioGroup(Element rootElement,Container owner,String ID)
	{
		this.owner = owner;
		this.ID=ID;
		org.eclipse.swt.widgets.Composite composite=(org.eclipse.swt.widgets.Composite)this.owner.getNativeComponent();                
        this.control = new org.eclipse.swt.widgets.Composite(composite,SWT.NONE); 
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
		
		check(xmlElement.getAttribute("checked"));
	}
	
	@Override
	public void notifyEvent(Component control, EventArgs eventArgs) {
		this.owner.notifyEvent(control, eventArgs);
	}
	
	public void check(String radioButtonId)
    {
		if (components.containsKey(radioButtonId))
            ((RadioButton)components.get(radioButtonId)).setChecked(true);
    }

    public RadioButton getCheckedRadioButton()
    {
        RadioButton retVal=null;
        
        for(Containable radio :  components.values())
        {
            if (((RadioButton)radio).isChecked())
                retVal=(RadioButton)radio;  
        }
        return retVal;
    }
	

}
