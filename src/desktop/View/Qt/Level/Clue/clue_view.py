from View.Qt.Level.grid_square_frame import GridSquareFrame
from View.Qt.Level.Clue.adjacency_clue_view import AdjacencyClueView
from View.Qt.Level.Clue.weapon_caution_clue_view import WeaponCautionClueView

from PySide.QtGui import QFont, QLabel

class ClueView(GridSquareFrame):
    """ Represents the Graphical view of the Drone """
    TRANSPARENCY = 100

    def __init__(self, clue, parent=None):
        """ Initialize the drone view """
        GridSquareFrame.__init__(self, parent)
        self.clue = clue
        
        self.adjacencyClue = AdjacencyClueView(clue.adjacencyClue, clue.fragilityClue, parent=self)
        self.adjacencyClue.move(45, 5)
        
        self.warningClue = WeaponCautionClueView(clue.weaponCautionClue, parent=self)
        self.warningClue.move(10, 10)
        
    def updateView(self):
        """ Update the View """
        self.adjacencyClue.updateView()
        self.warningClue.updateView()
        
    def representNewClue(self, clue):
        """ Represent a New Clue """
        self.clue = clue
        self.adjacencyClue.adjacencyClue = clue.adjacencyClue
        self.adjacencyClue.fragilityClue = clue.fragilityClue
        self.warningClue.clue = clue