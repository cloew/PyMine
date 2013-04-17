from drone_view import DroneView
from grid_square_view import GridSquareView

from PySide.QtGui import QColor

class MinefieldView:
    """ Represents the Graphical view of the Minefield """

    def __init__(self, minefield, drone):
        """ Initialize the grid square view """
        self.minefield = minefield
        self.drone = drone
        
        self.gridSquareViews = []
        for row in self.minefield.squares:
            for square in row:
                self.gridSquareViews.append(GridSquareView(square, self))
        self.droneView = DroneView(drone)

    def draw(self, painter, window):
        """ Draw the image """
        self.x = 32
        self.y = 32
        
        painter.fillRect(0, 0, GridSquareView.GRID_SQUARE_SIZE*6, GridSquareView.GRID_SQUARE_SIZE*5, QColor(0, 0, 0))
        
        for square in self.gridSquareViews:
            square.draw(painter, self)
        self.droneView.draw(painter, self)