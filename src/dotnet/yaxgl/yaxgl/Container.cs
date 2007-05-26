using System;
using System.Collections.Generic;
using System.Text;
using System.Xml;

namespace de.yaxgl
{
    //TODO: welche events sollen die container unterstützen?
    public abstract class Container : Component
    {
        
        /*holder for Containable components*/
        protected IDictionary<string,Containable> components=new Dictionary<string,Containable>();


        public static XmlElement getRootElementFromXmlFile(string filename)
        {
            return null;
        }
        
        
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


        /* parsing the yaxgl xml file, generates from yaxgl xml file yaxgl components
         * and fills the components container
         * */
        protected void parseXML(XmlElement rootElement)
        {
            if (rootElement.Name.Equals("yaxgl:window") || rootElement.Name.Equals("yaxgl:groupbox"))
            {
                this.ID = rootElement.Attributes["id"].InnerText;
                this.setBounds(Convert.ToInt32(rootElement.Attributes["xpos"].InnerText), Convert.ToInt32(rootElement.Attributes["ypos"].InnerText),
                    Convert.ToInt32(rootElement.Attributes["width"].InnerText), Convert.ToInt32(rootElement.Attributes["height"].InnerText));
                ((Window)this).setTitle(rootElement.Attributes["title"].InnerText);
            }
            
            foreach (XmlNode xmlNode in rootElement)
            {
                XmlElement xmlElement;
                if (xmlNode.NodeType == XmlNodeType.Element)
                {
                    xmlElement = (XmlElement)xmlNode;
                    System.Console.WriteLine(xmlElement.Name);

                    Containable newContainable = SimpleComponentFactory.createComponent(this, xmlElement);
                    if(newContainable!=null)
                        components.Add(((Component)newContainable).getID(),newContainable);
                }
            }
         

        }

        
              
        
    }
}

