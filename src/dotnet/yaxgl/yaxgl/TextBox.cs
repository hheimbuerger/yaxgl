using System;
using System.Collections.Generic;
using System.Text;

namespace de.yaxgl
{
    public class TextBox : Control
    {
        public TextBox(Container owner, string ID)
        {
            this.owner = owner;
            this.ID = ID;

            this.control = new System.Windows.Forms.TextBox();
            
            System.Windows.Forms.TextBox textBox = (System.Windows.Forms.TextBox)this.control;
            //setting multiline
            textBox.Multiline=true;
            // Allow the RETURN key to be entered in the TextBox control.
            textBox.AcceptsReturn = true; ;
            // Allow the TAB key to be entered in the TextBox control.
            textBox.AcceptsTab = true;
            // Set WordWrap to True to allow text to wrap to the next line.
            textBox.WordWrap = true;
            // Add vertical scroll bars to the TextBox control.
            textBox.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;

      
            /* reister Events*/
            this.control.Click += new System.EventHandler(clickEvent);
            this.control.GotFocus += new System.EventHandler(gotFocusEvent);
            this.control.LostFocus += new System.EventHandler(lostFocusEvent);
        }
        public void setText(string text)
        {
            this.control.Text = text;
        }

        public string getText()
        {
            return this.control.Text;
        }

        public void setMaxLength(int length)
        {
            ((System.Windows.Forms.TextBox)this.control).MaxLength = length;

        }

        public int getMaxLength()
        {
            return ((System.Windows.Forms.TextBox)this.control).MaxLength;
        }
    }
}
