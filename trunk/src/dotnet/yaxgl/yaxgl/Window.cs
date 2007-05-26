using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;
using System.Xml;

namespace de.yaxgl
{
    public class Window : Container
    {
        /* the EventHandlerManager every Window creates one and the group needs the one of its window*/
        private EventHandlerManager eventHandlerManager = null;
        
        public Window(string xmlfile)
        {
            /*eventHandlerManager must be instanciated here before parsing XML
             *because the Group container needs an reference of his instance also
             * */
            this.eventHandlerManager = new EventHandlerManager();
            this.control = new System.Windows.Forms.Form();
            
            XmlDocument xmlDocument=new XmlDocument();
            
            //TODO: Exception
            xmlDocument.Load(xmlfile);
            XmlElement rootElement=xmlDocument.DocumentElement;
            parseXML(rootElement);

            /*register window events*/
            //form.Click+=new System.EventHandler(form_Click);
            
            initialiceContainer();
        }


        public void registerEventHandlers(Object eventReciever)
        {
            eventHandlerManager.registerEventHandlers(eventReciever);
        }
        
        /* notifys the EventHandlerManager for invoke incomming event from specific component*/
        public override void notifyEvent(Component control, EventArgs eventArgs)
        {
            eventHandlerManager.invokeHandlers(control, eventArgs);
        }
        
        public void show()
        {
            //Application.Run(((Form)this.control));            
            ((Form)this.control).ShowDialog();
        }

        public void hide() 
        {
            ((Form)this.control).Hide();
        }

        /*returns the container title**/
        public string getTitle()
        {
            return this.control.Text;
        }


        /*sets the container title**/
        public void setTitle(string title)
        {
            this.control.Text = title;
        }

    }

} // END NAMESPACE
