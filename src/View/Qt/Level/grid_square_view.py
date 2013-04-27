from clue_view import ClueView
from View.Qt.Level.grid_square_frame import GridSquareFrame
from View.Qt.Mine.mine_view import MineView
from View.Qt.Mine.reverse_mine_view import ReverseMineView

class GridSquareView(GridSquareFrame):
    """ Represents the Graphical view of the Grid Square """

    def __init__(self, gridSquare, minefieldView):
        """ Initialize the grid square view """
        GridSquareFrame.__init__(self, minefieldView)
        
        self.gridSquare = gridSquare
        self.minefieldView = minefieldView
        self.clueView = ClueView(self.gridSquare.clue, self)
        self.loadGridSquareImages()
        
        if self.gridSquare.mined():
            if self.gridSquare.reversed():
                self.mineView = ReverseMineView(self.gridSquare.contents[0], self)
            else:
                self.mineView = MineView(self.gridSquare.contents[0], self)
            
        self.clueView.raise_()

    def loadGridSquareImages(self):
        """ Load the grid square image """
        self.grid_square_label = self.loadGridSquareSizedImage("GridSquare.png")
        self.scanned_grid_square_label = self.loadGridSquareSizedImage("ScannedGridSquare.png", visible=False)
        
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