from xml.dom.minidom import parse
import wx
from de.yaxgl.Container.Container import Container
from de.yaxgl.EventDispatcher.EventHandlerManager import EventHandlerManager



class Window(Container):
    
    def __init__(self, xmlFile):
        Container.__init__(self)
        self.owner = None
        self.eventHandlerManager = EventHandlerManager()
        
        dom = parse(xmlFile)
        self.parseXML(dom.documentElement)

    def initializeNativeControl(self, xmlElement):
        self.ID = xmlElement.getAttribute("id")
        windowStyle = wx.SYSTEM_MENU | wx.CAPTION | wx.CLOSE_BOX | wx.CLIP_CHILDREN
        if(xmlElement.getAttribute("maximizeBox") == "true"):
            windowStyle |= wx.MAXIMIZE_BOX
        if(xmlElement.getAttribute("minimizeBox") == "true"):
            windowStyle |= wx.MINIMIZE_BOX
        if(xmlElement.getAttribute("showInTaskbar") == "false"):
            windowStyle |= wx.FRAME_NO_TASKBAR
        if(xmlElement.getAttribute("borderStyle") == "fixed"):
            pass
        elif(xmlElement.getAttribute("borderStyle") == "none"):
            raise NotYetImplementedException("borderStyle==none not implemented in Python/wxWidgets")
        else:
            windowStyle |= wx.RESIZE_BORDER
        self.control = wx.Frame(parent=None,
                                style=windowStyle,
                                pos=wx.Point(int(xmlElement.getAttribute("xpos")), int(xmlElement.getAttribute("ypos"))),
                                size=wx.Size(int(xmlElement.getAttribute("width")), int(xmlElement.getAttribute("height")))
                                )
        self.panel = wx.Panel(self.control)
        #self.control.SetAutoLayout(False)
        #self.control.SetSizer(None)
        self.control.SetLabel(xmlElement.getAttribute("title"))
        if(xmlElement.hasAttribute("icon")):
            wx.InitAllImageHandlers()
            #image = wx.Image(xmlElement.getAttribute("icon"), wx.BITMAP_TYPE_ICO)
            #image = image.ConvertToBitmap()
            
            #icon = wx.EmptyIcon()
            #icon.CopyFromBitmap(image)
            icon = wx.Icon(xmlElement.getAttribute("icon"), wx.BITMAP_TYPE_ICO)
            
            self.control.SetIcon(icon)
        
            
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
