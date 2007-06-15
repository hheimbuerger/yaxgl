using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;
using System.Xml;

namespace de.yaxgl
{
    public class WindowManager
    {
        IDictionary<string,Window> windows = null;

        public WindowManager()
        {
            
            windows = new Dictionary<string,Window>();
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
        }

        public Window createWindow(string xmlfile,Object EventReciever)
        {
            Window window = new Window(xmlfile);
            window.registerEventHandlers(EventReciever);
            windows.Add(window.getID(), window);
            return window;
        }

        public Window getWindowByID(string ID)
        {
            if (windows.ContainsKey(ID))
                return windows[ID];
            else
                return null;
        }
    }
}
