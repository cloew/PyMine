
class Profile:
    """ Represents a Player Profile """
    
    def __init__(self, name):
        """ Initialize the Profile """
        self.name = name
        self.ratings = {}
    
CURRENT_PROFILE = Profile("CBOBJOE")