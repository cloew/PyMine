from View.Qt.image_loader import LoadImageLabel

from PySide.QtGui import QFrame, QFont, QLabel

class AdjacencyClueView(QFrame): # Prolly could use a better name
    """ Represents the Adjacency Clue View """
    TRANSPARENCY = 100
    
    def __init__(self, adjacencyClue, fragilityClue, parent=None):
        """ Initialize the Adjacency Clue View """
        QFrame.__init__(self, parent)
        #self.clue = clue
        self.adjacencyClue = adjacencyClue
        self.fragilityClue = fragilityClue
        self.resize(34, 32)
        self.setupClueLabel()
        
    def setupFont(self):
        """ Setup the Font """
        self.font = QFont()
        self.font.setPointSize(15)
        
    def setupClueLabel(self):
        """ Setup the Clue Label """
        self.setupFont()
        self.clueLabel = QLabel('', self)
        self.clueLabel.setFont(self.font)
        self.clueLabel.move(0, 0)
        
    def updateView(self):
        """ Update the View """
        self.clueLabel.setText(self.getLabelText())
        self.setColorBasedOnFragility()
        self.clueLabel.resize(34, self.clueLabel.contentsRect().height())
        
    def getLabelText(self):
        """ Get the CLue Reading Text """
        adjacentMines = self.adjacencyClue.getAdjacentMinesClue()
        if adjacentMines == 0:
            return ''
        else:
            return str(adjacentMines)
        
    def setColorBasedOnFragility(self):
        """ Set color of the clue based on adjacency to Fragile Mines """
        color = "rgba({0}, {1}%)".format(self.getColor(), self.TRANSPARENCY)
        self.clueLabel.setStyleSheet("QLabel { color : %s }" % color)
        
    def getColor(self):
        """ Return color """
        if self.fragilityClue.distance is None:
            return "0, 0, 0"
        elif self.fragilityClue.distance <= 1:
            return "244, 0, 0"
        elif self.fragilityClue.distance > 1 and self.fragilityClue.distance < 4:
            return "244, 244, 0"
        elif self.fragilityClue.distance >= 4:
            return "0, 154, 0"