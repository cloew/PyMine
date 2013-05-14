
class CompletionRating:
    """ Represents the Completion Rating """
    
    def __init__(self, level):
        """ Initialize the Completion Rating """
        self.level = level
        self.awarded = False
        
    def checkAwarded(self):
        """ Check if the Rating should be awarded """
        self.awarded = self.level.won()