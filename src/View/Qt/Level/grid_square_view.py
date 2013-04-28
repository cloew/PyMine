from clue_view import ClueView

from Mine.mine import Mine
from Mine.fragile_mine import FragileMine
from Mine.reverse_mine import ReverseMine

from View.Qt.Level.grid_square_frame import GridSquareFrame
from View.Qt.Mine.mine_view import MineView
from View.Qt.Mine.fragile_mine_view import FragileMineView
from View.Qt.Mine.reverse_mine_view import ReverseMineView

class GridSquareView(GridSquareFrame):
    """ Represents the Graphical view of the Grid Square """
    MineToViewDictionary = {Mine:MineView,
                            FragileMine:FragileMineView,
                            ReverseMine:ReverseMineView}

    def __init__(self, gridSquare, minefieldView):
        """ Initialize the grid square view """
        GridSquareFrame.__init__(self, minefieldView)
        
        self.gridSquare = gridSquare
        self.minefieldView = minefieldView
        self.clueView = ClueView(self.gridSquare.clue, self)
        self.loadGridSquareImages()
        
        self.setupMine()
            
        self.clueView.raise_()
        
    def setupMine(self):
        """  """
        if self.gridSquare.mined():
            content = self.gridSquare.getContent()
            if content.__class__ in self.MineToViewDictionary:
                self.mineView = self.MineToViewDictionary[content.__class__](content, self)
            else:
                self.mineView = MineView(content, self)
        else:
            self.mineView = None

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
            self.revealMine()
        else:
            self.grid_square_label.setVisible(True)
            self.scanned_grid_square_label.setVisible(False)
                
        if self.gridSquare.mined():
            self.mineView.updateView()
            
    def representNewGridSquare(self, gridSquare):
        """ Tells the Grid Square View to represent a new Grid Square """
        self.gridSquare = gridSquare
        self.clueView.clue = gridSquare.clue
        
        if self.mineView is not None:
            self.mineView.setParent(None)
            self.mineView = None
            
        self.setupMine()
        self.updateView()
        self.clueView.updateView()
        self.clueView.raise_()
            
    def revealMine(self):
        """ Reveal the Mine (if any) in this Grid Square """
        if self.gridSquare.mined():
                self.mineView.setVisible(True)
            
    def getXCoordinate(self):
        """ Return the X Coordinate of the Grid Square """
        return self.minefieldView.x + self.gridSquare.column*self.GRID_SQUARE_SIZE
        
    def getYCoordinate(self):
        """ Return the Y Coordinate of the Grid Square """
        return self.minefieldView.y + self.gridSquare.row*self.GRID_SQUARE_SIZE