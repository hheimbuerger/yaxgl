using System;
using System.Collections.Generic;
using System.Text;

namespace de.yaxgl
{
    public class Location
    {
        private int xpos;
        private int ypos;
        
        public Location()
        {
            xpos = 0;
            ypos = 0;
        }
        
        public Location(int xpos,int ypos)
        {
            this.xpos = xpos;
            this.ypos = ypos;
        }

        public int getXPos()
        {
            return xpos; 
        }
        public void setXPos(int xpos)
        {
            this.xpos=xpos;
        }
        public int getYPos()
        {
            return ypos;
        }
        
        public void setYPos(int ypos)
        {
            this.ypos=ypos;
        }
    }
}
