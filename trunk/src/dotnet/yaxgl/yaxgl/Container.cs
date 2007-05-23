using System;
using System.Collections.Generic;
using System.Text;
using System.Collections;
using System.Xml;

namespace de.yaxgl
{
    //TODO: welche events sollen die container unterstützen?

    
    public abstract class Container : Component
    {
        /* the EventHandlerManager every Window creates one and the group needs the one of its window*/
        protected EventHandlerManager eventHandlerManager = null;
        
        /*holder for Containable components*/
        protected IList<Containable> components=new List<Containable>();

        /* notifys the EventHandlerManager for invoke incomming event from specific component*/
        public void notifyEvent(Control control, EventArgs eventArgs)
        {
            eventHandlerManager.invokeHandlers(control, eventArgs);
        }


        public void registerEventHandlers(Object eventReciever)
        {
            eventHandlerManager.registerEventHandlers(eventReciever);
        }

        protected EventHandlerManager getEventHandlerManager()
        {
            return this.eventHandlerManager;
        }

        protected void setEventHandlerManager(EventHandlerManager eventHandlerManager)
        {
            this.eventHandlerManager = eventHandlerManager;
        }

        /*iterates over all Containables and adds the specific base controlls to the specific container**/
        protected void initialiceContainer()
        {
            foreach (Containable containable in components)
            {
                this.control.Controls.Add(containable.getBaseControl());
            }
        }
        
        
        /* returns the de.yaxgl component by given string ID  
         **/
        public Component getComponentById(string ID)
        {
            Component retVal=null;
            foreach (Containable containable in components)
            {
              
                if (((Component)containable).getID() == ID)
                    retVal = (Component)containable;    
    
            }
            return retVal;
        }


        /* parsing the yaxgl xml file, generates from yaxgl xml file yaxgl components
         * and fills the components container
         * */
        protected void parseXML(string filename)
        {
            /*test setting window title*/
            this.setTitle("Testanwendung");
            this.setBounds(300, 300, 600, 600);
            /*test button*/
            Button b = new Button(this, "Button1");
            b.setBounds(50, 50, 100, 20);
            b.setLabel("Hallo");
            components.Add(b);

            /*test Label*/
            Label l = new Label(this, "Label1");
            l.setBounds(50, 80, 130, 20);
            l.setLabel("Ich bin ein clickbares Label");
            components.Add(l);
            
            /*test Checkbox*/
            CheckBox cb1=new CheckBox(this,"CheckBox1");
            cb1.setBounds(300, 50, 60, 20);
            cb1.setLabel("Male");
            components.Add(cb1);
            CheckBox cb2 = new CheckBox(this, "CheckBox2");
            cb2.setBounds(300, 70, 60, 20);
            cb2.setLabel("Female");
            cb2.setChecked(true);
            components.Add(cb2);

            EditBox editBox = new EditBox(this, "editBox");
            editBox.setBounds(50, 120, 100, 60);
            editBox.setMaxLength(160);
            editBox.setMultiline(true);
            components.Add(editBox);


            EditBox editBox1 = new EditBox(this, "editBox1");
            editBox1.setBounds(300, 120, 100, 60);
            editBox1.setMaxLength(10);
            components.Add(editBox1);


            Group group = new Group(this, "group1");
            //TODO: kritisch unschön vielleicht besser wenn gruop einen eigenen EventHandlerManager bekommt?
            //nein geht nicht weil dann müsst ja der eventReciever irgendwo im EventHandlerManager gehalten werden
            //und in der group registriert werden mhhhhh?
            if (this.getEventHandlerManager() == null) System.Console.WriteLine("Nnnnnnnndsbfhebbhb");
            group.setEventHandlerManager(this.getEventHandlerManager());
            group.setBounds(50, 200,300, 100);
            group.setBorder(true);
            components.Add(group);
            
            //XmlDocument yaxglDoc = new XmlDocument();

            //yaxglDoc.LoadXml(filename);
            //TODO: whats this?
            //yaxglDoc.Validate(...)
            //Parse xml here

        }


        protected void parseXMLG(string filename)
        {
            

            
            /*test Label*/
            Label l = new Label(this, "LabelGroup");
            l.setBounds(0,0, 130, 20);
            l.setLabel("Willst du mit mir gehen?");
            components.Add(l);

            RadioButton radio1 = new RadioButton(this, "radio1");
            radio1.setLabel("Ja");
            radio1.setBounds(1, 25, 100, 20);
            radio1.setChecked(true);
            components.Add(radio1);

            RadioButton radio2 = new RadioButton(this, "radio2");
            radio2.setLabel("Nein");
            radio2.setBounds(1, 45, 100, 20);
            components.Add(radio2);

            RadioButton radio3 = new RadioButton(this, "radio3");
            radio3.setLabel("Vielleicht");
            radio3.setBounds(1, 65, 100, 20);
            components.Add(radio3);


            //XmlDocument yaxglDoc = new XmlDocument();

            //yaxglDoc.LoadXml(filename);
            //TODO: whats this?
            //yaxglDoc.Validate(...)
            //Parse xml here

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
}

