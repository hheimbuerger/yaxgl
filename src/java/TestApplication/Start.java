import de.yaxgl.Base.Component;
import de.yaxgl.Container.*;
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
	
	@EventHandler(eventType=EventType.Click,eventID="button1",regexOn=false)
	public void buttonClick(Component sender,EventArgs eventArgs)
	{
		System.out.println("Hallo");
		
	}
	
	
	
	
	public static void main(String[] args) {
		new Start();
	}
}
