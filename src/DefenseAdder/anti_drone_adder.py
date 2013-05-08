from Defense.anti_drone_turret import AntiDroneTurret

from standard_adder import StandardDefenseAdder

from random import randint

class AntiDroneAdder(StandardDefenseAdder):
    """ Adds an Anti-Drone Defense to the Minefield and surrounds it with turrets """
  
    def __init__(self):
        """ Initialize the Standard Defense Adder """

    def addDefense(self, defense, minefield):
        """ Add Defense to the minefield """
        while True:
            square = self.getSquare(minefield)
            if square.hasGroundDefense():
                continue
            else:
                square.setGroundDefense(defense)
                defense.gridSquare = square
                self.addTurrets(defense, minefield, square)
                break
                
    def addTurrets(self, defense, minefield, centerSquare):
        """ Add Turrets to the Minefield """
        for square in minefield.getAdjacentSquares(centerSquare):
            turret = AntiDroneTurret()
            square.setGroundDefense(turret)
            turret.gridSquare = square
            defense.addTurret(turret)