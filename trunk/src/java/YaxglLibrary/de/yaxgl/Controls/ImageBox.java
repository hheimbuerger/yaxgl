package de.yaxgl.Controls;




import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.w3c.dom.Element;

import de.yaxgl.Base.Control;
import de.yaxgl.Container.Container;

public class ImageBox extends Control {

	public ImageBox(Container owner,String ID)
	{
		this.owner=owner;
		this.ID=ID;
		
	}
	
	@Override
	public void initializeNativeControl(Element xmlElement) {
		
		Composite composite=(Composite)this.owner.getNativeComponent();
		this.control=new org.eclipse.swt.widgets.Label(composite,SWT.NONE);
		//TODO: events
		
		setBounds(Integer.valueOf(xmlElement.getAttribute("xpos")),
				Integer.valueOf(xmlElement.getAttribute("ypos")),
				Integer.valueOf(xmlElement.getAttribute("width")),
				Integer.valueOf(xmlElement.getAttribute("height")));
		
		loadImage(xmlElement.getAttribute("source"));
		
	}
	
	public void loadImage(String fileImage)
    {
		/*TODO paint image in an other way maybe
		 * Canvas canvas = new Canvas (group, SWT.NONE);
	canvas.addPaintListener (new PaintListener () {
		public void paintControl (PaintEvent e) {
			e.gc.drawImage (image, 0, 0);
		}
	});
		 */
		ImageData data = new ImageData(fileImage); 
	    Display display=this.getParentWindow().getDisplay();
	    Image image = new Image(display, data);
	    /*final Image image = new Image(display, data);
	    
	    Canvas canvas=new Canvas((Composite)this.getContainer().getNativeComponent(),SWT.NONE);
	    canvas.addPaintListener (new PaintListener () {
			public void paintControl (PaintEvent e) {
				e.gc.drawImage (image, 0, 0);
			}
		});
	    ((Composite)this.getContainer().getNativeComponent()).redraw();
	    */
	    ((org.eclipse.swt.widgets.Label)this.control).setBackgroundImage(image);
    }
}
