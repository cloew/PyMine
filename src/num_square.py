from square import Square

class NumberSquare(Square):
    """ Represents a square with a number of hits next to it """
    
    def __init__(self, num):
        self.CLEARED_CHAR = str(num)
        Square.__init__(self)