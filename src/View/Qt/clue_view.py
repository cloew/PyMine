from PySide.QtCore import Qt
from PySide.QtGui import QFont

class ClueView:
    """ Represents the Graphical view of the Drone """

    def __init__(self, clue):
        """ Initialize the drone view """
        self.clue = clue

    def draw(self, painter, gridSquare):
        """ Draw the image """
        font = QFont()
        font.setPointSize(54)
        painter.setFont(font)
        painter.drawText((gridSquare.column)*64, (gridSquare.row+1)*64, str(self.clue))