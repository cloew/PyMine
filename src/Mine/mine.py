
class Mine:
    """ Represents a Mine in the Game """
    fragile = None
    powerRating = 5
    reverseReadings = False
    
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

    def defuseCarefully(self, drone):
        """ Defuse the Mine carefully """
        self.defuse(drone)