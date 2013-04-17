from grid_square_view import GridSquareView

from PySide.QtCore import Qt
from PySide.QtGui import QImage, QMatrix

class DroneView:
    """ Represents the Graphical view of the Drone """

    def __init__(self, drone_model):
        """ Initialize the drone view """
        self.drone_model = drone_model
        
        self.scaled_drone = None
        self.loadDroneImage()

    def loadDroneImage(self):
        """ Load the drone image """
        self.unscaled_drone = QImage("Drone2.png")
        self.scaled_drone = self.unscaled_drone.scaled(GridSquareView.GRID_SQUARE_SIZE, GridSquareView.GRID_SQUARE_SIZE)

    def draw(self, painter, minefieldView):
        """ Draw the image """
        painter.drawImage(minefieldView.x+self.drone_model.column*GridSquareView.GRID_SQUARE_SIZE, minefieldView.y+self.drone_model.row*GridSquareView.GRID_SQUARE_SIZE, self.scaled_drone)