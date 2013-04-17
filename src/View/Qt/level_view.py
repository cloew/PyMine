from minefield_view import MinefieldView

from PySide.QtCore import QBasicTimer, QRect, Qt
from PySide.QtGui import QApplication, QColor, QFont, QFrame, QImage, QLabel, QPainter, QPushButton, QStyle, QStyleOptionButton, QWidget

class LevelView(QFrame):
    """ Represents the View of the Level """

    def __init__(self, parent, level):
        """ Initialize the Level View """
        QFrame.__init__(self, parent)

        self.level = level
        self.minefield_view = MinefieldView(self.level.minefield, self.level.drone)

        self.setFocusPolicy(Qt.StrongFocus)

    def paintEvent(self, event):
        """ Paint the ship """
        painter = QPainter(self)
        self.minefield_view.draw(painter, self)
        if self.level.lost():
            painter.drawText(self.level.minefield.columnCount()*64/2, (self.level.minefield.rowCount()+1)*64, "Game Over!")