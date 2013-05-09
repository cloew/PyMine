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
                self.addTurrets(defense)
                break
                
    def getSquare(self, minefield):
        """ Return a Grid Square """
        while True:
            row = randint(0, minefield.rowCount()-1)
            column = randint(2, minefield.columnCount()-1)
            centerSquare = minefield.getSquare(row, column)
            self.adjacentSquares = minefield.getAdjacentSquares(centerSquare)
            
            for square in self.adjacentSquares:
                if square.hasGroundDefense():
                    break
            else:
                break
        return centerSquare
                
    def addTurrets(self, defense):
        """ Add Turrets to the Minefield """
        for square in self.adjacentSquares:
            turret = AntiDroneTurret()
            square.setGroundDefense(turret)
            turret.gridSquare = square
            defense.addTurret(turret)