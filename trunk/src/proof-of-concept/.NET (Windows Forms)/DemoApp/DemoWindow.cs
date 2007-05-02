using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;

namespace DemoApp
{
    class DemoWindow : XMLBasedGUI.XmlBasedWindow
    {
        public DemoWindow() : base("demo.xml")
        {
            Button button = (Button)getControlByID("button");
            if (button != null)
            {
                EventHandler eHandler = new EventHandler(userClicked);
                button.Click += eHandler;
            }
        }

        public void userClicked(object sender, EventArgs e)
        {
            TextBox editbox = (TextBox)getControlByID("text");
            if (editbox != null)
            {
                MessageBox.Show(editbox.Text);
            }
            else
            {
                MessageBox.Show("ERROR!");
            }
        }

    }
}
