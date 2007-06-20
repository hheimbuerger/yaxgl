import wx
from de.yaxgl.Base.Control import Control



class ComboBox(Control):
    
    def __init__(self, owner, ID):
        Control.__init__(self)
        self.owner = owner
        self.ID = ID
        
    def initializeNativeControl(self, xmlElement):
        itemList = []
        for node in xmlElement.childNodes:
            if(node.nodeType == node.ELEMENT_NODE and node.localName == "item"):
                itemList.append(node.getAttribute("label"))
        self.control = wx.ComboBox(parent=self.owner.panel,
                                 pos=wx.Point(int(xmlElement.getAttribute("xpos")), int(xmlElement.getAttribute("ypos"))),
                                 size=wx.Size(int(xmlElement.getAttribute("width")), int(xmlElement.getAttribute("height"))),
                                 style=wx.CB_READONLY,
                                 choices=itemList
                                )
        self.control.Bind(wx.EVT_COMBOBOX, self.onSelectionEvent)
        self.select(xmlElement.getAttribute("selected"))
    
    def onSelectionEvent(self, event):
        self.selectionChangedEvent(self, event)

    def addItem(self, item):
        raise NotYetImplementedError("ComboBox::addItem() not yet implemented in the Python/wxWidgets library!")
    
    def addRange(self, items):
        raise NotYetImplementedError("ComboBox::addItem() not yet implemented in the Python/wxWidgets library!")
    
    def clearItems(self):
        raise NotYetImplementedError("ComboBox::addItem() not yet implemented in the Python/wxWidgets library!")
    
    def select(self, selection):
        self.control.SetStringSelection(selection)
    
    def getSelectedItem(self):
        return(self.control.GetValue())
