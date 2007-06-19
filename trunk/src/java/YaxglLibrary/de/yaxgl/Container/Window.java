/**
 * 
 */
package de.yaxgl.Container;

import java.io.*;

import org.eclipse.swt.graphics.Image;
import org.w3c.dom.Element;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

import de.yaxgl.Base.*;
import de.yaxgl.EventDispatcher.*;
import de.yaxgl.Helper.*;

@SuppressWarnings("serial")
public class Window extends Container {
	
	private EventHandlerManager eventHandlerManager=null;
	
	public Window(String xmlfile)
	{
		 /*on creation a Window has no owner*/
        this.owner = null;
        /*eventHandlerManager must be instanciated here before parsing XML
         *because the Group container needs an reference of his instance also
         * */
        this.eventHandlerManager = new EventHandlerManager();
        this.control = new org.eclipse.swt.widgets.Shell();
        
        Element rootElement = validateXmlDocument(xmlfile);
        parseXML(rootElement);
        
        //Form f = new Form();
        
        /*register window events*/
        //form.Click+=new System.EventHandler(form_Click);
	
	
	}

	@Override
	public void notifyEvent(Component control, EventArgs eventArgs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initializeNativeControl(Element xmlElement) {
		// TODO Auto-generated method stub
		
	}
	public void showInTaskbar(boolean show)
    {
        //((org.eclipse.swt.widgets.Shell)this.control).
    }

    public void setBorderStyle(WindowStyle windowStyle)
    {
    	
    	org.eclipse.swt.widgets.Shell thisShell=(org.eclipse.swt.widgets.Shell)this.control;
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
    	//((Form)this.control).MinimizeBox = minimize;
    }

    public void maximizeable(boolean maximize)
    {
    	//((org.eclipse.swt.widgets.Shell)this.control).setM
    	// ((Form)this.control).MaximizeBox = maximize;
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
            //((Form)this.control).ShowDialog(parentWindow.control);
        }
        //else
            //((Form)this.control).ShowDialog();
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
