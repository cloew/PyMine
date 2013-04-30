from grid_square_content import GridSquareContent

class Mine(GridSquareContent):
    """ Represents a Mine in the Game """
    powerRating = 5
    
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
        
    def isDeactivated(self):
        """ Return if the content is deactivated """
        return self.defused
        
    def isMine(self):
        """ Return if the Grid Square Content is a mine """
        return True 