from PySide.QtCore import Qt
from PySide.QtGui import QFont, QFrame, QLabel

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
        self.clueLabel.resize(34, self.clueLabel.contentsRect().height())
        #self.clueLabel.resize(100, 30)
        #self.clueLabel.move(20, 0)

    def draw(self, painter, gridSquareView):
        """ Draw the image """
        #painter.setFont(font)
        painter.drawText(gridSquareView.getXCoordinate()+10, gridSquareView.getYCoordinate()+54, str(self.clue))