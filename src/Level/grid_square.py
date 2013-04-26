from clue import Clue

class GridSquare:
    """ Represents a square in the Minefield Grid """
    
    def __init__(self, row, column):
        """ Initialize the Grid Square """
        self.row = row
        self.column = column
        self.scanned = False
        self.clue = Clue()
        
        self.contents = []
        
    def addContent(self, contentObject):
        """ Add the content object to the squares contents """
        self.contents.append(contentObject)
        
    def scan(self, drone):
        """ Scan the Grid Square """
        self.scanned = True
        for contentObject in self.contents:
            contentObject.scan(drone)
        self.clue.populate(drone.minefield, self.row, self.column)
        
    def defuse(self, drone):
        """ Defuse the Grid Square """
        for contentObject in self.contents:
            contentObject.defuse(drone)
            
    def mined(self):
        """ Return if the Square has an ative Mine """
        return self.contents != []
        for contentObject in self.contents:
            if not contentObject.defused:
                return True
        return False
        
    def reversed(self):
        """ Return if the Grid Square causes readings to be reversed """
        if self.mined():
            return self.contents[0].reverseReadings
        return False
        
    def fragile(self):
        """ Returns if the square's contents are fragile """
        if self.mined():
            return self.contents[0].fragile
        return False
        
    def __repr__(self):
        """ Print the square as a string """
        if self.scanned:
            return str(self.clue)
        else:
            return "#"