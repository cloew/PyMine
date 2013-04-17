from PySide.QtCore import Qt
from PySide.QtGui import QImage, QMatrix

class MineView:
    """ Represents the Graphical view of the Drone """

    def __init__(self, mine):
        """ Initialize the drone view """
        self.mine = mine
        self.scaled_mine = None
        self.scaled_defused_mine = None
        self.loadMineImage()

    def loadMineImage(self):
        """ Load the drone image """
        self.unscaled_mine = QImage("Mine1.png")
        self.scaled_mine = self.unscaled_mine.scaled(64, 64)
        
        self.unscaled_defused_mine = QImage("DefusedMine1.png")
        self.scaled_defused_mine = self.unscaled_defused_mine.scaled(64, 64)

    def draw(self, painter, gridSquareView):
        """ Draw the image """
        if self.mine.defused:
            painter.drawImage(gridSquareView.getXCoordinate(), gridSquareView.getYCoordinate(), self.scaled_defused_mine)
        else:
            painter.drawImage(gridSquareView.getXCoordinate(), gridSquareView.getYCoordinate(), self.scaled_mine)