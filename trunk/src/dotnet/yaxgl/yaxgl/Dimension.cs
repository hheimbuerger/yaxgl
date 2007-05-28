using System;
using System.Collections.Generic;
using System.Text;

namespace de.yaxgl
{
   
    public class Dimension
    {
        private int height;
        private int width;

        public Dimension()
        {
            this.height = 0;
            this.width = 0;
        }
        
        public Dimension(int width,int height)
        {
            this.height = height;
            this.width = width;
        }
        
        public void setHeight(int height)
        {
            this.height = height;
        }
        public void setWidth(int width)
        {
            this.width = width;
        }
        
        public int getHeight()
        {
            return this.height;
        }
        public int getWidth()
        {
            return this.width;
        }
    
    }

}
