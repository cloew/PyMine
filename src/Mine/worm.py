from random import choice

class Worm:
    """ Represents the Worm Enemy """
    
    def __init__(self):
        """ Initialize the Worm """
        
    def scan(self, drone):
        """ Do nothing """
        
    def defuse(self, drone):
        """ Do nothing """

    def defuseCarefully(self, drone):
        """ Do nothing """
        
    def performGameCycle(self, minefield):
        """ Perform the Game Cycle """
        adjacentSquares = minefield.getAdjacentSquares(self.gridSquare)
        
        while True:
            if len(adjacentSquares) == 0:
                break
            square = choice(adjacentSquares)
            if square.mined():
                adjacentSquares.remove(square)
            else:
                gridSquare.groundContent = None
                square.setGroundContent(self)
                break
    