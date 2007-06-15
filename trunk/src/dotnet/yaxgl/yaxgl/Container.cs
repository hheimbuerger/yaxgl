using System;
using System.Collections.Generic;
using System.Text;
using System.Xml;
using System.Xml.Schema;
using System.IO;

namespace de.yaxgl
{
    //TODO: welche events sollen die container unterstützen?
    public abstract class Container : Component
    {
        
        /*holder for Containable components*/
        protected IDictionary<string,Containable> components=new Dictionary<string,Containable>();

        
        /* notifys the EventHandlerManager for invoke incomming event from specific component or container*/
        public abstract void notifyEvent(Component control, EventArgs eventArgs);
        

        /*iterates over all Containables and adds the specific base controlls to the specific container**/
        protected void initialiceContainer()
        {
            foreach (KeyValuePair<string,Containable> containable in components)
            {
                this.control.Controls.Add(((Component)containable.Value).getNativeComponent());
            }
        }

        
        /* returns the de.yaxgl component by given string ID  
         **/
        public Component getComponentById(string ID)
        {
            if (this.components.ContainsKey(ID))
                return (Component)this.components[ID];
            else return null;
        }

        /* validates the xmlFile against the schamFile and returns the root element on success
         **/
        protected XmlElement validateXmlDocument(string urn, string schemafile,string xmlfile)
        {
            // Create the XmlSchemaSet class.
            XmlSchemaSet xmlSchemaSet = new XmlSchemaSet();

            // Add the schema to the collection.
            xmlSchemaSet.Add(urn, schemafile);

            // Set the validation settings.
            XmlReaderSettings settings = new XmlReaderSettings();
            settings.ValidationType = ValidationType.Schema;
            settings.Schemas = xmlSchemaSet;
            
            XmlDocument doc = new XmlDocument();
            try
            {
                // Create the XmlReader object.
                XmlReader reader = XmlReader.Create(xmlfile, settings);
                doc.Load(reader);
            }
            catch (XmlSchemaValidationException e)
            {
                throw new XmlSchemaValidationException("Validation Error: "+ e.Message,e);
            }
            catch (FileNotFoundException ex)
            {
                throw new FileNotFoundException("File not found Error: {0}", ex.Message);
            }

            return doc.DocumentElement;
        }
        
        

        /* parsing the yaxgl xml file, generates from yaxgl xml file yaxgl components
         * and fills the components container
         * */
        protected void parseXML(XmlElement rootElement)
        {
            
            /*set container options from cml atributes here*/
            if (rootElement.Name.Equals("yaxgl:window"))
            {
                this.ID = rootElement.Attributes["id"].InnerText;
                this.setBounds(Convert.ToInt32(rootElement.Attributes["xpos"].InnerText), Convert.ToInt32(rootElement.Attributes["ypos"].InnerText),
                    Convert.ToInt32(rootElement.Attributes["width"].InnerText), Convert.ToInt32(rootElement.Attributes["height"].InnerText));
                ((Window)this).setTitle(rootElement.Attributes["title"].InnerText);
            }
            else if (rootElement.Name.Equals("yaxgl:group"))
            { 
                Dimension dimension=new Dimension(Convert.ToInt32(rootElement.Attributes["width"].InnerText),
                    Convert.ToInt32(rootElement.Attributes["height"].InnerText));
                this.setDimension(dimension);
            }
            
            /*go through all child elements create them and add them to the container*/
            foreach (XmlNode xmlNode in rootElement.ChildNodes)
            {
                XmlElement xmlElement;
                if (xmlNode.NodeType == XmlNodeType.Element)
                {
                    xmlElement = (XmlElement)xmlNode;
                    
                    Containable newContainable = SimpleComponentFactory.createComponent(this, xmlElement);
                    if(newContainable!=null)
                        components.Add(((Component)newContainable).getID(),newContainable);
                }
            }
        }
    }
}

