from View.Qt.image_loader import GetImageLabelFromImage, GetPixelMapFromImage, LoadImage, SetImageTransparency
from View.Qt.Level.grid_square_frame import GridSquareFrame

from PySide.QtGui import QColor, QImage, QPainter, QPixmap

class WormView(GridSquareFrame):
    """ Represents the Worm """
    REGULAR_IMAGE_FILENAME = "Worm.png"
    
    def __init__(self, worm, parent=None):
        """ Initialize the worm view """
        GridSquareFrame.__init__(self, parent)
        self.worm = worm
        self.loadMineImages()
        self.setVisible(False)
    
    def loadMineImages(self):
        """ Load the Mine images """
        self.mine_label = None
        self.original_mine_image = LoadImage(self.REGULAR_IMAGE_FILENAME, scaledXSize=64, scaledYSize=64)
        self.setLabelTransparency(100)
        
    def updateView(self):
        """ Update the View """
        if self.worm.deactivated:
            self.setLabelTransparency(100)
            self.setVisible(True)
        elif self.worm.attacking:
            
            self.setVisible(True)
        else:
            self.setVisible(False)
            
    def setLabelTransparency(self, transparencyPercentage):
        """ Set the Transparency of the label image """
        if self.mine_label is not None:
            self.mine_label.setParent(None)
        self.mine_image = QImage(self.original_mine_image)
        SetImageTransparency(self.mine_image, transparencyPercentage)
        self.mine_label = GetImageLabelFromImage(self.mine_image, parent=self)
        self.mine_label.move(0, 0)