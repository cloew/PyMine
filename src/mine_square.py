from square import Square

class MineSquare(Square):
    """ Represents a square with a mine """
    CLEARED_CHAR = 'M'
    TYPE = "MINE"
    
    def clear(self):
        """ If you clear a square with a mine, you lose """
        # But not right now
        Square.clear(self)