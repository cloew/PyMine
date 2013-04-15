
class Mine:
    """ Represents a Mine in the Game """
    
    def __init__(self):
        """ Initialize the Mine """
        self.defused = False
        
    def scan(self):
        """ Scan the mine and destroy the drone """
        print "Scanned a Mine"
        
    def defuse(self):
        """ Defuse the Mine """