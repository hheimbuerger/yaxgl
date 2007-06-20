from de.yaxgl.Container.WindowManager import WindowManager
from de.yaxgl.Helper.LookAndFeel import LookAndFeel
from de.yaxgl.EventDispatcher.Decorator.EventHandler import EventHandler
from de.yaxgl.EventDispatcher.Decorator.EventType import EventType





class YaxglPizzabestellung:
    
    
    
    
    
    
    def run(self):
        WindowManager.initialize(LookAndFeel.System)
        self.wm = WindowManager.getInstance()
        self.mainwin = self.wm.createWindow("../Pizzabestellung_Hauptfenster.xml", self)
        self.wm.run(self.mainwin)
        
        
        
        
    @EventHandler(EventType.Click, "absenden")
    def onSubmit(self, sender, args):
        pizzaauswahl = self.mainwin.getComponentById("pizzaauswahl")
        ergebnis = self.mainwin.getComponentById("bestellergebnis")
        ergebnis.setLabel("Ihre Bestellung einer Pizza " + pizzaauswahl.getSelectedItem() + " wurde versandt!")





if(__name__ == "__main__"):        
    YaxglPizzabestellung().run()
