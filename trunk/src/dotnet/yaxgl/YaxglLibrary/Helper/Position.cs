using System;
using System.Collections.Generic;
using System.Text;

namespace de.yaxgl
{
    public class Position
    {
        private int xpos;
        private int ypos;
        
        public Position(int xpos,int ypos)
        {
            this.xpos = xpos;
            this.ypos = ypos;
        }

        public int getX()
        {
            return this.xpos;
        }

        public int getY()
        {
            return this.ypos;
        }

        public void setX(int xpos) 
        {
            this.xpos = xpos;
        }

        public void setY(int ypos)
        {
            this.ypos = ypos;
        }
    }
}
