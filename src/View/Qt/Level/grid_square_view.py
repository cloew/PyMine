from clue_view import ClueView

from View.Qt.Defense.content_view_factory import GetViewForDefense
from View.Qt.Level.grid_square_frame import GridSquareFrame

class GridSquareView(GridSquareFrame):
    """ Represents the Graphical view of the Grid Square """

    def __init__(self, gridSquare, minefieldView):
        """ Initialize the grid square view """
        GridSquareFrame.__init__(self, minefieldView)
        
        self.gridSquare = gridSquare
        self.minefieldView = minefieldView
        self.clueView = None
        self.loadGridSquareImages()
        
        self.setupDefenseView()
        self.setupClueView(self.gridSquare.clue)
        
    def setupDefenseView(self):
        """ Setup Defense View """
        if self.gridSquare.getGroundContent():
            defense = self.gridSquare.getGroundContent()
            self.defenseView = GetViewForDefense(defense, self)
            self.defenseView.raise_()
        else:
            self.defenseView = None
            
    def setupClueView(self, clue):
        """ Setup the Clue View """
        if self.clueView is None:
            self.clueView = ClueView(self.gridSquare.clue, self)
        else:
            self.clueView.clue = clue
        self.clueView.raise_()

    def loadGridSquareImages(self):
        """ Load the grid square image """
        self.grid_square_label = self.loadGridSquareSizedImage("GridSquare.png")
        self.scanned_grid_square_label = self.loadGridSquareSizedImage("ScannedGridSquare.png", visible=False)
        
    def updateView(self):
        """ Update the Grid Square View """
        self.removeOldDefenseView()
        self.setupDefenseView()
        self.clueView.raise_()
        
        if self.gridSquare.scanned:
            """ """
            self.grid_square_label.hide()
            self.scanned_grid_square_label.show()
            self.clueView.updateView()
        else:
            self.grid_square_label.show()
            self.scanned_grid_square_label.hide()
                
        if self.gridSquare.getGroundContent() and self.defenseView is not None:
            self.defenseView.updateView()
            
    def representNewGridSquare(self, gridSquare):
        """ Tells the Grid Square View to represent a new Grid Square """
        self.gridSquare = gridSquare
        self.removeOldDefenseView()
        self.setupDefenseView()
        self.setupClueView(gridSquare.clue)
        self.updateView()
        self.clueView.updateView()
        
    def removeOldDefenseView(self):
        """ Remove the old Mine View, if any """
        if self.defenseView is not None:
            self.defenseView.setParent(None)
            self.defenseView = None
            
    def revealMine(self):
        """ Reveal the Mine (if any) in this Grid Square """
        if self.gridSquare.getGroundContent() and self.defenseView is not None:
                self.defenseView.show()
            
    def getXCoordinate(self):
        """ Return the X Coordinate of the Grid Square """
        return self.minefieldView.x + self.gridSquare.column*self.GRID_SQUARE_SIZE
        
    def getYCoordinate(self):
        """ Return the Y Coordinate of the Grid Square """
        return self.minefieldView.y + self.gridSquare.row*self.GRID_SQUARE_SIZE