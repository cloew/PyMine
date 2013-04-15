
class GridSquare:
    """ Represents a square in the Minefield Grid """
    
    def __init__(self, row, column):
        """ Initialize the Grid Square """
        self.row = row
        self.column = column
        self.scanned = False
        
    def scan(self):
        """ Scan the Grid Square """
        self.scanned = True
        
    def __repr__(self):
        """ Print the square as a string """
        if self.scanned:
            return " "
        else:
            return "#"