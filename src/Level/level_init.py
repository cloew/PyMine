from Mine.mine import Mine
from Mine.fragile_mine import FragileMine
from Mine.reverse_mine import ReverseMine

class LevelInit:
    """ Initializer for a Level """
    
    def __init__(self, name, rows, columns, contents):
        """ Initialize the Level Init Object """
        self.name = name
        self.rows = rows
        self.columns = columns
        self.contents = contents