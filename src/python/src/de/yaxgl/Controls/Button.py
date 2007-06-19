import wx
from de.yaxgl.Base.Control import Control



class Button(Control):
    
    def __init__(self, owner, ID):
        Control.__init__(self)
        self.owner = owner
        self.ID = ID
        self.control = wx.Button(parent=owner.getNativeComponent())

        self.control.Bind(wx.EVT_BUTTON, self.onButtonClick)

    def initializeNativeControl(self, xmlElement):
        self.control.SetDimensions(int(xmlElement.getAttribute("xpos")),
                                   int(xmlElement.getAttribute("ypos")),
                                   int(xmlElement.getAttribute("width")),
                                   int(xmlElement.getAttribute("height"))
                                   )
        self.setLabel(xmlElement.getAttribute("label"))
    
    def getLabel(self):
        return(self.control.GetLabelText())
    
    def setLabel(self, label):
        self.control.SetLabel(label)

    def onButtonClick(self, event):
        self.clickEvent(self, event)
