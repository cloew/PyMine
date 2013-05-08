from mine import Mine

class AntiDroneMine(Mine): # Not sure about the name, since it's kind of not a mine
  """ Represents the Anti-Drone Mine """
  powerRating = EMP_POWER
  
  def defuse(self, drone):
        """ Defuse the Mine """
        self.tryToDetonate(drone)

    def defuseCarefully(self, drone):
        """ Defuse the Mine carefully """
        self.tryToDetonate(drone)
  
  def hitByEMP(self, drone):
        """ Deactivat the Worm """
        self.defused = True
        