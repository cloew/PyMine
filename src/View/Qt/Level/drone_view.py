from grid_square_view import GridSquareView
from View.Qt.image_loader import LoadImageLabel

from PySide.QtGui import QFrame

class DroneView(QFrame):
    """ Represents the Graphical view of the Drone """

    def __init__(self, drone_model, parent=None):
        """ Initialize the drone view """
        QFrame.__init__(self, parent)
        self.drone_model = drone_model
        
        self.loadDroneImage()
        self.resize(64, 64)

    def loadDroneImage(self):
        """ Load the drone image """
        self.drone_label = LoadImageLabel("Drone2Clear.png", scaledXSize=GridSquareView.GRID_SQUARE_SIZE, scaledYSize=GridSquareView.GRID_SQUARE_SIZE, parent=self)
        self.drone_label.move(0, 0)