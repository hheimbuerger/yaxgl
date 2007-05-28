using System;
using System.Collections.Generic;
using System.Text;
using de.yaxgl;

/*
 * 
 * 
 * 
 * 
 * 
 * */
namespace TestApplication
{
    public class Start
    {
        private WindowManager winManager = null;
        public Start(string xmlFile)
        {
            winManager = new WindowManager();
            winManager.createWindow(xmlFile, this).show();
        }
        
        
        
        public static void Main()
        {
            Start s = new Start(@"C:\workspace\wsYAXGL\xml-gui\src\dotnet\yaxgl\TestApplication\test.xml");
        }
        
        //you can use the attributes like this
        [de.yaxgl.EventHandler(eventType=EventType.Click,eventID="button1")]
        public void clickButton1(Component sender,de.yaxgl.EventArgs args)
        {
            System.Console.WriteLine("Label: " + ((de.yaxgl.Button)sender).getLabel() + "\n" + args.ToString());
        }

        //and you can use the attributes like this, this is given by the construktor of EventHandler
        [de.yaxgl.EventHandler(EventType.SelectionChanged, "listbox1")]
        public void lisboxSelectionChanged(Component sender, de.yaxgl.EventArgs args)
        {
            String[] sarray=((de.yaxgl.ListBox)sender).getSelectedItems();
            foreach(string s in sarray)
            {
                System.Console.WriteLine(s);    
            }
            
        }

        [de.yaxgl.EventHandler(EventType.GotFocus, "button1")]
        public void focusButton1(Component sender, de.yaxgl.EventArgs args)
        {
            System.Console.WriteLine(((de.yaxgl.Button)sender).getLabel() + " has focus");
        }


        [de.yaxgl.EventHandler(EventType.Click, "label2")]
        public void clickLabel1(Component sender, de.yaxgl.EventArgs args)
        {
            try
            {
                System.Console.WriteLine("Label: " + ((Label)sender).getLabel() + "\n" + args.ToString());
            }
            catch (InvalidCastException e)
            {
                System.Console.WriteLine(e.Message);
            }
        }

        
        [de.yaxgl.EventHandler(EventType.Click, "imagebox1")]
        public void clickCheckBoxSex(Component sender, de.yaxgl.EventArgs args)
        {
            System.Console.WriteLine("Image clicked");
        }

        [de.yaxgl.EventHandler(EventType.SelectionChanged, "combobox1")]
        public void selectionChanged(Component sender, de.yaxgl.EventArgs args)
        {
            EditBox editBox = (EditBox)winManager.getWindowByID("window1").getComponentById("editbox1");
            editBox.setText(((de.yaxgl.ComboBox)sender).getSelectedItem());
            System.Console.WriteLine(((de.yaxgl.ComboBox)sender).getSelectedItem());
        }


        //you dont have a list of ids you can give one method more attributes for several ids
        //this is given by EventHandler usage AllowMultiple=true
        //[de.yaxgl.EventHandler(EventType.Click, "radio1")]
        //[de.yaxgl.EventHandler(EventType.Click, "radio2")]
        //or you can use regex
        [de.yaxgl.EventHandler(EventType.Click, "radio\\d")]
        public void radioKKlickChanged(Component sender, de.yaxgl.EventArgs args)
        {
            System.Console.WriteLine(((de.yaxgl.RadioButton)sender).getLabel());
        }


        [de.yaxgl.EventHandler(EventType.GotFocus, ".*")]
        public void somethingClicked(Component sender, de.yaxgl.EventArgs args)
        {
            System.Console.WriteLine("Something new got focus");
        }
    
    }
}
