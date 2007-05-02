using System;
using System.Collections.Generic;
using System.Text;
using System.Drawing;
using System.Windows.Forms;

namespace XMLBasedGUI
{
    class ControlFactory
    {
        public static Button createButton(String ID, Point topLeft, Size size, String label)
        {
            Button button = new System.Windows.Forms.Button();
            button.Location = topLeft;
            button.Name = ID;
            button.Size = size;
            //button.TabIndex = 0;
            button.Text = label;
            button.UseVisualStyleBackColor = true;
            return button;
        }

        public static TextBox createEditbox(String ID, Point topLeft, Size size, String text)
        {
            TextBox editbox = new System.Windows.Forms.TextBox();
            editbox.Location = topLeft;
            editbox.Name = ID;
            editbox.Size = size;
            //editbox.TabIndex = 0;
            editbox.Text = text;
            return editbox;
        }
    }

    public class XmlBasedWindow : Form
    {
        protected XmlBasedWindow(String pathToXML)
        {
            // we're working on the window, so lets not make the changes visible until we're completely done
            this.SuspendLayout();

            // read the XML and create the controls specified there
            parseXML(pathToXML);

            // okay, now lets make this visible
            this.ResumeLayout();
        }

        private void parseXML(String pathToXML)
        {
            // DEBUG: demo code (all the data here would normally be retrieved from the XML)
            //this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            //this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            //this.ClientSize = new System.Drawing.Size(292, 273);
            this.Name = "test1";
            this.Text = "test1";
            this.Controls.Add(ControlFactory.createEditbox("text", new Point(10, 10), new Size(100, 25), ""));
            this.Controls.Add(ControlFactory.createButton("button", new Point(10, 50), new Size(100, 25), "Hello, world!"));
        }

        protected Control getControlByID(String ID)
        {
            foreach (Control c in this.Controls)
            {
                if (c.Name == ID)
                    return c;
            }
            return null;
        }

        abstract void onButtonClick(...);
    }
}
