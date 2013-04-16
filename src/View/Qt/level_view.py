from PySide.QtCore import QBasicTimer, QRect, Qt
from PySide.QtGui import QApplication, QColor, QFont, QFrame, QImage, QLabel, QPainter, QPushButton, QStyle, QStyleOptionButton, QWidget


class LevelView(QFrame):
    """ Represents the View of the Level """

    def __init__(self, parent, level):
        """ Initialize the Level View """
        QFrame.__init__(self, parent)

        self.level = level

        self.setFocusPolicy(Qt.StrongFocus)

    def paintEvent(self, event):
        """ Paint the ship """
        painter = QPainter(self)
        
        # self.background.draw(painter, self)
        # self.drawLasers(painter)
        # self.ship_view.draw(painter, self)
        # self.enemy_view.draw(painter, self)
        # if not self.level.over:
            # self.drawScore(painter)
            # if self.level.paused:
                # self.drawPaused(painter)
        # else:
            # self.drawGameOver(painter)