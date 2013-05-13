from subclue import SubClue

class FragilityClue(SubClue):
    """ Represents the Fragility Clue """
    
    def __init__(self):
        """ Initialize the Clue """
        self.distance = None
        self.reverse = False
    
    def update(self, minefield, gridRow, gridColumn):
        """ Update the subclue """
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