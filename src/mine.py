
class Mine:
    """ Represents a Mine in the Game """
    
    def __init__(self):
        """ Initialize the Mine """
        self.defused = False
        
    def scan(self, drone):
        """ Scan the mine and destroy the drone """
        if not self.defused:
            drone.destroy()
        
    def defuse(self, drone):
        """ Defuse the Mine """
        self.defused = True
