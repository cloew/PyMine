
class Achievement:
    """ Represents an in-game achievement """
    name = "Some Achievement"
    
    def __init__(self):
        """  """
        self.awarded = False
        
    def award(self):
        """ Awards this achievement """
        self.awareded = True
        print self.name, "Achievement was awarded"