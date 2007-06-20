import de.yaxgl.Container.*;
import de.yaxgl.Helper.LookAndFeel;
import de.yaxgl.Controls.*;
import de.yaxgl.Base.*;
import de.yaxgl.EventDispatcher.*;
import de.yaxgl.EventDispatcher.Attribute.*;



public class YaxglPizzabestellung {

    private WindowManager wm = null;
	private Window mainwin = null;
	
    
    
	public void run() throws Exception {
        WindowManager.initialize(LookAndFeel.System);
        wm = WindowManager.getInstance();
        mainwin = wm.createWindow("../Pizzabestellung_Hauptfenster.xml", this);
        wm.run(mainwin);
	}
    
    
    
	@EventHandler(eventType=EventType.Click, eventID="absenden")
	public void onSubmit(Component sender, EventArgs args) {
        ComboBox pizzaauswahl = (ComboBox)mainwin.getComponentById("pizzaauswahl");
        Label ergebnis = (Label)mainwin.getComponentById("bestellergebnis");
        ergebnis.setLabel("Ihre Bestellung einer Pizza " + pizzaauswahl.getSelectedItem() + " wurde versandt!");
	}
	
    
    
    
	public static void main(String[] args) throws Exception {
		new YaxglPizzabestellung().run();
	}

}
