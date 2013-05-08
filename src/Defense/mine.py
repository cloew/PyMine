from defense import Defense
from power_ratings import DEFUSE_POWER

class Mine(Defense):
    """ Represents a Mine in the Game """
    powerRating = DEFUSE_POWER
    
    def __init__(self):
        """ Initialize the Mine """
        self.defused = False
        
    def scan(self, drone):
        """ Scan the mine and destroy the drone """
        self.tryToDetonate(drone)
        
    def defuse(self, drone):
        """ Defuse the Mine """
        self.defused = True

    def defuseCarefully(self, drone):
        """ Defuse the Mine carefully """
        self.defuse(drone)
        
    def hitByEMP(self, drone):
        """ Deactivat the Worm """
        self.tryToDetonate(drone)
        
    def tryToDetonate(self, drone):
        """ Try to detonate the mine """
        if not self.defused:
            drone.destroy()
        
    def isDeactivated(self):
        """ Return if the content is deactivated """
        return self.defused
        
    def isMine(self):
        """ Return if the Grid Square Content is a mine """
        return True 