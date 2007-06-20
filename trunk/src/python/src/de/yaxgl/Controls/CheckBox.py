import wx
from de.yaxgl.Base.Control import Control



class CheckBox(Control):
    
    def __init__(self, owner, ID):
        Control.__init__(self)
        self.owner = owner
        self.ID = ID
        
    def initializeNativeControl(self, xmlElement):
        self.control = wx.CheckBox(parent=self.owner.panel,
                                 pos=wx.Point(int(xmlElement.getAttribute("xpos")), int(xmlElement.getAttribute("ypos"))),
                                 size=wx.Size(int(xmlElement.getAttribute("width")), int(xmlElement.getAttribute("height")))
                                )
        self.control.Bind(wx.EVT_CHECKBOX, self.onClickEvent)
        self.setLabel(xmlElement.getAttribute("label"))
        self.setChecked(xmlElement.getAttribute("checked") == "true")
    
    def setChecked(self, checkedState):
        self.control.SetValue(checkedState);

    def isChecked(self):
        return(self.control.GetValue());

    def getLabel(self):
        return(self.control.GetLabelText())
    
    def setLabel(self, label):
        self.control.SetLabel(label)

    def onClickEvent(self, event):
        self.clickEvent(self, event)
