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
        self.unscaled_drone = QImage("drone2.png")
        self.scaled_drone = self.unscaled_drone.scaled(32, 32)

    def draw(self, painter, window):
        """ Draw the image """
        # Draw the image in the current grid cell
        #painter.drawImage(self.drone.rectangle.x*window.contentsRect().width()/100, self.ship_model.rectangle.y*window.contentsRect().height()/100, self.scaled_ship)