using System;
using System.Collections.Generic;
using System.Text;

namespace de.yaxgl
{
    public class ComboBox:Control
    {
        public ComboBox(Container owner, string ID)
        {
            this.owner = owner;
            this.ID = ID;
            this.control = new System.Windows.Forms.ComboBox();
            ((System.Windows.Forms.ComboBox)this.control).DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            
            /*registered events*/
            this.control.GotFocus += new System.EventHandler(focusEvent);
            ((System.Windows.Forms.ComboBox)this.control).SelectionChangeCommitted += new System.EventHandler(selectionChangedEvent);
        }

        public void addItem(string item)
        {
            System.Windows.Forms.ComboBox comboBox = (System.Windows.Forms.ComboBox)this.control;
            comboBox.Items.Add(item);
        }

        public void addRange(String[] items) {
            System.Windows.Forms.ComboBox comboBox = (System.Windows.Forms.ComboBox)this.control;
            comboBox.Items.AddRange(items);
        }

        public void clearItems()
        {
            System.Windows.Forms.ComboBox comboBox = (System.Windows.Forms.ComboBox)this.control;
            comboBox.Items.Clear();
        }
        
        public void select(string selection)
        {
            System.Windows.Forms.ComboBox comboBox = (System.Windows.Forms.ComboBox)this.control;
            if(comboBox.Items.Contains(selection))
            {
                comboBox.SelectedIndex=comboBox.FindStringExact(selection);
            }
        }
        
        public string getSelectedItem()
        {
            System.Windows.Forms.ComboBox comboBox = (System.Windows.Forms.ComboBox)this.control;
            return (string)comboBox.SelectedItem;
        }
    }
}// END NAMESPACE
