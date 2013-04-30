from grid_square_content import GridSquareContent

from random import choice

class Worm(GridSquareContent):
    """ Represents the Worm Enemy """
    powerRating = 5
    cyclesToMove = 5
    
    def __init__(self):
        """ Initialize the Worm """
        self.tick = 0
        
    def scan(self, drone):
        """ Do nothing """
        
    def defuse(self, drone):
        """ Do nothing """

    def defuseCarefully(self, drone):
        """ Do nothing """
        
    def performGameCycle(self, minefield, drone):
        """ Perform the Game Cycle """
        if (self.tick % self.cyclesToMove) == 0:
            self.move(minefield)
            self.tick %= self.cyclesToMove
        self.tick += 1
        
    def move(self, minefield):
        """ Move the worm in the minefield """
        adjacentSquares = minefield.getAdjacentSquares(self.gridSquare)
        
        while True:
            if len(adjacentSquares) == 0:
                break
            square = choice(adjacentSquares)
            if square.hasGroundContent():
                adjacentSquares.remove(square)
            else:
                self.gridSquare.groundContent = None
                square.setGroundContent(self)
                self.gridSquare = square
                break
        #print "Worm in Grid Square:", self.gridSquare.row, self.gridSquare.column