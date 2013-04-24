from level_overview_view import LevelOverviewView

from PySide.QtCore import Qt
from PySide.QtGui import QColor, QFrame, QPainter

class LevelSelectionView(QFrame):
    """ Represents the View of the Level Selection """

    def __init__(self, parent, level_selection):
        """ Initialize the Level Selection View """
        QFrame.__init__(self, parent)

        self.resize(640, 480)
        self.level_selection = level_selection

        self.setFocusPolicy(Qt.StrongFocus)
        
        self.color = QColor(200, 200, 200)
        self.setStyleSheet("QFrame { background-color: %s }" % self.color.name()) 
        
        self.levelOverviews = []
        for level in level_selection.levels:
            overview = LevelOverviewView(self, level)
            self.levelOverviews.append(overview)
            overview.move(32, 32)