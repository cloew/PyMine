
class Profile:
    """ Represents a Player Profile """
    
    def __init__(self, name):
        """ Initialize the Profile """
        self.name = name
        self.completionRatings = []
        self.moveRatings = []
        self.powerRatings = []
    
    def addCompletionRating(self, level):
        """ Add a completion Rating """
        if not self.completedLevel(level):
            self.completionRatings.append(level)
        
    def addMoveRating(self, level):
        """ Add a move Rating """
        if not self.acheivedMoveAwardOnLevel(level):
            self.moveRatings.append(level)
        
    def addPowerRating(self, level):
        """ Add a power Rating """
        if not self.acheivedPowerAwardOnLevel(level):
            self.powerRatings.append(level)
        
    def completedLevel(self, level):
        """ Returns if the profile has completed the given level """
        return level in self.completionRatings
    
    def acheivedMoveAwardOnLevel(self, level):
        """ Returns if the profile has gotten the Move Award on the level """
        return level in self.moveRatings
        
    def acheivedPowerAwardOnLevel(self, level):
        """ Returns if the profile has gotten the Power Award on the level """
        return level in self.powerRatings
    
CURRENT_PROFILE = Profile("CBOBJOE")