using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;
using System.Xml;

namespace de.yaxgl
{
    public class WindowManager
    {
        IList<Window> windows = null;
        private static WindowManager instance = null;
        private static bool initialized = false;

        
        class NotJetInitilaizedException : Exception 
        { 
            public NotJetInitilaizedException()
            {
            
            }
            public NotJetInitilaizedException(string message)
                : base(message)
            {
            
            }
        }

        private WindowManager()
        {
                
            windows = new List<Window>();
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
        }


        public static void initialize(LookAndFeel lookAndFeel)
        {
            if (lookAndFeel != LookAndFeel.System)
                throw new NotSupportedException("Error: The LookAndFeel." + lookAndFeel.ToString() + " style is not supported in C# .NET applications");
            
            initialized=true;
        }
        
        
        public static WindowManager getInstance()
        {
            if (!initialized)
                throw new NotJetInitilaizedException("Error: You have to initialize the WindowManager with a LookAndFeel before you can get an instance");

            if (instance == null)
            {
                instance = new WindowManager();
            }
            return instance;
        }
        
        public Window createWindow(string xmlfile,Object EventReciever)
        {
            Window window = new Window(xmlfile);
            window.registerEventHandlers(EventReciever);
            windows.Add(window);
            return window;
        }


        /* this method will not return until closing the window
         * starts a new application by given Window baseWindow
         * */
        public void run(Window baseWindow)
        {
            if (baseWindow == null)
                throw new NullReferenceException("Error: cannot run application");

            Application.Run((Form)baseWindow.getNativeComponent());
        }
        
        public void show(Window window)
        {
            if(window!=null)
                window.show();            
        }

        public void showModal(Window window, Window parentWindow)
        {
            if(window!=null)
                window.showDialog(parentWindow);
        }

        public void hide(Window window)
        {
            if (window != null)
                window.hide();
        }

        public void close(Window window)
        {
            if (window != null)
            {
                if(windows.Contains(window))
                {
                    windows.Remove(window);
                }
                window.close();
            }
        }

        public IList<Window> getWindowsByID(string ID)
        {
            IList<Window> matchingWindows = new List<Window>();
            foreach (Window window in windows)
            {
                if (window.getID().Equals(ID))
                    matchingWindows.Add(window);
            
            }
            return matchingWindows;
        }
    }
}
