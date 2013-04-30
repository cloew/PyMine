
class GridSquareContent:
    """ Represents a Grid Square Content """
    fragile = False
    powerRating = 0
    reverseReadings = False
    
    def deactivated(self):
        """ Return if the content is deactivated """
        return True
    
    def isMine(self):
        """ Return if the Grid Square Content is a mine """
        return False
        
    def performGameCycle(self, minefield):
        """ Perform the Game Cycle """