from game_status_view import GameStatusView
from grid_square_view import GridSquareView
from minefield_view import MinefieldView

from PySide.QtCore import Qt
from PySide.QtGui import QFrame, QPainter

class LevelView(QFrame):
    """ Represents the View of the Level """

    def __init__(self, parent, level):
        """ Initialize the Level View """
        QFrame.__init__(self, parent)

        self.resize(640, 480)
        self.level = level
        self.minefield_view = MinefieldView(self.level.minefield, self.level.drone)
        self.gameStatusBar = GameStatusView(self.minefield_view.getWidth(), 0, 640-self.minefield_view.getWidth(), 480, self.level)

        self.setFocusPolicy(Qt.StrongFocus)

    def paintEvent(self, event):
        """ Paint the ship """
        painter = QPainter(self)
        
        self.minefield_view.draw(painter, self)
        self.gameStatusBar.draw(painter)
        
        if self.level.lost():
            painter.drawText(0, (self.level.minefield.rowCount()+1)*64, "Game Over!")
            
        if self.level.won():
            painter.drawText(0, (self.level.minefield.rowCount()+1)*64, "You Won!")