from subclue import SubClue

class FragilityClue(SubClue):
    """ Represents the Fragility Clue """
    
    def __init__(self):
        """ Initialize the Clue """
        self.distance = None
        self.distances = {}
        self.reverse = False
        
    @property
    def count(self):
        """ Return the count of Fragile Mines at the closest distance """
        return self.distances[self.distance]
    
    def update(self, minefield, gridRow, gridColumn):
        """ Update the subclue """
        for row in minefield.squares:
            for square in row:
                if square.fragile():
                    rowDistance = abs(square.row-gridRow)
                    columnDistance = abs(square.column-gridColumn)
                    adjacencyDistance = self.getAdjacencyDistance(rowDistance, columnDistance)
                    
                    if adjacencyDistance in self.distances:
                        self.distances[adjacencyDistance] += 1
                    else:
                        self.distances[adjacencyDistance] = 1
                    
                    if self.distance is None or adjacencyDistance < self.distance:
                        self.distance = adjacencyDistance
                        
    def getAdjacencyDistance(self, rowDistance, columnDistance):
        """ Get the Adjacency Distance """
        if rowDistance < columnDistance:
            return columnDistance
        else:
            return rowDistance