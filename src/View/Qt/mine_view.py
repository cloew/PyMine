from PySide.QtCore import Qt
from PySide.QtGui import QImage, QMatrix

class MineView:
    """ Represents the Graphical view of the Drone """

    def __init__(self, mine):
        """ Initialize the drone view """
        self.mine = mine
        self.scaled_mine = None
        self.loadMineImage()

    def loadMineImage(self):
        """ Load the drone image """
        self.unscaled_mine = QImage("Mine1.png")
        self.scaled_mine = self.unscaled_mine.scaled(64, 64)

    def draw(self, painter, gridSquare):
        """ Draw the image """
        painter.drawImage(gridSquare.column*64, gridSquare.row*64, self.scaled_mine)