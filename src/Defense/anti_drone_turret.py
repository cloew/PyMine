from grid_square_content import GridSquareContent
from power_ratings import EMP_POWER

class AntiDroneTurret(GridSquareContent):
    """ Represents an Anti-Drone Turret in the Game """
    powerRating = EMP_POWER
    
    def __init__(self):
        """ Initialize the Mine """
        self.deactivated = False
        
    def scan(self, drone):
        """ Scan the mine and destroy the drone """
        self.tryToDestroyDrone(drone)
        
    def defuse(self, drone):
        """ Defuse the Mine """
        self.tryToDestroyDrone(drone)

    def defuseCarefully(self, drone):
        """ Defuse the Mine carefully """
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