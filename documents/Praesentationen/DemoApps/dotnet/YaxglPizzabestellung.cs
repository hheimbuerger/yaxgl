using de.yaxgl;






namespace de.yaxgl {
    
public class YaxglPizzabestellung {
    
    private WindowManager wm = null;
    private Window mainwin = null;
    
    
    
    public void run() {
        WindowManager.initialize(LookAndFeel.System);
        wm = WindowManager.getInstance();
        mainwin = wm.createWindow("../Pizzabestellung_Hauptfenster.xml", this);
        wm.run(mainwin);
    }
    
    
    
    [EventHandler(eventType=EventType.Click, eventID="absenden")]
    public void onSubmit(Component sender, EventArgs args) {
        ComboBox pizzaauswahl = (ComboBox)mainwin.getComponentById("pizzaauswahl");
        Label ergebnis = (Label)mainwin.getComponentById("bestellergebnis");
        ergebnis.setLabel("Ihre Bestellung einer Pizza " + pizzaauswahl.getSelectedItem() + " wurde versandt!");
    }
    
    
    
    [STAThread]
    public static void Main() {
        new YaxglPizzabestellung().run();
    }
        
}

}
