import wx

#from frame import Frame



class ControlFactory:
    @staticmethod
    def createButton(parent, ID, topLeft, size, label):
        button = wx.Button(parent, id=-1, label=label, pos=topLeft, size=size)
        button.name = ID
        return(button)
    
    @staticmethod
    def createEditbox(parent, ID, topLeft, size, text):
        editbox = wx.TextCtrl(parent, id=-1, pos=topLeft, size=size)
        editbox.SetValue(text)
        editbox.name = ID
        return(editbox)
        


class XmlBasedWindow(wx.Frame):
    def __init__(self, pathToXML):
        # create the frame
        wx.Frame.__init__(self, None, -1, "This is a test")
        #wx.PyWindow.__init__(self, None, -1, wx.DefaultPosition, wx.DefaultSize, wx.DEFAULT_FRAME_STYLE, "This is a test")
        #wx.Frame.__init__(self, None, "window", "title", wx.DefaultPosition, wx.DefaultSize, wx.DEFAULT_FRAME_STYLE)
        
        # create a panel inside the frame
        self.panel = wx.Panel(self, -1)
        
        # prepare private attributes
        self.controls = []
        
        # read the XML and create the controls specified there
        self.parseXML(pathToXML)

    def OnCloseWindow(self, event):
        self.Destroy()
        
    def parseXML(self, pathToXML):
        # create the controls
        editbox = ControlFactory.createEditbox(self.panel, "text", (10, 10), (100, 25), "")
        button = ControlFactory.createButton(self.panel, "button", (10, 50), (100, 25), "Hello, world!")
        self.controls.append(editbox)
        self.controls.append(button)
        #button = wx.Button(panel, 1003, "Close Me")
        #button.SetPosition((15, 15))
        
        self.Bind(wx.EVT_CLOSE, self.OnCloseWindow)

    def getControlByID(self, ID):
        for c in self.controls:
            if(c.name == ID):
                return(c)
        return(None)
