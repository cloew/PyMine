from mine import Mine
from power_ratings import EMP_POWER

from DefenseAdder.anti_drone_adder import AntiDroneAdder

class AntiDroneMine(Mine): # Not sure about the name, since it's kind of not a mine
    """ Represents the Anti-Drone Mine """
    adderClass = AntiDroneAdder
    powerRating = EMP_POWER
    
    def __init__(self):
        """ Initialize the Anti-Drone Mine """
        self.turrets = []
        Mine.__init__(self)
  
    def defuse(self, drone):
        """ Defuse the Mine """
        self.tryToDetonate(drone)

    def defuseCarefully(self, drone):
        """ Defuse the Mine carefully """
        self.tryToDetonate(drone)
  
    def hitByEMP(self, drone):
        """ Deactivat the Worm """
        self.defused = True
        
    def addTurret(self, turret):
        """ Add turret to the Anti Drone Mine """
        self.turrets.append(turret)