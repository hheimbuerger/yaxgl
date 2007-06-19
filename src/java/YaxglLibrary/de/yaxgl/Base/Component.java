/**
 * 
 */
package de.yaxgl.Base;



import de.yaxgl.Container.*;
import de.yaxgl.Helper.*;
import org.w3c.dom.*;

public abstract class Component {
	protected String ID;
	protected org.eclipse.swt.widgets.Control control=null;
	protected Container owner=null;
	
	

    public String getID()
    {
        return ID;
    }

    /* must be im plemented by every component is called by the component factory*/
    public abstract void initializeNativeControl(Element xmlElement);

    
    /* returns the direct Container of a component*/
    public Container getContainer()
    {
        return this.owner;
    }

    
    /*returns the window of a component*/
    public Window getParentWindow()
    {
        Window retval = null;
        if ((this.owner.getClass() == Window.class) || (this.owner==null))
        {
            retval = (Window)this.owner;
        }
        else
        {
            retval = this.owner.getParentWindow();
        }
        return retval;
    }


    public void setBounds(int xpos, int ypos, int width, int height)
    {
        this.control.setBounds(xpos, ypos, width, height);
    }

    public Dimension getDimension()
    {
        return new Dimension(this.control.getSize().x, this.control.getSize().y);
    }

    public void setDimension(Dimension dimension)
    {
        this.control.setSize(dimension.getWidth(),dimension.getHeight());   
        }

    public void setLocation(Location location)
    {
        this.control.setLocation(location.getX(),location.getY());
        
    }

    public Location getLocation()
    {
        return new Location(this.control.getLocation().x, this.control.getLocation().y); 
    }
   

    /*returns the Specific Native Control of an de.yaxgl.Component
     * */
    public Object getNativeComponent()
    {
        return this.control;
    }

	
}
