
class Rating:
    """ Represents the Rating """
    
    def __init__(self, level):
        """ Initialize the Rating """
        self.level = level
        self.awarded = False
        
    def checkAwarded(self):
        """ Check if the Rating should be awarded """