using System;
using System.Collections.Generic;
using YaxglTestLib;
using System.Windows.Forms;

namespace AnnotationTest
{
    class Program
    {
        /// <summary>
        /// Der Haupteinstiegspunkt für die Anwendung.
        /// </summary>
        [STAThread]
        static void Main()
        {
            
           
            new YaxglSetup("test.xml",new Program());
        
        }

        
        [YaxglEvent(EventType.CLICK,"btn1")]
        public void anyClickFunction()
        {
            MessageBox.Show("Ich bin ein zur Laufzeit ausgewertetes .Net C# Attribute");
        }
    
    }
}