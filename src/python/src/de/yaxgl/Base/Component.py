# abstract
class Component:

    def __init__(self):
        self.ID = None
        self.owner = None
        self.control = None
        
    def getID(self):
        return(self.ID)
    
    def getContainer(self):
        return(self.owner)
    
    def getParentWindow(self):
        if (isinstance(self.owner, Window) or (not self.owner)):
            return(self.owner)
        else:
            return(self.owner.getParentWindow())

    def setBounds(self, xpos, ypos, width, height):
        self.control.setBounds(xpos, ypos, width, height)
        
    def getDimension(self):
        return(Dimension(self.control.width, self.control.Height))
    
    def setDimension(self, dimension):
        # DEBUG: to fix
        self.control.width = dimension.getWidth()
        self.control.height = dimension.getHeight()

    def setPosition(self, position):
        pass
        # DEBUG: this.control.Location= new System.Drawing.Point(position.getX(),position.getY());

    def getPosition(self):
        return(Position(self.control.Location.X, self.control.Location.Y))

    def getNativeComponent(self):
        return(self.control)



    #===============================================================================
    #    ABSTRACT METHODS
    #===============================================================================

    # taken from the Python IAQ (Infrequently Asked Questions): http://norvig.com/python-iaq.html
    # Question: "Can you implement abstract classes in Python in 0 lines of code? Or 4?"
    def abstract(self):
        import inspect
        caller = inspect.getouterframes(inspect.currentframe())[1][3]
        raise NotImplementedError(caller + ' must be implemented in subclass')
    
    def initializeNativeControl(self, xmlElement):
        self.abstract()
