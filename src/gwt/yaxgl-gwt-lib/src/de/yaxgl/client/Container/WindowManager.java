package de.yaxgl.client.Container;

import java.util.ArrayList;
import java.util.List;


import com.google.gwt.user.client.ui.RootPanel;


public class WindowManager {


	 List windows = null;
     private static WindowManager instance = null;
     private static boolean initialized = false;
     private static RootPanel display = null;
     
     private WindowManager()
     {
         windows = new ArrayList();
     }


     public static void initialize()
     {
         initialized = true;
     }
     
     
     public static WindowManager getInstance() throws Exception
     {
         if (!initialized)
            //TODO //throw new NotYetInitilaizedException("Error: You have to initialize the WindowManager with a LookAndFeel before you can get an instance");
        	 throw new Exception("The WindowManager must be initialized before you can have an instance.");
         
         if (instance == null)
         {
       		 display = RootPanel.get();
        	 instance = new WindowManager();
         }
         return instance;
     }
     
     public Window createWindow(String xmlfile)
     {
         Window window = new Window(display,xmlfile);
         windows.add(window);
         return window;
     }


     /* this method will not return until closing the window
      * starts a new application by given Window baseWindow
      * */
     public void run(Window baseWindow)
     {
    	 // nothing to do with GWT
     }
     



}
