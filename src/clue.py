
class Clue:
    """ Represents a Clue for the Mine Game """
    
    def __init__(self):
        """ Initialize the Clue """
        self.numberOfAdjacentMines = 0
        
    def findAdjacentMines(self, minefield, gridRow, gridColumn):
        """ Find an Adjacent Mine """
        self.numberOfAdjacentMines = 0
        for row in (gridRow-1, gridRow, gridRow+1):
            for column in (gridColumn-1, gridColumn, gridColumn+1):
                if row == gridRow and column == gridColumn:
                    continue # Ignore the current grid Location, because we only want to examine adjacent cells
                square = minefield.getSquare(row, column)
                if square is not None and square.mined():
                    self.numberOfAdjacentMines += 1
        
    def __repr__(self):
        """ Return the string representation of the Clue """
        if self.numberOfAdjacentMines == 0:
            return ' '
        else:
            return str(self.numberOfAdjacentMines)