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

        public Start(string xmlFile)
        {
            /*
            Window myWindow = new Window(xmlFile);
            myWindow.setBounds(100, 100, 600, 600);
            myWindow.registerEventHandlers(this);
            myWindow.show();
            */
            WindowManager winManager = new WindowManager();
            winManager.createWindow(xmlFile, this).show();
        }
        
        
        
        public static void Main()
        {
            Start s = new Start("c:\\test.xml");
        }

        
        
        [de.yaxgl.EventHandler(EventType.Click,"button1")]
        public void clickButton1(Component sender,de.yaxgl.EventArgs args)
        {
            System.Console.WriteLine("Label: " + ((de.yaxgl.Button)sender).getLabel() + "\n" + args.ToString());
        }


        [de.yaxgl.EventHandler(EventType.Focus, "button1")]
        public void focusButton1(Component sender, de.yaxgl.EventArgs args)
        {
            System.Console.WriteLine(((de.yaxgl.Button)sender).getLabel() + " has focus");
        }


        [de.yaxgl.EventHandler(EventType.Click, "label1")]
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

        /*
        [de.yaxgl.EventHandler(EventType.Click, "CheckBox1")]
        public void clickCheckBoxSex(Component sender, de.yaxgl.EventArgs args)
        {
            System.Console.WriteLine("Label: " + ((de.yaxgl.CheckBox)sender).getLabel() + "\n" + args.ToString());
        }

        [de.yaxgl.EventHandler(EventType.Click, "LabelGroup")]
        public void clickLabelGroup(Component sender, de.yaxgl.EventArgs args)
        {
            System.Console.WriteLine("Label: " + ((de.yaxgl.Label)sender).getLabel() + "\n" + args.ToString());
        }

        //TODO: müssen eine Liste von events unterstützen oder eben diese regex
        [de.yaxgl.EventHandler(EventType.Click, "radio1")]
        public void clickRadio(Component sender, de.yaxgl.EventArgs args)
        {
            System.Console.WriteLine("Label: " + ((de.yaxgl.RadioButton)sender).getLabel() + "\n" + args.ToString());
        }

        [de.yaxgl.EventHandler(EventType.SelectionChanged, "comboBox")]
        public void selectionChanged(Component sender, de.yaxgl.EventArgs args)
        {
            System.Console.WriteLine(((de.yaxgl.ComboBox)sender).getSelectedItem());
        }
    
         * 
         * 
         * */
    }
}
