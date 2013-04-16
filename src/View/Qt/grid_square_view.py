from clue_view import ClueView

from PySide.QtCore import Qt
from PySide.QtGui import QImage, QMatrix

class GridSquareView:
    """ Represents the Graphical view of the Grid Square """
    GRID_SQUARE_SIZE = 64

    def __init__(self, gridSquare):
        """ Initialize the grid square view """
        self.gridSquare = gridSquare
        self.scaled_grid_square = None
        self.loadGridSquareImage()
        
        self.clueView = ClueView(self.gridSquare.clue)

    def loadGridSquareImage(self):
        """ Load the grid square image """
        self.unscaled_grid_square = QImage("GridSquare.png")
        self.scaled_grid_square = self.unscaled_grid_square.scaled(self.GRID_SQUARE_SIZE, self.GRID_SQUARE_SIZE)

    def draw(self, painter, window):
        """ Draw the image """
        painter.drawImage(self.gridSquare.column*self.GRID_SQUARE_SIZE, self.gridSquare.row*self.GRID_SQUARE_SIZE, self.scaled_grid_square)
        if self.gridSquare.scanned:
            self.clueView.draw(painter, self.gridSquare) 