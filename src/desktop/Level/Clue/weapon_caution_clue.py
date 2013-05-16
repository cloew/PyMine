from subclue import SubClue

class WeaponCautionClue(SubClue):
    """ Represents the Weapon Caution Clue """
    
    def __init__(self):
        """ Initialize the Clue """
        self.nearWeapons = False
        self.reverse = False
    
    def updateFromAdjacentSquare(self, square):
        """ Update the adjacency clue with an adjacent square """
        if square.hasWeaponry():
            self.nearWeapons = True 