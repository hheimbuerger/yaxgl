using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;

namespace de.yaxgl
{
    public class WindowManager
    {
        IList<Window> windows = null;
       // private EventHandlerManager eventHandlerManager = null;
        

        public WindowManager()
        {
            windows = new List<Window>();
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
        }

        public Window createWindow(string xmlfile)
        {
            Window window = new Window(xmlfile);
            windows.Add(window);
            return window;
        }
        
        public Window createWindow(string xmlfile,Object EventReciever)
        {
            Window window = new Window(xmlfile);
            window.registerEventHandlers(EventReciever);
            windows.Add(window);
            return window;
        }

        public Window getWindowByID(string ID)
        {
            /*not jet implemented*/
            return null;
        }
        
    
    
    }
}
