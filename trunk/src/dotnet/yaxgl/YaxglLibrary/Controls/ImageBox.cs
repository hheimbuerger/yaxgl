using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;

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

        public override void initializeNativeControl(System.Xml.XmlElement xmlElement)
        {
            setBounds(Convert.ToInt32(xmlElement.Attributes["xpos"].InnerText),
                      Convert.ToInt32(xmlElement.Attributes["ypos"].InnerText),
                      Convert.ToInt32(xmlElement.Attributes["width"].InnerText),
                      Convert.ToInt32(xmlElement.Attributes["height"].InnerText));
            loadImage(xmlElement.Attributes["source"].InnerText);
        }
        
        public void loadImage(string fileImage)
        {
            ((System.Windows.Forms.PictureBox)this.control).Load(Application.StartupPath + "/" + fileImage);
        }

    }
}
