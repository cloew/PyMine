
from PySide.QtGui import QColor

class GameStatusView:
    """ It's the game status view """
    
    def __init__(self, x, y, width, height):
        """  """
        self.x = x
        self.y = y
        self.width = width
        self.height = height
        
    def draw(self, painter):
        """ Draw the Game Status Panel """
        painter.fillRect(self.x, self.y, self.width, self.height, QColor(128, 128, 128))