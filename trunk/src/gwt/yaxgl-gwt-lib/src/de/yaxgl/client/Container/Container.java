/**
 * 
 */
package de.yaxgl.client.Container;


import java.util.HashMap;
import java.util.Map;

import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.Node;
import com.google.gwt.xml.client.NodeList;
import com.google.gwt.xml.client.XMLParser;

import com.google.gwt.user.client.ui.AbsolutePanel;

import de.yaxgl.client.SimpleComponentFactory;
import de.yaxgl.client.Base.Component;
import de.yaxgl.client.Base.Containable;
import de.yaxgl.client.Helper.Location;





public abstract class Container extends Component {
	/* holder for Containable components */
	private Map components = new HashMap(); // <String,Containable>


	public void add(Containable containable) {
		if (containable != null) {
			if (!this.components.containsKey(((Component) containable).getID())) {
				Component newComponent = (Component) containable;
				/* add containable to dictionary components of the container */
				this.components.put(newComponent.getID(), containable);
				/* add native component to native container */
				// I think we dont need this with swt because we dont have this
				// interface to swt
				 ((AbsolutePanel)this.control).add( ((Component)containable).getNativeComponent() );
				 
			}
		}
	}

	public void remove(Containable containable) {
		if (containable != null) {
			if (this.components.containsKey(((Component) containable).getID())) {
				/* remove native control from native container */
				((com.google.gwt.user.client.ui.Widget) ((Component) containable).getNativeComponent()).removeFromParent();
				/*
				 * remove conatinable from dictionary container of our
				 * WidgetContainables
				 */
				this.components.remove(((Component) containable).getID());
			}
		}
	}

	/*
	 * returns the de.yaxgl component by given string ID
	 */
	public Component getComponentById(String ID) {
		if (this.components.containsKey(ID))
			return (Component) this.components.get(ID);
		else
			return null;
	}

	/*
	 * validates the xmlFile against the schemaFile and returns the root element
	 * on success
	 */
	//TODO: validierung
	protected Element validateXmlDocument(String xmlfile) {
			Document xmlDocument = XMLParser.parse(xmlfile);
			return xmlDocument.getDocumentElement();
	}

	/*
	 * parsing the yaxgl xml file, generates from yaxgl xml file yaxgl
	 * components and fills the components container
	 */
	public void parseXML(Element rootElement) {

		//TODO: get the LocalName and check if its equals the element and check for the uri
		/* set container options from xml atributes here */
		if (rootElement.getNodeName().equals("yaxgl:window")) {
			initializeNativeControl(rootElement);
		} else if (rootElement.getNodeName().equals("yaxgl:group")) {
			// at the moment I can't see a reason to set the dimension HERE
			// I put this in method: Group.initializeNativeControl()
//			Dimension dimension = new Dimension(Integer.valueOf(rootElement
//					.getAttribute("width")).intValue(), Integer.valueOf(rootElement
//					.getAttribute("height")).intValue());
//			this.setDimension(dimension);
		}

		/*
		 * go through all child elements create them and add them to the
		 * container
		 */
		NodeList childNodes = rootElement.getChildNodes();

		for (int i = 0; i < childNodes.getLength(); i++) {
			Element xmlElement;
			if (childNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
				xmlElement = (Element) childNodes.item(i);
				add(SimpleComponentFactory.createComponent(this, xmlElement));
			}

		}
	}
	
	
	// ADD in GWT
	// this function is required, because the position of a widget can only be set over the parent widget
	public void setChildLocation(Location location, Component component) {
		if (component != null) {
			if (this.components.containsKey((component).getID())) {
				// set child position
				((com.google.gwt.user.client.ui.AbsolutePanel)this.control).add(component.getNativeComponent(), location.getX(), location.getY());
			}
		}
		
	}

	

}
