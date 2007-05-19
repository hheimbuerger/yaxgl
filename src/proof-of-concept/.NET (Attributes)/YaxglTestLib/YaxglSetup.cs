using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;
using System.Xml;
using System.Reflection;

namespace YaxglTestLib
{
    public class YaxglSetup
    {
        Form1 f1;
        private Object eventHandlerClassType;

        public YaxglSetup(string fileName,Object t)
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            this.eventHandlerClassType = t;
            parseXML(fileName);
        }

        public void show()
        {

           
            Application.Run(f1);
            
            
            //f1.Show();
            
        
        }

        private void parseXML(string fileName) {
            XmlDocument xmlDoc=null;
			XmlNodeList xmlNL=null;
			xmlDoc=new XmlDocument();
 
			string sPath=System.Windows.Forms.Application.StartupPath;
            try
            {
                xmlDoc.Load(sPath + "\\"+fileName);
            }
            catch (Exception e)
            { 
                
            }
                xmlNL=xmlDoc.GetElementsByTagName("window");
            
            
            f1 = new Form1();
            XmlAttributeCollection atributeCollection = atributeCollection=xmlNL[0].Attributes;
            f1.Text = atributeCollection.GetNamedItem("title").InnerText;
            f1.ClientSize = new System.Drawing.Size(Convert.ToInt32(atributeCollection.GetNamedItem("width").InnerText),
                Convert.ToInt32(atributeCollection.GetNamedItem("height").InnerText));
            f1.Location = new System.Drawing.Point(Convert.ToInt32(atributeCollection.GetNamedItem("xpos").InnerText),
                Convert.ToInt32(atributeCollection.GetNamedItem("ypos").InnerText));



            YaxglButton button = new YaxglButton();
            f1.addControl(button.button);


            MethodInfo[] methods = eventHandlerClassType.GetType().GetMethods();
            foreach(MethodInfo m in methods)
            {
                Object[] attribute = m.GetCustomAttributes(typeof(YaxglEvent),false);
                if (attribute.Length > 0)
                {
                    button.addEvent(EventType.CLICK, m,eventHandlerClassType);
                    //m.Invoke(eventHandlerClassType,null);
                }
            }

         

            show();
           // this.button1.Click += new System.EventHandler(this.button1_Click);
        
        }

        
       

    
    }
}
