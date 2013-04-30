from mine import Mine

class FragileMine(Mine):
    """ Represents a Fragile Mine """
    fragile = True
    powerRating = 25
    
    def defuse(self, drone):
        """ Defuse the Mine """
        Mine.scan(self, drone)

    def defuseCarefully(self, drone):
        """ Defuse the Mine carefully """
        Mine.defuse(self, drone)