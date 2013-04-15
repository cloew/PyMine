
class Mine:
    """ Represents a Mine in the Game """
    
    def __init__(self):
        """ Initialize the Mine """
        self.defused = False
        
    def scan(self, drone):
        """ Scan the mine and destroy the drone """
        drone.destroy()
        
    def defuse(self):
        """ Defuse the Mine """
        self.defused = True
