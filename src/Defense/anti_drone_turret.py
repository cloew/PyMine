from defense import Defense
from power_ratings import EMP_POWER

class AntiDroneTurret(Defense):
    """ Represents an Anti-Drone Turret in the Game """
    powerRating = EMP_POWER
    
    def __init__(self):
        """ Initialize the Mine """
        self.deactivated = False
        self.defused = True
        
    def onMove(self, drone):
        """ Destroy the Drone if it moves above the turret """
        self.tryToDestroyDrone(drone)
        
    def hitByEMP(self, drone):
        """ Deactivat the Worm """
        self.deactivated = True
        
    def tryToDestroyDrone(self, drone):
        """ Try to detonate the mine """
        if not self.deactivated:
            drone.destroy()
        
    def isDeactivated(self):
        """ Return if the content is deactivated """
        return self.deactivated
        
    def isWeapon(self):
        """ Return if the Defense is a weapon """
        return True 