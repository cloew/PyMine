from View.Qt.Level.grid_square_frame import GridSquareFrame
from View.Qt.Level.warning_clue_view import WarningClueView

from PySide.QtGui import QFont, QLabel

class ClueView(GridSquareFrame):
    """ Represents the Graphical view of the Drone """
    TRANSPARENCY = 50

    def __init__(self, clue, parent=None):
        """ Initialize the drone view """
        GridSquareFrame.__init__(self, parent)
        self.clue = clue
        self.warningClue = WarningClueView(parent=self)
        self.warningClue.setVisible(False)
        self.warningClue.move(10, 10)
        self.setupClueLabel()
        
    def setupFont(self):
        """ Setup the Font """
        self.font = QFont()
        self.font.setPointSize(16)
        
    def setupClueLabel(self):
        """ Setup the Clue Label """
        self.setupFont()
        self.clueLabel = QLabel(str(self.clue), self)
        self.clueLabel.setFont(self.font)
        self.clueLabel.move(46, 5)
        
    def updateView(self):
        """ Update the View """
        self.clueLabel.setText(str(self.clue))
        self.setColorBasedOnFragility()
        self.checkWarning()
        self.clueLabel.resize(34, self.clueLabel.contentsRect().height())
        
    def setColorBasedOnFragility(self):
        """ Set color of the clue based on adjacency to Fragile Mines """
        color = "rgba({0}, {1}%)".format(self.getColor(), self.TRANSPARENCY)
        self.clueLabel.setStyleSheet("QLabel { color : %s }" % color)
        
    def getColor(self):
        """ Return color """
        if self.clue.distance is None:
            return "0, 0, 0"
        elif self.clue.distance <= 1:
            return "244, 0, 0"
        elif self.clue.distance > 1 and self.clue.distance < 4:
            return "244, 244, 0"
        elif self.clue.distance >= 4:
            return "0, 154, 0"
            
    def checkWarning(self):
        """ Check if the warning label should be displayed """
        self.warningClue.setVisible(self.clue.nearWeapons)