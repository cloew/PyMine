from PySide.QtCore import Qt
from PySide.QtGui import QColor, QFont, QFrame, QLabel

class LevelOverviewView(QFrame):
    """ Represents the View of the Level Overview """

    def __init__(self, parent, level, levelSelection):
        """ Initialize the Level Overview View """
        QFrame.__init__(self, parent)

        self.resize(160, 64)
        self.level = level
        self.levelSelection = levelSelection
        
        self.bigFont = QFont()
        self.bigFont.setPointSize(32)
        
        self.smallFont = QFont()
        self.smallFont.setPointSize(24)
        
        self.label = self.getLabel(self.smallFont)
        
    def getLabel(self, font):
        """ Get a Level Label witht he apropriate Font """
        label = QLabel(self.level.name, self)
        label.setFont(self.smallFont)
        label.setAlignment(Qt.AlignCenter)
        label.resize(160, 64)
        return label
        
    def updateView(self):
        """ Update the View """
        if self.levelSelection.getLevel() is self.level:
            self.label.setFont(self.bigFont)
        else:
            self.label.setFont(self.smallFont)
            
        self.update()
        
    def getWidth(self):
        """ Return the Width of the Level Overview View """
        return self.label.contentsRect().width()