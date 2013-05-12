from defense import Defense
from power_ratings import EMP_POWER

from nytram.core.game_engine import TheGameEngine
from random import choice

class Worm(Defense):
    """ Represents the Worm Enemy """
    powerRating = EMP_POWER
    cyclesToMove = 40
    cyclesToAttack = 80
    
    def __init__(self):
        """ Initialize the Worm """
        self.attackTick = 1
        self.moveTick = 0
        self.attacking = False
        self.deactivated = False
        
    def isDeactivated(self):
        """ Return if the content is deactivated """
        return self.deactivated
        
    def onMove(self, drone):
        """ Try to attack """
        self.tryToAttack(drone)
        
    def hitByEMP(self, drone):
        """ Deactivate the Worm """
        self.deactivated = True
        
    def performGameCycle(self, minefield, drone):
        """ Perform the Game Cycle """
        if not self.deactivated:
            self.tryToAttack(drone)
            self.tryToMove(minefield, drone)
        
    def tryToMove(self, minefield, drone):
        """ Try to move the worm """
        if not self.attacking and (self.moveTick % self.cyclesToMove) == 0:
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
            if square.hasGroundDefense() or square.column == 0:
                adjacentSquares.remove(square) # Can't move to a square that already has ground content or is in the safe zone
            else:
                self.gridSquare.setGroundDefense(None)
                square.setGroundDefense(self)
                self.gridSquare = square
                TheGameEngine.updateUI()
                break
                
    def tryToAttack(self, drone):
        """ Try to have the worm attack the drone """
        if not self.attacking:
            self.attacking = self.droneInSquare(drone)
        
        if self.attacking:
            if (self.attackTick % self.cyclesToAttack) == 0:
                self.attack(drone)
                self.attacking = False
            self.attackTick %= self.cyclesToAttack
            self.attackTick += 1
            TheGameEngine.updateUI()
        
    def attack(self, drone):
        """ Check if the worm should try to attack the drone """
        if self.droneInSquare(drone):
            drone.destroy()
        
    def droneInSquare(self, drone):
        """ Returns if the drone and the worm share the same grid square """
        return self.gridSquare.row == drone.row and self.gridSquare.column == drone.column