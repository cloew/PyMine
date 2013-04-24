from PySide.QtCore import Qt
from PySide.QtGui import QColor, QFont, QFrame, QLabel

class LevelOverviewView(QFrame):
    """ Represents the View of the Level Overview """

    def __init__(self, parent, level):
        """ Initialize the Level Overview View """
        QFrame.__init__(self, parent)

        self.resize(640, 480)
        self.level = level
        
        font = QFont()
        font.setPointSize(32)
        self.label = QLabel(self.level.name, self)
        self.label.setFont(font)
        