from drone_view import DroneView
from grid_square_view import GridSquareView

from PySide.QtCore import Qt
from PySide.QtGui import QImage, QMatrix

class MinefieldView:
    """ Represents the Graphical view of the Minefield """

    def __init__(self, minefield, drone):
        """ Initialize the grid square view """
        self.minefield = minefield
        self.drone = drone
        
        self.gridSquareViews = []
        for square in self.minefield.squares:
            self.gridSquareViews.append(GridSquareView(square))
        self.droneView = DroneView(drone)

    def draw(self, painter, window):
        """ Draw the image """
        for square in self.gridSquareViews:
            square.draw(painter, window)
        self.droneView.draw(painter, window)