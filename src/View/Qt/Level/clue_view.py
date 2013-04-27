from PySide.QtCore import Qt
from PySide.QtGui import QColor, QFont, QFrame, QLabel

class ClueView(QFrame):
    """ Represents the Graphical view of the Drone """

    def __init__(self, clue, parent=None):
        """ Initialize the drone view """
        QFrame.__init__(self, parent)
        self.clue = clue
        
        self.setupClueLabel()
        self.resize(64, 64)
        
    def setupFont(self):
        """ Setup the Font """
        self.font = QFont()
        self.font.setPointSize(40)
        
    def setupClueLabel(self):
        """ Setup the Clue Label """
        self.setupFont()
        self.clueLabel = QLabel(str(self.clue), self)
        self.clueLabel.setFont(self.font)
        self.clueLabel.move(18, 0)
        
    def updateView(self):
        """ Update the View """
        self.clueLabel.setText(str(self.clue))
        self.setColorBasedOnFragility()
        self.clueLabel.resize(34, self.clueLabel.contentsRect().height())
        
    def setColorBasedOnFragility(self):
        """ Set color of the clue based on adjacency to Fragile Mines """
        if self.clue.distance is None:
            color = "rgba(0, 0, 0, 75%)"
        elif self.clue.distance <= 1:
            color = "rgba(244, 0, 0, 75%)"
        elif self.clue.distance > 1 and self.clue.distance < 4:
            color = "rgba(244, 244, 0, 75%)"
        elif self.clue.distance >= 4:
            color = "rgba(0, 154, 0, 75%)"
        self.clueLabel.setStyleSheet("QLabel { color : %s }" % color)