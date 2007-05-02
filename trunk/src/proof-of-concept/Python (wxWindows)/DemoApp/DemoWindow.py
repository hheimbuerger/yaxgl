import wx
from XMLBasedGUI.XmlBasedWindow import XmlBasedWindow



class DemoWindow(XmlBasedWindow):
    def __init__(self):
        XmlBasedWindow.__init__(self, "demo.xml")
        
        # bind button event
        button = self.getControlByID("button")
        self.Bind(wx.EVT_BUTTON, self.OnButtonClick, button)

    def OnButtonClick(self, event):
        editbox = self.getControlByID("text")
        wx.MessageDialog(self, editbox.GetValue()).ShowModal()        #, style=wx.MessageDialog.wxOK
