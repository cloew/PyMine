from grid_square_view import GridSquareView

from PySide.QtCore import Qt
from PySide.QtGui import QFrame, QImage, QLabel, QMatrix, QPixmap

class DroneView(QFrame):
    """ Represents the Graphical view of the Drone """

    def __init__(self, drone_model, parent=None):
        """ Initialize the drone view """
        QFrame.__init__(self, parent)
        self.drone_model = drone_model
        
        self.scaled_drone = None
        self.loadDroneImage()
        self.resize(64, 64)

    def loadDroneImage(self):
        """ Load the drone image """
        self.unscaled_drone = QImage("Drone2Clear.png")
        self.scaled_drone = self.unscaled_drone.scaled(GridSquareView.GRID_SQUARE_SIZE, GridSquareView.GRID_SQUARE_SIZE)
        self.drone_pixmap = QPixmap()
        self.drone_pixmap.convertFromImage(self.scaled_drone)
        self.drone_label = QLabel(self)
        self.drone_label.setPixmap(self.drone_pixmap)
        self.drone_label.move(0, 0)

    def draw(self, painter, minefieldView):
        """ Draw the image """
        painter.drawImage(minefieldView.x+self.drone_model.column*GridSquareView.GRID_SQUARE_SIZE, minefieldView.y+self.drone_model.row*GridSquareView.GRID_SQUARE_SIZE, self.scaled_drone)