using System;
using System.Collections.Generic;
using System.Text;
using System.Xml;

namespace de.yaxgl
{
    /*Base class of all de.yaxgl Components*/
    public abstract class Component
    {

        protected string ID;        
        protected Container owner = null;
        protected System.Windows.Forms.Control control = null;
        

        public string getID()
        {
            return ID;
        }

        /* must be im plemented by every component is called by the component factory*/
        public abstract void initializeNativeControl(XmlElement xmlElement);

        
        /* returns the direct Container of a component*/
        public Container getContainer()
        {
            return this.owner;
        }

        
        /*returns the window of a component*/
        public Window getParentWindow()
        {
            Window retval = null;
            if ((this.owner.GetType() == typeof(Window)) || (this.owner==null))
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
            this.control.SetBounds(xpos, ypos, width, height);
        }

        public Dimension getDimension()
        {
            return new Dimension(this.control.Width, this.control.Height);
        }

        public void setDimension(Dimension dimension)
        {
            this.control.Width = dimension.getWidth();
            this.control.Height = dimension.getHeight();
        }

        public void setPosition(Position position)
        {
            this.control.Location= new System.Drawing.Point(position.getX(),position.getY());
            
        }

        public Position getPosition()
        {
            return new Position(this.control.Location.X, this.control.Location.Y); 
        }
       

        /*returns the Specific Native Control of an de.yaxgl.Component
         * */
        public Object getNativeComponent()
        {
            return this.control;
        }
        
     }
}
