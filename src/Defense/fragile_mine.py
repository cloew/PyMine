from mine import Mine
from power_ratings import CAREFUL_DEFUSE_POWER

class FragileMine(Mine):
    """ Represents a Fragile Mine """
    fragile = True
    powerRating = CAREFUL_DEFUSE_POWER
    
    def defuse(self, drone):
        """ Defuse the Mine """
        Mine.scan(self, drone)

    def defuseCarefully(self, drone):
        """ Defuse the Mine carefully """
        Mine.defuse(self, drone)