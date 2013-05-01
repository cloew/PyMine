from grid_square_content import GridSquareContent

from random import choice

class Worm(GridSquareContent):
    """ Represents the Worm Enemy """
    powerRating = 5
    cyclesToMove = 5
    cyclesToAttack = 10
    
    def __init__(self):
        """ Initialize the Worm """
        self.attackTick = 1
        self.moveTick = 0
        self.attacking = False
        self.deactivated = False
        
    def isDeactivated(self):
        """ Return if the content is deactivated """
        return self.deactivated
        
    def hitByEMP(self, drone):
        """ Deactivat the Worm """
        self.deactivated = True
        
    def performGameCycle(self, minefield, drone):
        """ Perform the Game Cycle """
        if not self.deactivated:
            self.tryToAttack(minefield, drone)
            self.tryToMove(minefield, drone)
        
    def tryToMove(self, minefield, drone):
        """ Try to move the worm """
        if (self.moveTick % self.cyclesToMove) == 0:
            self.move(minefield)
        self.moveTick %= self.cyclesToMove
        self.moveTick += 1
        
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
                
    def tryToAttack(self, minefield, drone):
        """ Try to have the worm attack the drone """
        if not self.attacking:
            self.attacking = self.droneInSquare(drone)
        
        if self.attacking:
            if (self.attackTick % self.cyclesToAttack) == 0:
                self.attack(minefield, drone)
            self.attackTick %= self.cyclesToAttack
            self.attackTick += 1
        
    def attack(self, minefield, drone):
        """ Check if the worm should try to attack the drone """
        if self.droneInSquare(drone):
            drone.destroy()
        
    def droneInSquare(self, drone):
        """ Returns if the drone and the worm share the same grid square """
        return self.gridSquare.row == drone.row and self.gridSquare.column == drone.column