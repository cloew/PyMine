from mine import Mine

class FragileMine(Mine):
    """ Represents a Fragile Mine """
    fragile = True
    powerRating = 25
    
    def defuse(self, drone):
        """ Defuse the Mine """
        Mine.scan(self, drone)

    def fragileDefuse(self, drone):
        """ Defuse a Fragile Mine """
        Mine.defuse(self, drone)