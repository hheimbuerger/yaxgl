from xml.dom.minidom import parse
import wx
from de.yaxgl.Helper.LookAndFeel import LookAndFeel
from de.yaxgl.Container.Window import Window



class NotYetInitializedError(Exception):
    pass

class WindowManager:
    instance = None
    isInitialized = False
    
    def __init__(self):
        self.windows = []
        self.baseWindow = None
        self.app = wx.App(0)

    @classmethod
    def initialize(cls, lookAndFeel):
        if(lookAndFeel != LookAndFeel.System):
            raise NotSupportedException("Error: The LookAndFeel." + str(lookAndFeel) + " style is not supported in Python/wxWidgets applications.")
        else:
            cls.isInitialized = True

    @classmethod
    def getInstance(cls):
        if(not cls.isInitialized):
            raise NotYetInitializedException("Error: You have to initialize the WindowManager with a LookAndFeel before you can get an instance");

        elif(not cls.instance):
            cls.instance = WindowManager()
            
        return(cls.instance)

    def createWindow(self, xmlFile, eventReceiver):
        window = Window(xmlFile)
        window.registerEventHandlers(eventReceiver)
        self.windows.append(window)
        return(window)

    def run(self, window):
        #if(baseWindow == None):
        #    raise
        #Application.Run((Form)baseWindow.getNativeComponent());
        window.show()
        self.app.MainLoop()

    def show(self, window):
        window.Show(True)

    def showModal(self, window, parentWindow):
        pass

    def hide(self, window):
        window.Show(False)

    def close(self, window):
        if(window in self.windows):
            del self.windows[window]
        window.Close()

    def getWindowsByID(self, ID):
#===============================================================================
#            IList<Window> matchingWindows = new List<Window>();
#            foreach (Window window in windows)
#            {
#                if (window.getID().Equals(ID))
#                    matchingWindows.Add(window);
#            
#            }
#            return matchingWindows;
#===============================================================================
        pass
