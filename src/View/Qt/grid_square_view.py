from clue_view import ClueView
from mine_view import MineView

from PySide.QtCore import Qt
from PySide.QtGui import QFrame, QImage, QLabel, QMatrix, QPixmap

class GridSquareView(QFrame):
    """ Represents the Graphical view of the Grid Square """
    GRID_SQUARE_SIZE = 64

    def __init__(self, gridSquare, minefieldView):
        """ Initialize the grid square view """
        QFrame.__init__(self, minefieldView)
        
        self.gridSquare = gridSquare
        self.minefieldView = minefieldView
        
        self.scaled_grid_square = None
        self.scaled_scanned_grid_square = None
        self.clueView = ClueView(self.gridSquare.clue, self)
        self.loadGridSquareImage()
        
        if self.gridSquare.mined():
            self.mineView = MineView(self.gridSquare.contents[0], self)
            
        self.resize(64, 64)
        #self.move()
        self.clueView.raise_()

    def loadGridSquareImage(self):
        """ Load the grid square image """
        self.unscaled_grid_square = QImage("GridSquare.png")
        self.scaled_grid_square = self.unscaled_grid_square.scaled(self.GRID_SQUARE_SIZE, self.GRID_SQUARE_SIZE)
        self.grid_square_pixmap = QPixmap()
        self.grid_square_pixmap.convertFromImage(self.scaled_grid_square)
        self.grid_square_label = QLabel(self)
        self.grid_square_label.setPixmap(self.grid_square_pixmap)
        self.grid_square_label.move(0, 0)
        self.grid_square_label.setVisible(True)
        self.grid_square_label.stackUnder(self.clueView)
        
        self.unscaled_scanned_grid_square = QImage("ScannedGridSquare.png")
        self.scaled_scanned_grid_square = self.unscaled_scanned_grid_square.scaled(self.GRID_SQUARE_SIZE, self.GRID_SQUARE_SIZE)
        self.scanned_grid_square_pixmap = QPixmap()
        self.scanned_grid_square_pixmap.convertFromImage(self.scaled_scanned_grid_square)
        self.scanned_grid_square_label = QLabel(self)
        self.scanned_grid_square_label.setPixmap(self.scanned_grid_square_pixmap)
        self.scanned_grid_square_label.move(0, 0)
        self.scanned_grid_square_label.setVisible(False)
        self.scanned_grid_square_label.stackUnder(self.clueView)
        
    def updateView(self):
        """ Update the Grid Square View """
        if self.gridSquare.scanned:
            self.grid_square_label.setVisible(False)
            self.scanned_grid_square_label.setVisible(True)
            self.clueView.updateView()
            
            if self.gridSquare.mined():
                self.mineView.setVisible(True)
                
        if self.gridSquare.mined():
            self.mineView.updateView()
            
    def getXCoordinate(self):
        """ Return the X Coordinate of the Grid Square """
        return self.minefieldView.x + self.gridSquare.column*self.GRID_SQUARE_SIZE
        
    def getYCoordinate(self):
        """ Return the Y Coordinate of the Grid Square """
        return self.minefieldView.y + self.gridSquare.row*self.GRID_SQUARE_SIZE