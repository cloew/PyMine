from drone_view import DroneView
from grid_square_view import GridSquareView
from View.Qt.Level.grid_square_frame import GridSquareFrame

from PySide.QtGui import QColor, QFrame

class MinefieldView(QFrame):
    """ Represents the Graphical view of the Minefield """
    ROWS_DISPLAYED = 4
    COLUMNS_DISPLAYED = 5

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
        
        self.row = 0
        self.column = 0
        
    def setup(self):
        """ Setup the View """
        self.setupMineFieldSquares()
        self.setupDrone()
        
    def setupMineFieldSquares(self):
        """ Setup the Mine Field Squares """
        self.gridSquareViews = []
        columnCount = 0
        rowCount = 0
        
        for rowIndex in range(self.ROWS_DISPLAYED):
            if rowIndex >= self.minefield.rowCount():
                break
            for columnIndex in range(self.COLUMNS_DISPLAYED):
                if columnIndex >= self.minefield.columnCount():
                    break
                square = self.minefield.getSquare(rowIndex, columnIndex)
                gridSquareView = GridSquareView(square, self)
                self.gridSquareViews.append(gridSquareView)
                gridSquareView.move(self.x+GridSquareFrame.GRID_SQUARE_SIZE*columnIndex, self.y+GridSquareFrame.GRID_SQUARE_SIZE*rowIndex)

    def setupDrone(self):
        """ Setup the DroneView """
        self.droneView = DroneView(self.drone, self)
        
    def updateView(self):
        """ Update the View """
        for square in self.gridSquareViews:
            square.updateView()
            
        if self.droneOnScreen():
            self.droneView.setVisible(True)
            gridSquareView = self.getGridSquareView(self.drone.row, self.drone.column)
            self.droneView.move(gridSquareView.x(), gridSquareView.y())
        else:
            self.droneView.setVisible(False)
        
    def updateMineFieldGridSquares(self):
        """ Update the Minefield to ensure the proper Grid Squares are shown """
        if not self.droneOnScreen():
            """ """
        
    def droneOnScreen(self):
        """ Returns if the Drone is in the section of the Minefield shown """
        if self.drone.row < self.row or self.drone.row >= self.row + self.ROWS_DISPLAYED:
            return False
        elif self.drone.column < self.column or self.drone.column >= self.column + self.COLUMNS_DISPLAYED:
            return False
        return True
        
        
    def revealAllMines(self):
        """ Reveal all Mines on the bored """
        for gridSquareView in self.gridSquareViews:
            gridSquareView.revealMine()
        
    def getGridSquareView(self, row, column):
        """ Return the Grid Square View at the given row/column """
        for gridSquareView in self.gridSquareViews:
            if gridSquareView.gridSquare.row == row and gridSquareView.gridSquare.column == column:
                return gridSquareView
        else:
            return None
        
    def getWidth(self):
        """ Return the width """
        return GridSquareFrame.GRID_SQUARE_SIZE*6
        
    def getHeight(self):
        """ Return the height """
        return GridSquareFrame.GRID_SQUARE_SIZE*5