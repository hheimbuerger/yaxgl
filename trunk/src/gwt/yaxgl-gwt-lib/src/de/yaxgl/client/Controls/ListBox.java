package de.yaxgl.client.Controls;

import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.Node;
import com.google.gwt.xml.client.NodeList;

import de.yaxgl.client.Base.Control;
import de.yaxgl.client.Container.Container;
import de.yaxgl.client.EventListener.ClickListener;
import de.yaxgl.client.EventListener.FocusListener;

public class ListBox extends Control {

	public ListBox(Container owner,String ID)
	{
		this.owner=owner;
		this.ID=ID;
		this.control = new com.google.gwt.user.client.ui.ListBox();
		
		control.addStyleName("yaxgl-listbox");
		
		((com.google.gwt.user.client.ui.ListBox)control).setVisibleItemCount(5);
		//TODO implementation of multiple selection
		((com.google.gwt.user.client.ui.ListBox)control).setMultipleSelect(false);
		this.owner.add(this);
	}
	

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
		((com.google.gwt.user.client.ui.ListBox)this.control).addItem(item);
    }

    public void addRange(String[] items) {
    	for (int i = 0; i < items.length; i++) {
			addItem( items[i] );
		}
    }

    public void clearItems()
    {
    	((com.google.gwt.user.client.ui.ListBox)this.control).clear();
    }

    public void select(String selection)
    {
    	com.google.gwt.user.client.ui.ListBox myList = ((com.google.gwt.user.client.ui.ListBox)this.control);
    	for (int i = 0; i < myList.getItemCount(); i++) {
			if (myList.getItemText(i).equals(selection)) {
				myList.setSelectedIndex(i);
				break;
			}
		}
    	
    }

    public String[] getSelectedItems()
    {
    	int selected = ((com.google.gwt.user.client.ui.ListBox)this.control).getSelectedIndex();
    	String[] string = { ((com.google.gwt.user.client.ui.ListBox)this.control).getItemText(selected) };
    	return string;
    }
    
    
    
    /* methods for dealing with the EventListener Interfaces */
    public void addClickListener(ClickListener clickListener) {
   	 ((com.google.gwt.user.client.ui.ListBox)control).addClickListener(clickListener);
    }
    public void removeClickListener(ClickListener clickListener) {
   	 ((com.google.gwt.user.client.ui.ListBox)control).removeClickListener(clickListener);
    }
    public void addFocusListener(FocusListener focusListener) {
   	 ((com.google.gwt.user.client.ui.ListBox)control).addFocusListener(focusListener);
    }
    public void removeFocusListener(FocusListener focusListener) {
   	 ((com.google.gwt.user.client.ui.ListBox)control).removeFocusListener(focusListener);
    }
    
}
