from View.Qt.image_loader import LoadImageLabel

from PySide.QtGui import QFrame

class WarningClueView(QFrame): # Prolly could use a better name
    """ Represents a Warning Clue View """
    
    def __init__(self, parent=None):
        """ Initialize the Warning Clue View """
        QFrame.__init__(self, parent)
        self.resize(16, 15)
        self.loadImage()
        
    def loadImage(self):
        """ Load the Warning Image """
        self.image = LoadImageLabel("warning.gif", parent=self)
        self.image.move(0, 0)