
from PySide.QtGui import QColor

class GameStatusView:
    """ It's the game status view """
    
    def __init__(self, x, y, width, height, level):
        """  """
        self.x = x
        self.y = y
        self.width = width
        self.height = height
        
        self.level = level
        
    def draw(self, painter):
        """ Draw the Game Status Panel """
        painter.fillRect(self.x, self.y, self.width, self.height, QColor(200, 200, 200))
        
        painter.drawText(self.x+32, self.y+32+64, str(self.level.drone.power))