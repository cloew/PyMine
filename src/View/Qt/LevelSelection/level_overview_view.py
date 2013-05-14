from PySide.QtCore import Qt
from PySide.QtGui import QColor, QFont, QFrame, QLabel

class LevelOverviewView(QFrame):
    """ Represents the View of the Level Overview """

    def __init__(self, parent, level, levelSelection):
        """ Initialize the Level Overview View """
        QFrame.__init__(self, parent)

        self.resize(640, 480)
        self.level = level
        self.levelSelection = levelSelection
        
        self.bigFont = QFont()
        self.bigFont.setPointSize(32)
        
        self.smallFont = QFont()
        self.smallFont.setPointSize(24)
        
        self.label = QLabel(self.level.name, self)
        self.label.setFont(self.bigFont)
        
    def updateView(self):
        """ Update the View """
        if self.levelSelection.getLevel() is self.level:
            self.label.setFont(self.bigFont)
        else:
            self.label.setFont(self.smallFont)
            
        self.update()