from View.Qt.image_loader import LoadImageLabel
from View.Qt.Level.drone_view import DroneView
from View.Qt.Level.grid_square_view import GridSquareView
from View.Qt.Level.grid_square_frame import GridSquareFrame
from View.Qt.Level.minefield_grid_view import MinefieldGridView

from PySide.QtGui import QColor, QFrame

class MinefieldView(QFrame):
    """ Represents the Graphical view of the Minefield """

    def __init__(self, minefield, drone, parent=None):
        """ Initialize the grid square view """
        QFrame.__init__(self, parent)
        
        self.minefield = minefield
        self.drone = drone
        self.minefield_grid = MinefieldGridView(minefield, drone, parent=self)
        
        self.x = GridSquareFrame.GRID_SQUARE_SIZE/2
        self.y = GridSquareFrame.GRID_SQUARE_SIZE/2
        
        self.setup()
        
        self.color = QColor(200, 200, 200)
        #self.setStyleSheet("QFrame { background-color: %s }" % self.color.name()) 
        self.resize(self.getWidth(), self.getHeight())
        self.minefield_grid.move(self.x, self.y)
        #self.minefield_grid.raise_()
        
    def setup(self):
        """ Setup the View """
        self.setupArrows()
        
    def setupArrows(self):
        """ Setup Arrow Images """
        if self.needToDisplayArrows():
            self.upArrowLabel = self.loadArrow("UpArrow.png", self.getWidth()/2-8, 12)
            self.downArrowLabel = self.loadArrow("DownArrow.png", self.getWidth()/2-8, self.getHeight()-20)
            self.leftArrowLabel = self.loadArrow("LeftArrow.png", 12, self.getHeight()/2-8)
            self.rightArrowLabel = self.loadArrow("RightArrow.png", self.getWidth()-20, self.getHeight()/2-8)
            
    def loadArrow(self, filename, xPosition, yPosition):
        """ Load Arrow Image """
        arrowLabel = LoadImageLabel(filename, parent=self)
        arrowLabel.setVisible(False)
        arrowLabel.move(xPosition, yPosition)
        return arrowLabel
        
    def needToDisplayArrows(self):
        """ Need to Display Arrows """
        return self.minefield.rowCount() >= MinefieldGridView.ROWS_DISPLAYED or self.minefield.columnCount() >= MinefieldGridView.COLUMNS_DISPLAYED
        
    def updateView(self):
        """ Update the View """
        self.minefield_grid.updateView()
        self.updateArrows()
            
    def updateArrows(self):
        """ Update Arrows """
        self.upArrowLabel.setVisible(self.minefield_grid.row > 0)
        self.downArrowLabel.setVisible(self.minefield_grid.row+MinefieldGridView.ROWS_DISPLAYED < self.minefield.rowCount())
        self.leftArrowLabel.setVisible(self.minefield_grid.column > 0)
        self.rightArrowLabel.setVisible(self.minefield_grid.column+MinefieldGridView.COLUMNS_DISPLAYED < self.minefield.columnCount())
        
    def revealAllMines(self):
        """ Reveal all Mines on the board """
        self.minefield_grid.revealAllMines()
        
    def getWidth(self):
        """ Return the width """
        return GridSquareFrame.GRID_SQUARE_SIZE+self.minefield_grid.getWidth()
        
    def getHeight(self):
        """ Return the height """
        return GridSquareFrame.GRID_SQUARE_SIZE+self.minefield_grid.getHeight()