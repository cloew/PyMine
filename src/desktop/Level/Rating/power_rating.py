from Profile.profile_manager import CURRENT_PROFILE
from rating import Rating

class PowerRating(Rating):
    """ Represents the Power Rating """
    
    def __init__(self, power, level):
        """ Initialize the Power Rating """
        Rating.__init__(self, level)
        self.power = power
    
    def usePower(self, amount):
        """ Increment the move counter by 1 """
        if not self.level.finished():
            self.power -= amount
        
    def checkAwarded(self):
        """ Check if the Rating should be awarded """
        self.awarded = self.power >= 15
        if self.awarded:
            CURRENT_PROFILE.addPowerRating(self.level)