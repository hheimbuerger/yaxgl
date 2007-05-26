using System;
using System.Collections.Generic;
using System.Text;

namespace de.yaxgl
{
    public class EditBox :Control
    {
        public EditBox(Container owner, string ID)
        {
            this.owner = owner;
            this.ID = ID;

            this.control = new System.Windows.Forms.TextBox();
            this.control.GotFocus += new System.EventHandler(focusEvent);
            //this.control.Leave += new System.EventHandler(leaveEvent);
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
            return  ((System.Windows.Forms.TextBox)this.control).MaxLength;
        }
        
        
        public void setMultiline(bool multiline)
        {
            System.Windows.Forms.TextBox textBox = (System.Windows.Forms.TextBox)this.control;
            //setting multiline
            textBox.Multiline=multiline;
            // Allow the RETURN key to be entered in the TextBox control.
            textBox.AcceptsReturn = multiline;
            // Allow the TAB key to be entered in the TextBox control.
            textBox.AcceptsTab = multiline;
            // Set WordWrap to True to allow text to wrap to the next line.
            textBox.WordWrap = multiline;
            if (multiline)
            {
                // Add vertical scroll bars to the TextBox control.
                textBox.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
            }
            else
            {
                textBox.ScrollBars = System.Windows.Forms.ScrollBars.None;
            }
        }

        public bool isMultiline()
        {
            return ((System.Windows.Forms.TextBox)this.control).Multiline;
        }
    
    }
}
