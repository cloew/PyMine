from grid_square_view import GridSquareView
from View.Qt.image_loader import LoadImageLabel
from View.Qt.Level.grid_square_frame import GridSquareFrame

class DroneView(GridSquareFrame):
    """ Represents the Graphical view of the Drone """

    def __init__(self, drone_model, parent=None):
        """ Initialize the drone view """
        GridSquareFrame.__init__(self, parent)
        self.drone_model = drone_model
        
        self.drone_label = self.loadGridSquareSizedImage("Drone2Clear.png")