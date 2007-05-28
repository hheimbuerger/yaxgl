using System;
using System.Collections.Generic;
using System.Text;

namespace de.yaxgl
{
    public class ImageBox : Control
    {
        public ImageBox(Container owner, string ID)
        {
            this.owner = owner;
            this.ID = ID;

            this.control = new System.Windows.Forms.PictureBox();
            //events
            this.control.Click += new System.EventHandler(clickEvent);
        }

        public void loadImage(string fileImage)
        {
            ((System.Windows.Forms.PictureBox)this.control).Load(fileImage);
        }

    }
}
