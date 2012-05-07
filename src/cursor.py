
class Cursor:
    """ Represents the cursor in the Mine field """
    
    def __init__(self, fieldSize):
        """ Initialize the cursor to the beginning of the file """
        self.row = 0
        self.col = 0
        
        self.fieldSize = fieldSize
        
    def up(self):
        """ Move the cursor up a row """
        if self.row > 0:
            self.row -= 1
            
        self.normalizeCol()
            
    def down(self):
        """ Move the cursor down a row """
        if self.row < self.fieldSize-1:
            self.row += 1
            
        self.normalizeCol()
            
    def left(self):
        """ Moves the cursor left one column """
        if self.col > 0:
            self.col -= 1
    
    def right(self):
        """ Moves the cursor right one column """
        if self.col < self.fieldSize-1:
            self.col += 1
    
    def normalizeCol(self):
        """ Normalize Column """
        lastCol = self.fieldSize
        
        if self.col > lastCol:
            self.col = lastCol