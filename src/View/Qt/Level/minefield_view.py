from drone_view import DroneView
from grid_square_view import GridSquareView
from View.Qt.Level.grid_square_frame import GridSquareFrame

from PySide.QtGui import QColor, QFrame

class MinefieldView(QFrame):
    """ Represents the Graphical view of the Minefield """

    def __init__(self, minefield, drone, parent=None):
        """ Initialize the grid square view """
        QFrame.__init__(self, parent)
        
        self.minefield = minefield
        self.drone = drone
        
        self.x = GridSquareFrame.GRID_SQUARE_SIZE/2
        self.y = GridSquareFrame.GRID_SQUARE_SIZE/2
        
        self.setup()
        
        self.color = QColor(200, 200, 200)
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
                gridSquareView = GridSquareView(square, self)
                self.gridSquareViews.append(gridSquareView)
                gridSquareView.move(gridSquareView.getXCoordinate(), gridSquareView.getYCoordinate())

    def setupDrone(self):
        """ Setup the DroneView """
        self.droneView = DroneView(self.drone, self)
        
    def updateView(self):
        """ Update the View """
        for square in self.gridSquareViews:
            square.updateView()
            
        gridSquareView = self.getGridSquareView(self.drone.row, self.drone.column)
        self.droneView.move(gridSquareView.getXCoordinate(), gridSquareView.getYCoordinate())
        
    def revealAllMines(self):
        """ Reveal all Mines on the bored """
        for gridSquareView in self.gridSquareViews:
            gridSquareView.revealMine()
        
    def getGridSquareView(self, row, column):
        """ Return the Grid Square View at the given row/column """
        index = self.minefield.columnCount()*row+column
        return self.gridSquareViews[index]
        
    def getWidth(self):
        """ Return the width """
        return GridSquareFrame.GRID_SQUARE_SIZE*6
        
    def getHeight(self):
        """ Return the height """
        return GridSquareFrame.GRID_SQUARE_SIZE*5