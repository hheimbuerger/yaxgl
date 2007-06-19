/**
 * 
 */
package de.yaxgl.Container;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import de.yaxgl.*;
import de.yaxgl.Base.*;
import de.yaxgl.EventDispatcher.*;
import de.yaxgl.Helper.*;

public abstract class Container extends Component {
	/* holder for Containable components */
	private Map<String, Containable> components = new Hashtable<String, Containable>();

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
	protected Element validateXmlDocument(String xmlfile) {
		Document xmlDocument = null;
		try {
			// parse an XML document into a DOM tree

			DocumentBuilder parser = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			xmlDocument = parser.parse(new File(xmlfile));

			// create a SchemaFactory capable of understanding WXS schemas
			SchemaFactory factory = SchemaFactory
					.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

			//TODO: pack schemas into jar, and get them back from there
			
			// load a WXS schema, represented by a Schema instance
			Source[] schemaSources = {
					new StreamSource(new File("YAXGL_container.xsd")),
					new StreamSource(new File("YAXGL_window.xsd")),
					new StreamSource(new File("YAXGL_group.xsd")) };

			Schema schema = factory.newSchema(schemaSources);

			// create a Validator instance, which can be used to validate an
			// instance document
			Validator validator = schema.newValidator();

			// validate the DOM tree
			validator.validate(new DOMSource(xmlDocument));

		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e1) {
			
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}

		return xmlDocument.getDocumentElement();
	}

	/*
	 * parsing the yaxgl xml file, generates from yaxgl xml file yaxgl
	 * components and fills the components container
	 */
	protected void parseXML(Element rootElement) {

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
