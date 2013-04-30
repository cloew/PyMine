from random import choice

class Worm:
    """ Represents the Worm Enemy """
    powerRating = 5
    
    def __init__(self):
        """ Initialize the Worm """
        self.defused = False
        
    def scan(self, drone):
        """ Do nothing """
        
    def defuse(self, drone):
        """ Do nothing """

    def defuseCarefully(self, drone):
        """ Do nothing """
        
    def performGameCycle(self, minefield):
        """ Perform the Game Cycle """
        self.move(minefield)
        
    def move(self, minefield):
        """ Move the worm in the minefield """
        adjacentSquares = minefield.getAdjacentSquares(self.gridSquare)
        
        while True:
            if len(adjacentSquares) == 0:
                break
            square = choice(adjacentSquares)
            if square.mined():
                adjacentSquares.remove(square)
            else:
                self.gridSquare.groundContent = None
                square.setGroundContent(self)
                self.gridSquare = square
                break
        print "Worm in Grid Square:", self.gridSquare.row, self.gridSquare.column