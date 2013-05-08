from mine import Mine

class AntiDroneMine(Mine): # Not sure about the name, since it's kind of not a mine
  """ Represents the Anti-Drone Mine """
  
  def hitByEMP(self, drone):
        """ Deactivat the Worm """
        self.defused = True
        