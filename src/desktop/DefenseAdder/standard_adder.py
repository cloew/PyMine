from random import randint

class StandardDefenseAdder:
    """ Adds a Defense to the Minefield by assigning it a grid square that has no defenses """
  
    def __init__(self):
        """ Initialize the Standard Defense Adder """

    def addDefense(self, defense, minefield):
        """ Add Defense to the minefield """
        while True:
            square = self.getRandomSquare(minefield)
            if square.hasGroundDefense():
                continue
            else:
                square.setGroundDefense(defense)
                defense.gridSquare = square
                break
            
    def getRandomSquare(self, minefield):
        """ Return a Grid Square """
        row = randint(0, minefield.rowCount()-1)
        column = randint(1, minefield.columnCount()-1)
        return minefield.getSquare(row, column)