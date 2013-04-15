from drone import Drone
from minefield import Minefield

class Level:
    """ Represents a Level """
    
    def __init__(self):
        """ Initialize the Level """
        self.minefield = Minefield()
        self.drone = Drone(self.minefield)
        
    def lost(self):
        """ Return if the player has lost the level """
        return self.drone.destroyed