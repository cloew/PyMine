from clue import Clue

class GridSquare:
    """ Represents a square in the Minefield Grid """
    
    def __init__(self, row, column):
        """ Initialize the Grid Square """
        self.row = row
        self.column = column
        self.scanned = False
        self.clue = Clue()
        
        self.groundContent = None
        
    def setGroundContent(self, contentObject):
        """ Set the Ground Content """
        self.groundContent = contentObject
        
    def scan(self, drone):
        """ Scan the Grid Square """
        self.scanned = True
        if self.mined():
            self.groundContent.scan(drone)
        self.clue.populate(drone.minefield, self.row, self.column)
        
    def defuse(self, drone):
        """ Defuse the Grid Square """
        if self.mined():
            self.groundContent.defuse(drone)
            
    def defuseCarefully(self, drone):
        """ Defuse the Grid Square """
        if self.mined():
            self.groundContent.defuseCarefully(drone)
            
    def getGroundContent(self):
        if self.mined():
            return self.groundContent
            
    def mined(self):
        """ Return if the Square has an ative Mine """
        return self.groundContent is not None
        # for contentObject in self.contents:
            # if not contentObject.defused:
                # return True
        # return False
        
    def reversed(self):
        """ Return if the Grid Square causes readings to be reversed """
        if self.mined():
            return self.groundContent.reverseReadings
        return False
        
    def fragile(self):
        """ Returns if the square's contents are fragile """
        if self.mined():
            return self.groundContent.fragile
        return False
        
    def __repr__(self):
        """ Print the square as a string """
        if self.scanned:
            return str(self.clue)
        else:
            return "#"