/**
 * 
 */
package de.yaxgl.client.Container;


import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.xml.client.Element;


public class Window extends Container {
	
	private RootPanel display = null;
	
	public Window(RootPanel display,String xmlfile)
	{
		this.display = display;
		/*on creation a Window has no owner*/
		this.owner = null;

		// dont't create a subpanel, just use the RootPanel of the browser window
        //this.control = new com.google.gwt.user.client.ui.AbsolutePanel();
		//display.add(this.control);
		this.control = display;
		
		((com.google.gwt.user.client.ui.AbsolutePanel)control).addStyleName("yaxgl-window");
        
        Element rootElement = validateXmlDocument(xmlfile);
        parseXML(rootElement);
        
	}


	 
	 
	public void initializeNativeControl(Element xmlElement) {
		this.ID = xmlElement.getAttribute("id");

		/* unable to set these values for a browser window!
		* would be possible, if we create a subpanel inside the browser window
		*/
        //setBounds(Integer.valueOf(xmlElement.getAttribute("xpos")), 
       	//	Integer.valueOf(xmlElement.getAttribute("ypos")),
        //		Integer.valueOf(xmlElement.getAttribute("width")), 
        //		Integer.valueOf(xmlElement.getAttribute("height")));
        
        setTitle(xmlElement.getAttribute("title"));
  
	}
	
	
	
	public RootPanel getDisplay()
	{
		return this.display;
	}
	




    /*returns the container title**/
    public String getTitle()
    {
    	return com.google.gwt.user.client.Window.getTitle();
    }

    /*sets the container title**/
    public void setTitle(String title)
    {
    	com.google.gwt.user.client.Window.setTitle(title);
    }


	
}
