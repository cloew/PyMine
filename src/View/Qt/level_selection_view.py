from PySide.QtCore import Qt
from PySide.QtGui import QFrame, QPainter

class LevelSelectionView(QFrame):
    """ Represents the View of the Level Selection """

    def __init__(self, parent, level_selection):
        """ Initialize the Level Selection View """
        QFrame.__init__(self, parent)

        self.resize(640, 480)
        self.level_selection = level_selection

        self.setFocusPolicy(Qt.StrongFocus)
        