from Profile.profile_manager import CURRENT_PROFILE
from rating import Rating

class MoveRating(Rating):
    """ Represents the Move Rating """
    
    def __init__(self, level):
        """ Initialize the Move Rating """
        Rating.__init__(self, level)
        self.moveCount = 0
    
    def move(self):
        """ Increment the move counter by 1 """
        if not self.level.finished():
            self.moveCount += 1
        
    def checkAwarded(self):
        """ Check if the Rating should be awarded """
        self.awarded = self.moveCount <= 20
        if self.awarded:
            CURRENT_PROFILE.addMoveRating(self.level)