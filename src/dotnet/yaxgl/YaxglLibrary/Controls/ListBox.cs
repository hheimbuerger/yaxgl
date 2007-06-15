using System;
using System.Collections.Generic;
using System.Text;

namespace de.yaxgl
{
    public class ListBox : Control
    {
        public ListBox(Container owner, string ID)
        {
            this.owner = owner;
            this.ID = ID;

            this.control = new System.Windows.Forms.ListBox();

            /*register events*/
            this.control.Click += new System.EventHandler(clickEvent);
            ((System.Windows.Forms.ListBox)this.control).SelectedIndexChanged += new System.EventHandler(selectionChangedEvent);
        
        }

        public void setMultiselection(bool multiselect)
        {
            if (multiselect)
            {
                ((System.Windows.Forms.ListBox)this.control).SelectionMode = System.Windows.Forms.SelectionMode.MultiExtended;

            }
            else
            {
                ((System.Windows.Forms.ListBox)this.control).SelectionMode = System.Windows.Forms.SelectionMode.One;
            }
        }

        public bool isMultiselection()
        {
            if (((System.Windows.Forms.ListBox)this.control).SelectionMode == System.Windows.Forms.SelectionMode.One)
                return false;
            else
                return true;
        }

        public void addItem(string item)
        {
            System.Windows.Forms.ListBox listBox = (System.Windows.Forms.ListBox)this.control;
            listBox.Items.Add(item);
        }

        public void addRange(String[] items)
        {
            System.Windows.Forms.ListBox listBox = (System.Windows.Forms.ListBox)this.control;
            listBox.Items.AddRange(items);
        }

        public void clearItems()
        {
            System.Windows.Forms.ListBox listBox = (System.Windows.Forms.ListBox)this.control;
            listBox.Items.Clear();
        }

        public void select(string selection)
        {
            System.Windows.Forms.ListBox listBox = (System.Windows.Forms.ListBox)this.control;
            if (listBox.Items.Contains(selection))
            {
                listBox.SelectedIndex = listBox.FindStringExact(selection);
            }
        }

        public string[] getSelectedItems()
        {
            System.Windows.Forms.ListBox listBox = (System.Windows.Forms.ListBox)this.control;
            List<string> itemList = new List<string>();
            foreach (string item in listBox.SelectedItems)
            {
                itemList.Add(item);
            }
            return itemList.ToArray();
        }
    
    }
}
