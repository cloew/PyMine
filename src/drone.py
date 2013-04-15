
class Drone:
    """ Represents the Player's Drone """
    
    def __init__(self):
        """ Intialize the Player's Drone """
        self.row = 0
        self.column = 0
        
    def up(self, field):
        """  """
        self.row -= 1
        
    def down(self, field):
        """ """
        self.row += 1
    
    def left(self, field):
        """ """
        self.column -= 1
    
    def right(self, field):
        """ """
        self.column += 1