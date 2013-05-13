from subclue import SubClue

class AdjacencyClue(SubClue):
    """ Represents the Adjacency Clue """
    
    def __init__(self):
        """ Initialize the Clue """
        self.numberOfAdjacentMines = 0
        self.reverse = False
    
    def update(self, minefield, gridRow, gridColumn):
        """ Update the subclue """
        self.numberOfAdjacentMines = 0
    
    def updateFromAdjacentSquare(self, square):
        """ Update the adjacency clue with an adjacent square """
        if square.mined():
            self.numberOfAdjacentMines += 1
            
    def getAdjacentMinesClue(self):
        """ Returns the Adjacent Mines Clue """
        if self.reverse:
            return 8 - self.numberOfAdjacentMines
        else:
            return self.numberOfAdjacentMines