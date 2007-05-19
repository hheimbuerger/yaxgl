using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;
using System.Reflection;

namespace YaxglTestLib
{
    public class YaxglButton
    {
        public Button button;
        private System.Collections.ArrayList events=null;
        private Object instance = null;
       
        public YaxglButton()
        {
            button = new Button();
            button.Text = "Drück mich!";
            button.Click += new System.EventHandler(this.button_Click);
        
        }

        public void addEvent(EventType eventType,MethodInfo methodInfo,Object instance)
        {
            this.instance = instance;

            if(events==null)
                events=new System.Collections.ArrayList();
            events.Add(methodInfo);          
        }
        
         private void button_Click(object sender, EventArgs e)
         {
             if (events.Count > 0)
             {
                 MethodInfo m = (MethodInfo)events[0];
                 m.Invoke(instance,null);
             }
         }
    }
}
