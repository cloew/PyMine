
class Square:
    """ Represents a square in the minefield """
    UNCLEARED_CHAR = 'X'
    CLEARED_CHAR = ' '
    
    def __init__(self):
        """  """
        self.cleared = False
        
    def clear(self):
        """ Clears the square """
        self.cleared = True
        
    def display(self):
        """ Returns the display character """
        if self.cleared:
            return self.CLEARED_CHAR
        else:
            return self.UNC:EARED_CHAR
    