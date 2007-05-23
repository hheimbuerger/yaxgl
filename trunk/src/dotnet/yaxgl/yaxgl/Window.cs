using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;

namespace de.yaxgl
{
    public class Window : Container
    {
       // private Form form=null;

        
        
        public Window(string yaxglFile)
        { 
            this.control = new System.Windows.Forms.Form();
            /*register window events*/
            //form.Click+=new System.EventHandler(form_Click);
            
            /*eventHandlerManager must be intiantiated here before parsing XML
             *because the Group container needs this instance also
             * */
            this.eventHandlerManager = new EventHandlerManager();
            parseXML(yaxglFile);
            initialiceContainer();
        }

        
        
        
        public void show()
        {
            //Application.Run(form);            
            ((Form)this.control).ShowDialog();
        }

        public void hide() 
        {
            ((Form)this.control).Hide();
        }

    }

} // END NAMESPACE
