/**
 * 
 */
package de.yaxgl.client.Base;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.xml.client.Element;

import de.yaxgl.client.Container.*;
import de.yaxgl.client.Helper.*;

public abstract class Component {
	protected String ID;
	protected Widget control = null;
	protected Container owner = null;

	public String getID() {
		return ID;
	}

	/*
	 * must be im plemented by every component is called by the component
	 * factory
	 */
	public abstract void initializeNativeControl(Element xmlElement);

	/* returns the direct Container of a component */
	public Container getContainer() {
		return this.owner;
	}

	/* returns the window of a component */
	public Window getParentWindow() {
		Window retval = null;
		if ((this.owner instanceof Window) || (this.owner == null)) {
			retval = (Window) this.owner;
		} else {
			retval = this.owner.getParentWindow();
		}
		return retval;
	}

	public void setBounds(int xpos, int ypos, int width, int height) {
		setDimension(new Dimension(width, height));
		setLocation(new Location(xpos, ypos));
	}

	public void setBounds(Integer xpos, Integer ypos, Integer width, Integer height) {
		setBounds(xpos.intValue(), ypos.intValue(), width.intValue(), height.intValue());
	}
	
	public Dimension getDimension() {
		return new Dimension(this.control.getOffsetWidth(), this.control.getOffsetHeight());
	}

	public void setDimension(Dimension dimension) {
		this.control.setPixelSize(dimension.getWidth(), dimension.getHeight());
	}

	public void setLocation(Location location) {
		if (this.owner != null)
			this.owner.setChildLocation(location, this);
	}

	public Location getLocation() {
		if (owner==null)
			return new Location(this.control.getAbsoluteLeft(), this.control.getAbsoluteTop());
		else
			return new Location(this.control.getAbsoluteLeft() - owner.getNativeComponent().getAbsoluteLeft(),
								this.control.getAbsoluteTop() - owner.getNativeComponent().getAbsoluteTop() );
	}

	/*
	 * returns the Specific Native Control of an de.yaxgl.Component
	 */
	public Widget getNativeComponent() {
		return this.control;
	}

}
