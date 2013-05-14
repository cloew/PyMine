from rating import Rating

class CompletionRating(Rating):
    """ Represents the Completion Rating """
        
    def checkAwarded(self):
        """ Check if the Rating should be awarded """
        self.awarded = self.level.won()