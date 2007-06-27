package de.yaxgl.Controls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import de.yaxgl.Base.Control;
import de.yaxgl.Container.Container;

public class ComboBox extends Control {

	public ComboBox(Container owner,String ID)
	{
		this.owner=owner;
		this.ID=ID;
		Composite composite=(org.eclipse.swt.widgets.Composite) this.owner.getNativeComponent();
		//other styles SIMPLE,DROP_DOWN
		this.control=new org.eclipse.swt.widgets.Combo(composite,SWT.READ_ONLY);
		/*register events*/
		((org.eclipse.swt.widgets.Combo)this.control).addSelectionListener(selectionChangedEvent(this));
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
           }
       }

       if (xmlElement.hasAttribute("selected"))
           select(xmlElement.getAttribute("selected"));	
	}

	
	public void addItem(String item)
    {
		((org.eclipse.swt.widgets.Combo)this.control).add(item);
    }

    public void addRange(String[] items) {
    	((org.eclipse.swt.widgets.Combo)this.control).setItems(items);
    }

    public void clearItems()
    {
    	((org.eclipse.swt.widgets.Combo)this.control).removeAll();
    }
    
    public void select(String selection)
    {
    	int index=((org.eclipse.swt.widgets.Combo)this.control).indexOf(selection);
    	((org.eclipse.swt.widgets.Combo)this.control).select(index);
    }
    
    public String getSelectedItem()
    {
    	int selected=((org.eclipse.swt.widgets.Combo)this.control).getSelectionIndex();
    	return ((org.eclipse.swt.widgets.Combo)this.control).getItem(selected);
    }

}
