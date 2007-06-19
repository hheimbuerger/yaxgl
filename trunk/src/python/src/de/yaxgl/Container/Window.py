from xml.dom.minidom import parse
import wx
from de.yaxgl.Container.Container import Container
from de.yaxgl.EventDispatcher.EventHandlerManager import EventHandlerManager



class Window(Container):
    
    def __init__(self, xmlFile):
        Container.__init__(self)
        self.owner = None
        self.eventHandlerManager = EventHandlerManager()
        self.control = wx.Frame(parent=None)
        
        dom = parse(xmlFile)
        self.parseXML(dom.documentElement)

    def initializeNativeControl(self, xmlElement):
        self.ID = xmlElement.getAttribute("id")
        self.control.SetDimensions(int(xmlElement.getAttribute("xpos")),
                                   int(xmlElement.getAttribute("ypos")),
                                   int(xmlElement.getAttribute("width")),
                                   int(xmlElement.getAttribute("height"))
                                   )
        self.control.SetLabel(xmlElement.getAttribute("title"))
#===============================================================================
#        setIcon(xmlElement.Attributes["icon"].InnerText);
#        minimizeable(Boolean.Parse(xmlElement.Attributes["minimizeBox"].InnerText));
#        maximizeable(Boolean.Parse(xmlElement.Attributes["maximizeBox"].InnerText));
#        showInTaskbar(Boolean.Parse(xmlElement.Attributes["showInTaskbar"].InnerText));
# 
#        string style = xmlElement.Attributes["borderStyle"].InnerText;
# 
#        if (style == "fixed")
#            setBorderStyle(WindowStyle.Fixed);
#        else if (style == "none")
#            setBorderStyle(WindowStyle.None);
#        else 
#            setBorderStyle(WindowStyle.Sizeable);
#===============================================================================

    def registerEventHandlers(self, eventReceiver):
        self.eventHandlerManager.registerEventHandlers(eventReceiver)
        
    def notifyEvent(self, control, eventArgs):
        self.eventHandlerManager.invokeHandlers(control, eventArgs)
        
    def showInTaskbar(self, show):
        pass

    def setBorderStyle(self, windowStyle):
        pass
#===============================================================================
#        public void setBorderStyle(WindowStyle windowStyle)
#        {
#            Form thisForm = (Form)this.control;
#            switch (windowStyle)
#            { 
#                case WindowStyle.Fixed:
#                    thisForm.FormBorderStyle = FormBorderStyle.FixedSingle;
#                    break;
#                case WindowStyle.None:
#                    thisForm.FormBorderStyle = FormBorderStyle.None;
#                    break;
#                case WindowStyle.Sizeable:
#                    thisForm.FormBorderStyle = FormBorderStyle.Sizable;
#                    break;
#            }
#        }
#===============================================================================
        
    def minimizeable(self, minimize):
        pass

    def maximizeable(self, maximize):
        pass

    def setIcon(self, icon):
        pass

    def getTitle(self):
        return(self.control.GetLabel())
    
    def setTitle(self, title):
        self.control.SetLabel(title)
        
    def show(self):
        self.control.Show(True)
    
    def showDialog(self, parentWindow):
        if(parentWindow):
            self.control.ShowDialog()
        else:
            self.owner = parentWindow
            self.control.ShowDialog(parentWindow.control)
        
    def hide(self):
        self.control.Show(False)
        
    def close(self):
        self.control.Close()
