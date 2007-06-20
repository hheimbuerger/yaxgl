from de.yaxgl.Container.WindowManager import WindowManager
from de.yaxgl.Helper.LookAndFeel import LookAndFeel
from de.yaxgl.EventDispatcher.Decorator.EventHandler import EventHandler
from de.yaxgl.EventDispatcher.Decorator.EventType import EventType
import wx        # JUST FOR DEBUGGING



class MyApp:
    def __init__(self):
        WindowManager.initialize(LookAndFeel.System)
        self.wm = WindowManager.getInstance()

    def run(self):
        self.mainwin = self.wm.createWindow("test.xml", self)
        self.wm.run(self.mainwin)
        
    @EventHandler(EventType.Click, "absenden")
    def onSubmit(self, source, event):
        pizzaauswahl = self.mainwin.getComponentById("pizzaauswahl")
        ergebnis = self.mainwin.getComponentById("bestellergebnis")
        ergebnis.setLabel("Ihre Bestellung einer Pizza " + pizzaauswahl.getSelectedItem() + " wurde versendet!")

#    @EventHandler(EventType.Any, ".*", True)
#    def handleButtonEvents(self, source, event):
#        text = "Event: source=%s, event=%s" % (str(source), str(event))
#        wx.MessageDialog(self.mainwin.getNativeComponent(), text).ShowModal()        #, style=wx.MessageDialog.wxOK



if(__name__ == "__main__"):        
    app = MyApp().run()
