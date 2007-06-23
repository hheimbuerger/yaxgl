using System;
using System.Collections.Generic;
using System.Text;
using de.yaxgl;

/*
 * 
 * 
 * 
 * 
 * 
 * */
namespace TestApplication
{
    public class Start
    {
        private WindowManager winManager = null;
        
        public Start()
        {
            WindowManager.initialize(LookAndFeel.System);
            winManager = WindowManager.getInstance();
            
            Window win=winManager.createWindow(@"../../test.xml", new ControlEventsOvervie(winManager));

            //Button but = new Button(win, "button2");
            //but.setLabel("erstellt in testappl");
            //but.setBounds(0, 120, 100, 20);
            //win.add(but);

            winManager.run(win);             
        }
        
        [STAThread]
        public static void Main()
        {
            Start s = new Start();
        }
        
            
    }
}
