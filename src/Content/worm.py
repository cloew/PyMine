from grid_square_content import GridSquareContent

from random import choice

class Worm(GridSquareContent):
    """ Represents the Worm Enemy """
    powerRating = 5
    cyclesToMove = 5
    
    def __init__(self):
        """ Initialize the Worm """
        self.tick = 0
        self.deactivated = False
        
    def isDeactivated(self):
        """ Return if the content is deactivated """
        return self.deactivated
        
    def hitByEMP(self, drone):
        """ Deactivat the Worm """
        self.deactivated = True
        
    def performGameCycle(self, minefield, drone):
        """ Perform the Game Cycle """
        self.attack(minefield, drone)
        self.tryToMove(minefield, drone)
        self.tick %= self.cyclesToMove
        self.tick += 1
        
    def tryToMove(self, minefield, drone):
        """ Try to move the worm """
        if not self.deactivated and (self.tick % self.cyclesToMove) == 0:
            self.move(minefield)
        
    def move(self, minefield):
        """ Move the worm in the minefield """
        adjacentSquares = minefield.getAdjacentSquares(self.gridSquare)
        
        while True:
            if len(adjacentSquares) == 0:
                break
            square = choice(adjacentSquares)
            if square.hasGroundContent() or square.column == 0:
                adjacentSquares.remove(square) # Can't move to a square that already has ground content or is in the safe zone
            else:
                self.gridSquare.groundContent = None
                square.setGroundContent(self)
                self.gridSquare = square
                break
        
    def attack(self, minefield, drone):
        """ Check if the worm should try to attack the drone """
        #if self.droneInSquare(drone):
            #print "Worm In Square with Drone"
            #drone.destroy()
        
    def droneInSquare(self, drone):
        """ Returns if the drone and the worm share the same grid square """
        return self.gridSquare.row == drone.row and self.gridSquare.column == drone.column