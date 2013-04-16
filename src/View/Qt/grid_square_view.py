from PySide.QtCore import Qt
from PySide.QtGui import QImage, QMatrix

class GridSquareView:
    """ Represents the Graphical view of the Grid Square """

    def __init__(self, gridSquare):
        """ Initialize the grid square view """
        self.gridSquare = gridSquare
        self.scaled_grid_square = None
        self.loadGridSquareImage()

    def loadGridSquareImage(self):
        """ Load the grid square image """
        self.unscaled_grid_square = QImage("grid_square.png")
        self.scaled_grid_square = self.unscaled_grid_square.scaled(32, 32)

    def draw(self, painter, window):
        """ Draw the image """
        # Draw the image in the current grid cell
        #painter.drawImage(self.drone.rectangle.x*window.contentsRect().width()/100, self.ship_model.rectangle.y*window.contentsRect().height()/100, self.scaled_ship)