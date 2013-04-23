from drone_view import DroneView
from grid_square_view import GridSquareView

from PySide.QtGui import QColor, QFrame

class MinefieldView(QFrame):
    """ Represents the Graphical view of the Minefield """

    def __init__(self, minefield, drone, parent=None):
        """ Initialize the grid square view """
        QFrame.__init__(self, parent)
        
        self.minefield = minefield
        self.drone = drone
        
        self.x = 32
        self.y = 32
        
        self.setup()
        
        self.color = QColor(0, 0, 0)
        #self.setStyleSheet("QFrame { background-color: %s }" % self.color.name()) 
        self.resize(self.getWidth(), self.getHeight())
        
    def setup(self):
        """ Setup the View """
        self.setupMineFieldSquares()
        self.setupDrone()
        
    def setupMineFieldSquares(self):
        """ Setup the Mine Field Squares """
        self.gridSquareViews = []
        for row in self.minefield.squares:
            for square in row:
                self.gridSquareViews.append(GridSquareView(square, self))

    def setupDrone(self):
        """ Setup the DroneView """
        self.droneView = DroneView(self.drone)
        
    def draw(self, painter, window):
        """ Draw the image """
        painter.fillRect(0, 0, self.getWidth(), self.getHeight(), QColor(0, 0, 0))
        
        for square in self.gridSquareViews:
            square.draw(painter, self)
        self.droneView.draw(painter, self)
        
    def getWidth(self):
        """ Return the width """
        return GridSquareView.GRID_SQUARE_SIZE*6
        
    def getHeight(self):
        """ Return the height """
        return GridSquareView.GRID_SQUARE_SIZE*5