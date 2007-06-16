using System;
using System.Collections.Generic;
using System.Text;
using System.Xml;
using System.Xml.Schema;
using System.IO;
using System.Reflection;
using System.Net;

namespace de.yaxgl
{
    /*
    class MyXmlResolver : XmlResolver
    {
        private XmlSchemaSet schemaSet;

        public MyXmlResolver(XmlSchemaSet schemaSet)
        {
            this.schemaSet = schemaSet;
            Credentials = null;
        }

        public override ICredentials Credentials { set { } }

        public override Object GetEntity(Uri absoluteUri, string role, Type ofObjectToReturn)
        {
            Console.WriteLine("absoluteUri: " + absoluteUri.ToString());
            return (null);

        }

        public override Uri ResolveUri(Uri baseUri, string relativeUri)
        {
            Console.WriteLine("baseUri: " + baseUri.ToString());
            Console.WriteLine("relativeUri: " + relativeUri.ToString());
            return (null);
        }

    }
     */

    //TODO: welche events sollen die container unterstützen?
    public abstract class Container : Component
    {
        
        /*holder for Containable components*/
        protected IDictionary<string,Containable> components=new Dictionary<string,Containable>();

        
        /* notifys the EventHandlerManager for invoke incomming event from specific component or container*/
        public abstract void notifyEvent(Component control, EventArgs eventArgs);
        

        /*iterates over all Containables and adds the specific base controlls to the specific container**/
        protected void initializeContainer()
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

        public static void validationEventHandler(
                Object sender,
                ValidationEventArgs e
            )
        {
            throw new XmlSchemaValidationException("Schema validation failed.", e.Exception);
        }

        /* validates the xmlFile against the schemaFile and returns the root element on success
         **/
        protected XmlElement validateXmlDocument(string urn, string schemafile,string xmlfile)
        {
            // Create the XmlSchemaSet class.
//            XmlSchemaSet xmlSchemaSet = new XmlSchemaSet();

            // Add the schema to the collection.
            //xmlSchemaSet.Add(urn, schemafile);

            // Set the validation settings.
            XmlReaderSettings settings = new XmlReaderSettings();
            settings.ValidationType = ValidationType.Schema;
            settings.XmlResolver = null; // new MyXmlResolver(null); was macht das ding

            // Add the schemas.
            string[] schemas = { "YAXGL_container.xsd", "YAXGL_window.xsd", "YAXGL_group.xsd" };
            foreach (string schemaName in schemas)
            {
                Stream schemaStream = Assembly.GetExecutingAssembly().GetManifestResourceStream("de.yaxgl.XSDs." + schemaName);
                XmlSchema xmlSchema = XmlSchema.Read(schemaStream, validationEventHandler);
                settings.Schemas.Add(xmlSchema);
            }
            /*
            Stream containerSchemaStream = Assembly.GetExecutingAssembly().GetManifestResourceStream("de.yaxgl.XSDs.YAXGL_container.xsd");
            Stream windowSchemaStream = Assembly.GetExecutingAssembly().GetManifestResourceStream("de.yaxgl.XSDs.YAXGL_window.xsd");
            Stream groupSchemaStream = Assembly.GetExecutingAssembly().GetManifestResourceStream("de.yaxgl.XSDs.YAXGL_group.xsd");
            //Stream stream = Assembly.GetExecutingAssembly().GetManifestResourceStream("YAXGL_window");
            XmlSchema xmlSchema = XmlSchema.Read(stream, validationEventHandler);
            xmlSchemaSet.Add(xmlSchema);
             */


            XmlDocument doc = new XmlDocument();
            XmlReader reader = XmlReader.Create(xmlfile, settings);
                doc.Load(reader);
            //}
            //catch (XmlSchemaValidationException e)
            //{
            //    throw new XmlSchemaValidationException("Validation Error: "+ e.Message,e);
            //}
            //catch (FileNotFoundException ex)
            //{
            //    throw new FileNotFoundException("File not found Error: {0}", ex.Message);
            //}

            return doc.DocumentElement;
        }
        
        

        /* parsing the yaxgl xml file, generates from yaxgl xml file yaxgl components
         * and fills the components container
         * */
        protected void parseXML(XmlElement rootElement)
        {
            
            /*set container options from xml atributes here*/
            if (rootElement.LocalName.Equals("window"))
            {
                this.initializeNativeControl(rootElement);
            }
            else if (rootElement.LocalName.Equals("group"))
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

