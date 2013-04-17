from clue_view import ClueView
from mine_view import MineView

from PySide.QtCore import Qt
from PySide.QtGui import QImage, QMatrix

class GridSquareView:
    """ Represents the Graphical view of the Grid Square """
    GRID_SQUARE_SIZE = 64

    def __init__(self, gridSquare, minefieldView):
        """ Initialize the grid square view """
        self.gridSquare = gridSquare
        self.minefieldView = minefieldView
        
        self.scaled_grid_square = None
        self.scaled_scanned_grid_square = None
        self.loadGridSquareImage()
        
        self.clueView = ClueView(self.gridSquare.clue)
        if self.gridSquare.mined():
            self.mineView = MineView(self.gridSquare.contents[0])

    def loadGridSquareImage(self):
        """ Load the grid square image """
        self.unscaled_grid_square = QImage("GridSquare.png")
        self.scaled_grid_square = self.unscaled_grid_square.scaled(self.GRID_SQUARE_SIZE, self.GRID_SQUARE_SIZE)
        
        self.unscaled_scanned_grid_square = QImage("ScannedGridSquare.png")
        self.scaled_scanned_grid_square = self.unscaled_scanned_grid_square.scaled(self.GRID_SQUARE_SIZE, self.GRID_SQUARE_SIZE)

    def draw(self, painter, minefieldView):
        """ Draw the image """
        self.drawGridSquareBackground(painter)
        self.drawMine(painter)
        self.drawClue(painter)
            
    def drawGridSquareBackground(self, painter):
        """ Draw the Grid Square Background """
        if self.gridSquare.scanned:
            painter.drawImage(self.getXCoordinate(), self.getYCoordinate(), self.scaled_scanned_grid_square)
        else:
            painter.drawImage(self.getXCoordinate(), self.getYCoordinate(), self.scaled_grid_square)
            
    def drawMine(self, painter):
        """ Draw a Mine """
        if self.gridSquare.mined() and (self.gridSquare.scanned or self.gridSquare.contents[0].defused):
            self.mineView.draw(painter, self)
            
    def drawClue(self, painter):
        """ Draw the Clue """
        if self.gridSquare.scanned:
            self.clueView.draw(painter, self) 
            
    def getXCoordinate(self):
        """ Return the X Coordinate of the Grid Square """
        return self.minefieldView.x + self.gridSquare.column*self.GRID_SQUARE_SIZE
        
    def getYCoordinate(self):
        """ Return the Y Coordinate of the Grid Square """
        return self.minefieldView.y + self.gridSquare.row*self.GRID_SQUARE_SIZE
        return self.minefieldView.y + self.gridSquare.column*self.GRID_SQUARE_SIZE