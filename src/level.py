from drone import Drone
from mine import Mine
from minefield import Minefield

class Level:
    """ Represents a Level """
    
    def __init__(self):
        """ Initialize the Level """
        self.minefield = Minefield()
        self.drone = Drone(self.minefield)
        
        self.mines = [Mine()]
        for mine in self.mines:
            self.minefield.addMine(mine)
        
    def lost(self):
        """ Return if the player has lost the level """
        return self.drone.destroyed