
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
                square = minefield.getSquare(row, column)
                if square is not None and len(square.contents) > 0:
                    self.numberOfAdjacentMines += 1
        
    def __repr__(self):
        """ Return the string representation of the Clue """
        if self.numberOfAdjacentMines == 0:
            return ' '
        else:
            return str(self.numberOfAdjacentMines)