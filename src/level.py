from drone import Drone
from mine import Mine
from minefield import Minefield

class Level:
    """ Represents a Level """
    
    def __init__(self, numMines):
        """ Initialize the Level """
        self.minefield = Minefield()
        self.drone = Drone(self.minefield)
        
        self.mines = []
        for i in range(numMines):
            mine = Mine()
            self.mines.append(mine)
            self.minefield.addMine(mine)
        
    def lost(self):
        """ Return if the player has lost the level """
        return self.drone.destroyed
        
    def won(self):
        """ Return if the player has won the level """
        won = True
        for mine in self.mines:
            if not mine.defused:
                return False
        return won