from View.Qt.image_loader import LoadImageLabel

from PySide.QtGui import QFrame

class GridSquareFrame(QFrame):
    """ Represents a frame the size of a single Minefield Grid Square """
    GRID_SQUARE_SIZE = 64
    
    def __init__(self, parent=None):
        """ Initialize the Grid Square Frame """
        QFrame.__init__(self, parent)
        self.resize(self.GRID_SQUARE_SIZE, self.GRID_SQUARE_SIZE)
        
    def loadGridSquareSizedImage(self, filename, visible=True):
        """ Load a Grid Square Sized Image from the filename given """
        image = LoadImageLabel(filename, scaledXSize=self.GRID_SQUARE_SIZE, scaledYSize=self.GRID_SQUARE_SIZE, parent=self)
        image.move(0, 0)
        image.setVisible(visible)
        return image