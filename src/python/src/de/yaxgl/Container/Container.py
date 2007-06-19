from de.yaxgl.Base.Component import Component
from de.yaxgl.SimpleComponentFactory import SimpleComponentFactory



class Container(Component):
    
    def __init__(self):
        self.components = {}

    def add(self, containable):
        self.components[containable.getID()] = containable
        #self.control.Controls.add(containable.getNativeComponent())
        
    def remove(self, containable):
        del self.components[containable.getID()]
        #control.Controls.remove(containable.getNativeComponent())

    def getComponentById(self, ID):
        return(self.components[ID])

    # validates the xmlFile against the schemaFile and returns the root element on success
    def validateXmlDocument(self, urn, schemafile, xmlfile):
        return(True)

    # parsing the yaxgl xml file, generates from yaxgl xml file yaxgl components
    # and fills the components container
    def parseXML(self, rootElement):
        if(rootElement.localName == "window"):
            self.initializeNativeControl(rootElement)
        elif(rootElement.localName == "group"):
            dimension = Dimension(rootElement.getAttribute("width"), rootElement.getAttribute("height"))
            self.setDimension(dimension)

        for node in rootElement.childNodes:
            if(node.nodeType == node.ELEMENT_NODE):
                self.add(SimpleComponentFactory.createComponent(self, node))



    #===============================================================================
    #    ABSTRACT METHODS
    #===============================================================================

    # taken from the Python IAQ (Infrequently Asked Questions): http://norvig.com/python-iaq.html
    # Question: "Can you implement abstract classes in Python in 0 lines of code? Or 4?"
    def abstract(self):
        import inspect
        caller = inspect.getouterframes(inspect.currentframe())[1][3]
        raise NotImplementedError(caller + ' must be implemented in subclass')

    def notifyEvent(self, control, eventArgs):
        self.abstract()
