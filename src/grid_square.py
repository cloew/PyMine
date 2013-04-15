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
        
    def __repr__(self):
        """ Print the square as a string """
        if self.scanned:
            return str(self.clue)
        else:
            return "#"