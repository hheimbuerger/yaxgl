package de.yaxgl.Container;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Display;

import de.yaxgl.Helper.LookAndFeel;

public class WindowManager {
/*
	while (!shell.isDisposed ()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();
	*/
	 List<Window> windows = null;
     private static WindowManager instance = null;
     private static boolean initialized = false;

     
     public class NotYetInitilaizedException extends Exception 
     { 
         public NotYetInitilaizedException()
         {
         
         }
         public NotYetInitilaizedException(String message)
         {
        	 super(message);
         }
     }
     
     public class NotSupportedException extends Exception
     {
    	 public NotSupportedException()
    	 {
    		 
    		 
    	 }
    	 
    	 public NotSupportedException(String message)
    	 {
    		 super(message);
    		 
    	 }
    	 
     }

     private WindowManager()
     {
             
         windows = new ArrayList<Window>();
     }


     public static void initialize(LookAndFeel lookAndFeel)
     {
         if (lookAndFeel != LookAndFeel.System)
            // throw new NotSupportedException("Error: The LookAndFeel." + lookAndFeel.toString() + " style is not supported in C# .NET applications");
         //TODO
         initialized=true;
     }
     
     
     public static WindowManager getInstance()
     {
         if (!initialized)
            //TODO //throw new NotYetInitilaizedException("Error: You have to initialize the WindowManager with a LookAndFeel before you can get an instance");

         if (instance == null)
         {
             instance = new WindowManager();
         }
         return instance;
     }
     
     public Window createWindow(String xmlfile,Object EventReciever)
     {
         Window window = new Window(xmlfile);
         window.registerEventHandlers(EventReciever);
         windows.add(window);
         return window;
     }


     /* this method will not return until closing the window
      * starts a new application by given Window baseWindow
      * */
     public void run(Window baseWindow)
     {
         //if (baseWindow == null)
             //TODOthrow new NullReferenceException("Error: cannot run application");
    	// Display d=new Display();
    	 
    	 
    	
     
     
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

     /*
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
*/
}
