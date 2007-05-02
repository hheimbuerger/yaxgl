# import the wxPython GUI package
import wx

import DemoWindow

#===============================================================================
# class App(wx.PyApp):
#    """Application class."""
# 
#    def OnInit(self):
#        self.frame = DemoWindow.DemoWindow()
#        self.frame.Show()
#        self.SetTopWindow(self.frame)
#        return True
# 
# def main():
#    app = App()
#    app.MainLoop()
#===============================================================================

#===============================================================================
# if __name__ == '__main__':
#    app = wx.PySimpleApp()
#    frame = DemoWindow()
#    frame.Show()
#    app.MainLoop()
#    #main()
#===============================================================================



# Every wxWidgets application must have a class derived from wx.App
class MyApp(wx.App):

    # wxWindows calls this method to initialize the application
    def OnInit(self):

        # Create an instance of our customized Frame class
        frame = DemoWindow.DemoWindow()
        frame.Show(True)

        # Tell wxWindows that this is our main window
        self.SetTopWindow(frame)

        # Return a success flag
        return True



app = MyApp(0)     # Create an instance of the application class
app.MainLoop()     # Tell it to start processing events

