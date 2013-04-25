
class Clue:
    """ Represents a Clue for the Mine Game """
    
    def __init__(self):
        """ Initialize the Clue """
        self.numberOfAdjacentMines = 0
        self.reverse = False
        
    def findAdjacentMines(self, minefield, gridRow, gridColumn):
        """ Find an Adjacent Mine """
        self.numberOfAdjacentMines = 0
        self.reverse = False
        for row in (gridRow-1, gridRow, gridRow+1):
            for column in (gridColumn-1, gridColumn, gridColumn+1):
                if row == gridRow and column == gridColumn:
                    continue # Ignore the current grid Location, because we only want to examine adjacent cells
                square = minefield.getSquare(row, column)
                if square is not None and square.mined():
                    self.numberOfAdjacentMines += 1
                    if square.reversed():
                        self.reverse = True
                        
    def getAdjacentMinesClue(self):
        """ Returns the Adjacent Mines Clue """
        if self.reverse:
            return 8 - self.numberOfAdjacentMines
        else:
            return self.numberOfAdjacentMines
        
    def __repr__(self):
        """ Return the string representation of the Clue """
        reportedAdjacentMines = self.getAdjacentMinesClue()
        if reportedAdjacentMines == 0:
            return ' '
        else:
            return str(reportedAdjacentMines)