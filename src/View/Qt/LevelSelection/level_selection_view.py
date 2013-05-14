from level_overview_view import LevelOverviewView
from level_details_view import LevelDetailsView

from PySide.QtCore import Qt
from PySide.QtGui import QColor, QFrame, QPainter

class LevelSelectionView(QFrame):
    """ Represents the View of the Level Selection """
    ENTRIES_PER_ROW = 3

    def __init__(self, parent, level_selection):
        """ Initialize the Level Selection View """
        QFrame.__init__(self)#, parent)

        self.resize(640, 480)
        self.level_selection = level_selection

        self.setFocusPolicy(Qt.StrongFocus)
        
        self.color = QColor(200, 200, 200)
        self.setStyleSheet("QFrame { background-color: %s }" % self.color.name())
        
        self.levelDetailsView = LevelDetailsView(self.level_selection, parent=self)
        width = self.ENTRIES_PER_ROW*LevelOverviewView.WIDTH+32
        self.levelDetailsView.move(width, 0)
        self.levelDetailsView.resize(640-width, 480)
        
        self.levelOverviews = []
        for level in level_selection.levels:
            overview = LevelOverviewView(self, level, level_selection)
            self.levelOverviews.append(overview)
            
        for i in range(len(self.levelOverviews)):
            overview = self.levelOverviews[i]
            overview.move(16+(i%self.ENTRIES_PER_ROW)*LevelOverviewView.WIDTH, 32+i/self.ENTRIES_PER_ROW*LevelOverviewView.HEIGHT)
            
    def paintEvent(self, event):
        """  """
        for overview in self.levelOverviews:
            overview.updateView()
        self.levelDetailsView.updateView()
            
    def updateView(self):
        """ Update the View """