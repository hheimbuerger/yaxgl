/**
 * 
 */
package de.yaxgl.Container;



import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import de.yaxgl.SimpleComponentFactory;
import de.yaxgl.Base.Component;
import de.yaxgl.Base.Containable;
import de.yaxgl.EventDispatcher.EventArgs;
import de.yaxgl.Helper.Dimension;

public abstract class Container extends Component {
	/* holder for Containable components */
	protected Map<String, Containable> components = new Hashtable<String, Containable>();

	/*
	 * notifys the EventHandlerManager for invoke incomming event from specific
	 * component or container
	 */
	public abstract void notifyEvent(Component control, EventArgs eventArgs);

	public void add(Containable containable) {
		if (containable != null) {
			if (!this.components.containsKey(((Component) containable).getID())) {
				Component newComponent = (Component) containable;
				/* add containable to dictionary components of the container */
				this.components.put(newComponent.getID(), containable);
				/* add native component to native container */
				// I think we dont need this with swt because we dont have this
				// interface to swt
				// this.control.Controls.Add((System.Windows.Forms.Control)((Component)containable).getNativeComponent());
			}
		}
	}

	public void remove(Containable containable) {
		if (containable != null) {
			if (this.components.containsKey(((Component) containable).getID())) {
				/* remove native control from native caontainer */
				((org.eclipse.swt.widgets.Control) ((Component) containable)
						.getNativeComponent()).dispose();
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
	protected Element validateXmlDocument(String xmlfile){
			Document xmlDocument = null;
			DocumentBuilder builder=null;
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true);
			
			try {
				builder = factory.newDocumentBuilder();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				xmlDocument=builder.parse(new File(xmlfile));
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			/*
			try{
			
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			
			// create a SchemaFactory capable of understanding WXS schemas
			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			
			Source[] schemaSources ={
					new StreamSource(getClass().getResourceAsStream("..\\XSDs\\YAXGL_window.xsd")),
					new StreamSource(getClass().getResourceAsStream("..\\XSDs\\YAXGL_container.xsd")),
					new StreamSource(getClass().getResourceAsStream("..\\XSDs\\YAXGL_group.xsd")) 
					};
			
			Schema schema = schemaFactory.newSchema(schemaSources);
			factory.setSchema(schema);
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			xmlDocument=builder.parse(new File(xmlfile));

		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
			 */
			return xmlDocument.getDocumentElement();
	}

	/*
	 * parsing the yaxgl xml file, generates from yaxgl xml file yaxgl
	 * components and fills the components container
	 */
	protected void parseXML(Element rootElement) throws Exception {

		//TODO: get the LocalName and check if its equals the element and check for the uri
		/* set container options from xml atributes here */
		if (rootElement.getLocalName().equals("window")) {
			initializeNativeControl(rootElement);
		} else if (rootElement.getLocalName().equals("group")) {
			Dimension dimension = new Dimension(Integer.valueOf(rootElement
					.getAttribute("width")), Integer.valueOf(rootElement
					.getAttribute("height")));
			this.setDimension(dimension);
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

}
