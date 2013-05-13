from Level.Clue.adjacency_clue import AdjacencyClue

class Clue:
    """ Represents a Clue for the Mine Game """
    
    def __init__(self):
        """ Initialize the Clue """
        self.reverse = False
        self.distance = None
        self.nearWeapons = False
        self.adjacencyClue = AdjacencyClue()
        
    def populate(self, minefield, gridRow, gridColumn):
        """ Populate the Clue """
        self.adjacencyClue.update(minefield, gridRow, gridColumn)
        self.findAdjacentMines(minefield, gridRow, gridColumn)
        self.findFragileMines(minefield, gridRow, gridColumn)
        
    def findAdjacentMines(self, minefield, gridRow, gridColumn):
        """ Find an Adjacent Mine """
        self.reverse = False
        currentSquare = minefield.getSquare(gridRow, gridColumn)
        
        for square in minefield.getAdjacentSquares(currentSquare, includeCenter=True):
            if square.reversed():
                    self.reverse = True
                    self.adjacencyClue.reverse()
            if square.row == gridRow and square.column == gridColumn:
                continue # Ignore the current grid Location, because we only want to examine adjacent cells
            self.adjacencyClue.updateFromAdjacentSquare(square)
            if square.hasWeaponry():
                self.nearWeapons = True
                    
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
        
    def __repr__(self):
        """ Return the string representation of the Clue """
        reportedAdjacentMines = self.adjacencyClue.getAdjacentMinesClue()
        if reportedAdjacentMines == 0:
            return ' '
        else:
            return str(reportedAdjacentMines)