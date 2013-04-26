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
            color = QColor(0, 0, 0)
        elif self.clue.distance <= 1:
            color = QColor(255, 0, 0)
        elif self.clue.distance > 1 and self.clue.distance < 4:
            color = QColor(255, 255, 0)
        elif self.clue.distance >= 4:
            color = QColor(0, 255, 0)
        self.clueLabel.setStyleSheet("QLabel { color : %s }" % color.name())
        