import de.yaxgl.Base.Component;
import de.yaxgl.Container.*;

import de.yaxgl.Controls.*;
import de.yaxgl.EventDispatcher.EventArgs;
import de.yaxgl.EventDispatcher.Attribute.EventHandler;
import de.yaxgl.EventDispatcher.Attribute.EventType;
import de.yaxgl.Helper.LookAndFeel;

public class Start {

	private WindowManager windowManager=null;
	
	public Start()
	{
		try {
			WindowManager.initialize(LookAndFeel.System);
			windowManager=WindowManager.getInstance();
			Window window=windowManager.createWindow("test.xml", this);
			windowManager.run(window);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	@EventHandler(eventType=EventType.Click,eventID="listbox1")
	public void listboxHandler(Component sender,EventArgs eventArgs)
	{
		for(String s :((ListBox)sender).getSelectedItems())
		{
			System.out.println(s);
			
		}
		
		
	}
	
	@EventHandler(eventType=EventType.Click,eventID="button1")
	public void buttonClick(Component sender,EventArgs eventArgs)
	{
		
		System.out.println("Button pushed");
		CheckBox box=(CheckBox)sender.getParentWindow().getComponentById("checkbox2");
		if(box.isChecked())
			box.setChecked(false);
		else
			box.setChecked(true);
	
	}
	
	@EventHandler(eventType=EventType.SelectionChanged,eventID="combo1")
	public void comboSelectionChanged(Component sender,EventArgs eventArgs)
	{
		System.out.println(((ComboBox)sender).getSelectedItem());
	}
	
	//@EventHandler(eventType=EventType.Click,eventID="checkbox1")
	@EventHandler(eventType=EventType.Click,eventID="checkbox\\d",regexOn=true)
	public void checkBox(Component sender,EventArgs eventArgs)
	{
		System.out.println(""+((CheckBox)sender).isChecked());
	}
	
	@EventHandler(eventType=EventType.GotFocus,eventID="button1")
	public void buttonGotFocus(Component sender,EventArgs eventArgs)
	{
		System.out.println(""+((Button)sender).getLabel()+ " got focus");
	}
	
	@EventHandler(eventType=EventType.LostFocus,eventID="button1")
	public void buttonLostFocus(Component sender,EventArgs eventArgs)
	{
		System.out.println(""+((Button)sender).getLabel()+ " lost focus");
	}
	
	
	public static void main(String[] args) {
		new Start();
	}
}
