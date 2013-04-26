
class Clue:
    """ Represents a Clue for the Mine Game """
    
    def __init__(self):
        """ Initialize the Clue """
        self.numberOfAdjacentMines = 0
        self.reverse = False
        self.distance = None
        
    def populate(self, minefield, gridRow, gridColumn):
        """ Populate the Clue """
        self.findAdjacentMines(minefield, gridRow, gridColumn)
        self.findFragileMines(minefield, gridRow, gridColumn)
        
    def findAdjacentMines(self, minefield, gridRow, gridColumn):
        """ Find an Adjacent Mine """
        self.numberOfAdjacentMines = 0
        self.reverse = False
        for row in (gridRow-1, gridRow, gridRow+1):
            for column in (gridColumn-1, gridColumn, gridColumn+1):
                square = minefield.getSquare(row, column)
                if square is None:
                    continue # If there is no square at this location, skip to the next one
                if square.reversed():
                        self.reverse = True
                if row == gridRow and column == gridColumn:
                    continue # Ignore the current grid Location, because we only want to examine adjacent cells
                if square.mined():
                    self.numberOfAdjacentMines += 1
                    
    def findFragileMines(self, minefield, gridRow, gridColumn):
        """ Get the Fragile mine adjacency rating """
        for row in minefield.squares:
            for square in row:
                if square.fragile():
                    rowDistance = abs(square.row-gridRow)
                    columnDistance = abs(square.column-gridColumn)
                    adjacencyDistance = self.getAdjacencyDistance(rowDistance, columnDistance)
                    if self.distance is None or adjacencyDistance < self.distance:
                        self.distance = adjacencyDistance
                    
    def getAdjacencyDistance(self, rowDistance, columnDistance):
        """ Get the Adjacency Distance """
        if rowDistance < columnDistance:
            return columnDistance
        else:
            return rowDistance
                        
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