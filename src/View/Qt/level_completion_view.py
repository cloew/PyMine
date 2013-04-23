
class LevelCompletionView:
    """ View of the Level Completion Status """
    
    def __init__(self, level, y):
        """ Initialize the Level Completion View """
        self.level = level
        self.y = y
        
    def draw(self, painter):
        """ Draw the Level Completion View """
        y = self.y+64
        
        if self.level.lost():
            painter.drawText(64, y, "Game Over!")
        elif self.level.won():
            painter.drawText(64, y, "You Won!")