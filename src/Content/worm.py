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
        self.attack(minefield, drone)
        self.tryToMove(minefield, drone)
        self.tick %= self.cyclesToMove
        self.tick += 1
        
    def tryToMove(self, minefield, drone):
        """ Try to move the worm """
        if (self.tick % self.cyclesToMove) == 0:
            self.move(minefield)
        
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
        
    def attack(self, minefield, drone):
        """ Check if the worm should try to attack the drone """
        #if self.droneInSquare(drone):
            #drone.destroy()
        
    def droneInSquare(self, drone):
        """ Returns if the drone and the worm share the same grid square """
        return self.gridSquare.row == drone.row and self.gridSquare.column == drone.column