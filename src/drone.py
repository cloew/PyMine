
class Drone:
    """ Represents the Player's Drone """
    
    def __init__(self, minefield):
        """ Intialize the Player's Drone """
        self.row = 0
        self.column = 0
        self.minefield = minefield
        
    def up(self):
        """  """
        if self.row > 0:
            self.row -= 1
        
    def down(self):
        """ """
        if self.row < len(self.minefield.squares):
            self.row += 1
    
    def left(self):
        """ """
        if self.column > 0:
            self.column -= 1
    
    def right(self):
        """ """
        if self.column < len(self.minefield.squares[0]):
            self.column += 1