from square import Square

class NumberSquare(Square):
    """ Represents a square with a number of hits next to it """
    TYPE = "NUMBER"
    
    def __init__(self, num):
        self.num = num
        self.CLEARED_CHAR = str(num)
        Square.__init__(self)