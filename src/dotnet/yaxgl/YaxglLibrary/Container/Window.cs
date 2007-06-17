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
            /*on creation a Window has no owner*/
            this.owner = null;
            /*eventHandlerManager must be instanciated here before parsing XML
             *because the Group container needs an reference of his instance also
             * */
            this.eventHandlerManager = new EventHandlerManager();
            this.control = new System.Windows.Forms.Form();

            XmlElement rootElement = validateXmlDocument(@"http://www.yaxgl.de/schema/yaxgl/1.0/", @"http://www.yaxgl.de/schema/yaxgl/1.0/YAXGL_window.xsd", xmlfile);
            parseXML(rootElement);

            //Form f = new Form();
            
            /*register window events*/
            //form.Click+=new System.EventHandler(form_Click);
        }

        public override void initializeNativeControl(XmlElement xmlElement)
        {
            this.ID = xmlElement.Attributes["id"].InnerText;
            setBounds(Convert.ToInt32(xmlElement.Attributes["xpos"].InnerText), 
                      Convert.ToInt32(xmlElement.Attributes["ypos"].InnerText),
                      Convert.ToInt32(xmlElement.Attributes["width"].InnerText), 
                      Convert.ToInt32(xmlElement.Attributes["height"].InnerText));
            setTitle(xmlElement.Attributes["title"].InnerText);
            setIcon(xmlElement.Attributes["icon"].InnerText);
            minimizeable(Boolean.Parse(xmlElement.Attributes["minimizeBox"].InnerText));
            maximizeable(Boolean.Parse(xmlElement.Attributes["maximizeBox"].InnerText));
            showInTaskbar(Boolean.Parse(xmlElement.Attributes["showInTaskbar"].InnerText));

            string style = xmlElement.Attributes["borderStyle"].InnerText;

            if (style == "fixed")
                setBorderStyle(WindowStyle.Fixed);
            else if (style == "none")
                setBorderStyle(WindowStyle.None);
            else 
                setBorderStyle(WindowStyle.Sizeable);
        }


        public void registerEventHandlers(Object eventReciever)
        {
            if(eventReciever!=null)
                eventHandlerManager.registerEventHandlers(eventReciever);
        }
        
        /* notifys the EventHandlerManager for invoke incomming event from specific component*/
        public override void notifyEvent(Component control, EventArgs eventArgs)
        {
            eventHandlerManager.invokeHandlers(control, eventArgs);
        }

        public void showInTaskbar(bool show)
        {
            ((Form)this.control).ShowInTaskbar = show;
        }

        public void setBorderStyle(WindowStyle windowStyle)
        {
            Form thisForm = (Form)this.control;
            switch (windowStyle)
            { 
                case WindowStyle.Fixed:
                    thisForm.FormBorderStyle = FormBorderStyle.FixedSingle;
                    break;
                case WindowStyle.None:
                    thisForm.FormBorderStyle = FormBorderStyle.None;
                    break;
                case WindowStyle.Sizeable:
                    thisForm.FormBorderStyle = FormBorderStyle.Sizable;
                    break;
            }
        
        }
        
        public void minimizeable(bool minimize)
        {
            ((Form)this.control).MinimizeBox = minimize;
        }

        public void maximizeable(bool maximize)
        {
            ((Form)this.control).MaximizeBox = maximize;
        }


        public void setIcon(string icon)
        {
            ((Form)this.control).Icon = new System.Drawing.Icon(icon);
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

        public void show()
        {
            //Application.Run(((Form)this.control));            
            //((Form)this.control).Show();
            this.control.Show();
        }

        /*if parentWindow is null the parent of this window is automatically the window below*/
        public void showDialog(Window parentWindow)
        {
            if (parentWindow != null)
            {
                this.owner = parentWindow;
                ((Form)this.control).ShowDialog(parentWindow.control);
            }
            else
                ((Form)this.control).ShowDialog();
        }
        
        
        public void hide()
        {
            ((Form)this.control).Hide();
        }

        public void close()
        {
            ((Form)this.control).Close(); 
        }
    
    
    }

} // END NAMESPACE
