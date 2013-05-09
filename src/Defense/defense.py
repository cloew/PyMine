from DefenseAdder.standard_adder import StandardDefenseAdder

class Defense:
    """ Represents a Defense """
    adderClass = StandardDefenseAdder
    fragile = False
    powerRating = 0
    reverseReadings = False
    
    def isDeactivated(self):
        """ Return if the Defense is deactivated """
        return True
    
    def isMine(self):
        """ Return if the Defense is a mine """
        return False
        
    def performGameCycle(self, minefield, drone):
        """ Perform the Game Cycle """
        
    # Drone Action Responses
    def onMove(self, drone):
        """ Do Nothing """
    
    def scan(self, drone):
        """ Do nothing """
        
    def defuse(self, drone):
        """ Do nothing """

    def defuseCarefully(self, drone):
        """ Do nothing """
    
    def hitByEMP(self, drone):
        """ Do Nothing """