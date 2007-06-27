package de.yaxgl.Controls;

import org.eclipse.swt.SWT;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import de.yaxgl.Base.*;
import de.yaxgl.Container.*;

public class ListBox extends Control {

	
	public ListBox(Container owner,String ID)
	{
		this.owner=owner;
		this.ID=ID;
		int style=(SWT.MULTI |SWT.BORDER  | SWT.V_SCROLL);
		
		this.control= new org.eclipse.swt.widgets.List((org.eclipse.swt.widgets.Composite)this.owner.getNativeComponent(),style);
		/*register Events*/
		((org.eclipse.swt.widgets.List)this.control).addSelectionListener(clickEvent(this));
		this.control.addFocusListener(focusEvent(this));
		
		
	}
	
	@Override
	public void initializeNativeControl(Element xmlElement) {
		setBounds(Integer.valueOf(xmlElement.getAttribute("xpos")),
				Integer.valueOf(xmlElement.getAttribute("ypos")),
				Integer.valueOf(xmlElement.getAttribute("width")),
				Integer.valueOf(xmlElement.getAttribute("height")));
		
		NodeList nodeList=xmlElement.getChildNodes();
    
		for(int i=0;i<nodeList.getLength();i++)
		{
           if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE)
           {
               Element itemElement = (Element)nodeList.item(i);
               addItem(itemElement.getAttribute("label"));
               if(itemElement.hasAttribute("selected"))
            	   select(itemElement.getAttribute("label"));
           }
       }
      
	}
	
	
	public void addItem(String item)
    {
		((org.eclipse.swt.widgets.List)this.control).add(item);
    }

    public void addRange(String[] items)
    {
    	((org.eclipse.swt.widgets.List)this.control).setItems(items);
    }

    public void clearItems()
    {
    	((org.eclipse.swt.widgets.List)this.control).removeAll();
    }

    public void select(String selection)
    {
    	int index=((org.eclipse.swt.widgets.List)this.control).indexOf(selection);
    	((org.eclipse.swt.widgets.List)this.control).select(index);
    }

    public String[] getSelectedItems()
    {
        return ((org.eclipse.swt.widgets.List)this.control).getSelection();
    }


}
