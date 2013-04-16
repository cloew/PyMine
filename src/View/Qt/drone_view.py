from PySide.QtCore import Qt
from PySide.QtGui import QImage, QMatrix

class DroneView:
    """ Represents the Graphical view of the Drone """

    def __init__(self, ship_model):
        """ Initialize the ship view """
        self.ship_model = ship_model
        self.scaled_ship = None
        self.loadShipImage()

    def loadShipImage(self):
        """ Load the ship image """
        self.unscaled_ship = QImage("drone2.png")
        self.scaled_ship = self.unscaled_ship.scaled(32, 32)

    def draw(self, painter, window):
        """ Draw the image """
        # Draw the image in the current grid cell
        #painter.drawImage(self.drone.rectangle.x*window.contentsRect().width()/100, self.ship_model.rectangle.y*window.contentsRect().height()/100, self.scaled_ship)