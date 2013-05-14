from level_overview_view import LevelOverviewView

from PySide.QtCore import Qt
from PySide.QtGui import QColor, QFrame, QPainter

class LevelSelectionView(QFrame):
    """ Represents the View of the Level Selection """
    ENTRIES_PER_ROW = 4

    def __init__(self, parent, level_selection):
        """ Initialize the Level Selection View """
        QFrame.__init__(self)#, parent)

        self.resize(640, 480)
        self.level_selection = level_selection

        self.setFocusPolicy(Qt.StrongFocus)
        
        self.color = QColor(200, 200, 200)
        self.setStyleSheet("QFrame { background-color: %s }" % self.color.name()) 
        
        self.levelOverviews = []
        for level in level_selection.levels:
            overview = LevelOverviewView(self, level, level_selection)
            self.levelOverviews.append(overview)
            
        for i in range(len(self.levelOverviews)):
            overview = self.levelOverviews[i]
            overview.move(32+(i%self.ENTRIES_PER_ROW)*160, 32+i/self.ENTRIES_PER_ROW*64)
            
    def paintEvent(self, event):
        """  """
        for overview in self.levelOverviews:
            overview.updateView()
            
    def updateView(self):
        """ Update the View """