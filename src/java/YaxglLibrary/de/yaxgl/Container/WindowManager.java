package de.yaxgl.Container;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import de.yaxgl.Helper.LookAndFeel;

public class WindowManager {

	 List<Window> windows = null;
     private static WindowManager instance = null;
     private static boolean initialized = false;
     private static Display display=null;
     
     private WindowManager()
     {
             
         windows = new ArrayList<Window>();
     }


     public static void initialize(LookAndFeel lookAndFeel) throws Exception
     {
         if (lookAndFeel != LookAndFeel.System)
        	 throw new Exception("The selected LookAndFeel is not supported.");
        	 
         initialized=true;
     }
     
     
     public static WindowManager getInstance() throws Exception
     {
         if (!initialized)
             throw new Exception("The WindowManager must be initialized before you can have an instance.");
         
         if (instance == null)
         {
             display=new Display();
        	 instance = new WindowManager();
         }
         return instance;
     }
     
     public Window createWindow(String xmlfile,Object EventReciever)
     {
         Window window = new Window(display,xmlfile);
         window.registerEventHandlers(EventReciever);
         windows.add(window);
         return window;
     }


     /* this method will not return until closing the window
      * starts a new application by given Window baseWindow
      * */
     public void run(Window baseWindow)
     {
    	 Shell shell=null;
    	 if (baseWindow != null)
    	 {
    		 shell=(org.eclipse.swt.widgets.Shell)baseWindow.getNativeComponent();
    		 baseWindow.show();
    	 }
            
    	 while (!shell.isDisposed ()) {
  			if (!display.readAndDispatch ()) display.sleep ();
  		}
  		display.dispose ();
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
             if(windows.contains(window))
             {
                 windows.remove(window);
             }
             window.close();
         }
     }

     public List<Window> getWindowsByID(String ID)
     {
         List<Window> matchingWindows = new ArrayList<Window>();
         for(Window window : windows)
         {
             if (window.getID().equals(ID))
                 matchingWindows.add(window);
         }
         return matchingWindows;
     }

}
