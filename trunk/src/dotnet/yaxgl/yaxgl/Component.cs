using System;
using System.Collections.Generic;
using System.Text;

namespace de.yaxgl
{
    public abstract class Component
    {
        protected string ID;
        protected System.Windows.Forms.Control control = null;

        public string getID()
        {
            return ID;
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
       

        /*returns the Specific Base Control of an de.yaxgl.Containable (Control and Group)
         * */
        public System.Windows.Forms.Control getNativeComponent()
        {
            return this.control;
        }

     }
}
