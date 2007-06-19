/**
 * 
 */
package de.yaxgl.Container;

import java.io.*;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.w3c.dom.Element;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import de.yaxgl.Base.*;
import de.yaxgl.EventDispatcher.*;
import de.yaxgl.Helper.*;

@SuppressWarnings("serial")
public class Window extends Container {
	
	private EventHandlerManager eventHandlerManager=null;
	private Display display=null;
	
	public Window(Display display,String xmlfile)
	{
		this.display=display;
		/*on creation a Window has no owner*/
		this.owner = null;
		/*eventHandlerManager must be instanciated here before parsing XML
        *because the Group container needs an reference of his instance also
        * */
        this.eventHandlerManager = new EventHandlerManager();
           
        Element rootElement = validateXmlDocument(xmlfile);
        parseXML(rootElement);
        /*register window events*/
        //form.Click+=new System.EventHandler(form_Click)
        
	}
	public void registerEventHandlers(Object eventReciever)
     {
         if(eventReciever!=null)
         {
			try {
				eventHandlerManager.registerEventHandlers(eventReciever);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
     }
	 
	 
	@Override
	public void initializeNativeControl(Element xmlElement) {
		int style=SWT.SHELL_TRIM;
		this.ID = xmlElement.getAttribute("id");
                
        if(!Boolean.valueOf(xmlElement.getAttribute("minimizeBox")))
        	style=style-SWT.MIN;
        
        if(!Boolean.valueOf(xmlElement.getAttribute("maximizeBox")))
        	style=style-SWT.MAX;
        
         String borderStyle= xmlElement.getAttribute("borderStyle");

        if (borderStyle.equals("fixed"))
            style=style-SWT.RESIZE;
        else if (borderStyle.equals("none"))
            style=SWT.NONE;
        
        this.control = new org.eclipse.swt.widgets.Shell(display,style);
        
        setBounds(Integer.valueOf(xmlElement.getAttribute("xpos")), 
        		Integer.valueOf(xmlElement.getAttribute("ypos")),
        		Integer.valueOf(xmlElement.getAttribute("width")), 
        		Integer.valueOf(xmlElement.getAttribute("height")));
        
        setTitle(xmlElement.getAttribute("title"));
        setIcon(xmlElement.getAttribute("icon"));
  
	}
	
	
	@Override
	public void notifyEvent(Component control, EventArgs eventArgs) {

		eventHandlerManager.invokeHandlers(control, eventArgs);
		
	}

	
	public void showInTaskbar(boolean show)
    {
        //((org.eclipse.swt.widgets.Shell)this.control).
    }

    public void setBorderStyle(WindowStyle windowStyle)
    {
    	
    	switch (windowStyle)
        { 
            case Fixed:
                //thisShell
                //thisShell.set  this would for example be the style(SWT.CLOSE | SWT.TITLE | SWT.MIN | SWT.MAX)
            	break;
            case None:
                //thisForm.FormBorderStyle = FormBorderStyle.None;
                break;
            case Sizeable:
                //thisForm.FormBorderStyle = FormBorderStyle.Sizable;
                break;
        }
    	throw new NotImplementedException();
    }
    
    public void minimizeable(boolean minimize)
    {
    	throw new NotImplementedException();
    	
    }

    public void maximizeable(boolean maximize)
    {
    	throw new NotImplementedException();
    	}


    public void setIcon(String icon)
    {
    	Image image=null;
		try {
			image = new Image(((org.eclipse.swt.widgets.Shell)this.control).getDisplay(),
					new FileInputStream(icon));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	((org.eclipse.swt.widgets.Shell)this.control).setImage(image);
    }

    /*returns the container title**/
    public String getTitle()
    {
        return ((org.eclipse.swt.widgets.Shell)this.control).getText();
    }

    /*sets the container title**/
    public void setTitle(String title)
    {
    	((org.eclipse.swt.widgets.Shell)this.control).setText(title);
    }

    public void show()
    { 	
    	((org.eclipse.swt.widgets.Shell)this.control).open();
    }

    /*if parentWindow is null the parent of this window is automatically the window below*/
    public void showDialog(Window parentWindow)
    {
        if (parentWindow != null)
        {
            this.owner = parentWindow;
            ((org.eclipse.swt.widgets.Shell)this.control).setParent((org.eclipse.swt.widgets.Composite)parentWindow.getNativeComponent());
        }
        ((org.eclipse.swt.widgets.Shell)this.control).open();
    }
    
    public void hide()
    {
    	//((org.eclipse.swt.widgets.Shell)this.control).setVisible(false);
    }

    public void close()
    {
    	((org.eclipse.swt.widgets.Shell)this.control).close();
    }
	
}
