from drone import Drone
from minefield import Minefield

class Level:
    """ Represents a Level """
    
    def __init__(self, name, rows, columns, contents):
        """ Initialize the Level """
        self.name = name
        self.rows = rows
        self.columns = columns
        self.contents = contents
        self.reset()
        
    def reset(self):
        """ Reset the Level """
        self.minefield = Minefield(self.rows, self.columns)
        self.drone = Drone(self.getPowerRating(), self.minefield)
        
        self.contentItems = []
        for contentClass in self.contents:
            for i in range(self.contents[contentClass]):
                content = contentClass()
                self.contentItems.append(content)
                self.minefield.addMine(content)
            
    def getPowerRating(self):
        """ Returns the amount of power the drone should have on the level """
        powerRating = self.minefield.rowCount()*self.minefield.columnCount()*2
        for contentClass in self.contents:
            powerRating += self.contents[contentClass]*contentClass.powerRating
        return powerRating
        
    def performGameCycle(self):
        """ Perform a single Game Cycle """
        for content in self.contentItems:
            content.performGameCycle(self.minefield, self.drone)
        
    def lost(self):
        """ Return if the player has lost the level """
        return self.destroyed() or self.noPower()
        
    def destroyed(self):
        """ Return if the player drone has been destroyed """
        return self.drone.destroyed
        
    def noPower(self):
        """ Return if the player has no power """
        return self.drone.power <= 0
        
    def won(self):
        """ Return if the player has won the level """
        won = True
        for content in self.contentItems:
            if not content.isDeactivated():
                return False
        else:
            return self.drone.power >= 0
        return won
        
    def getRemainingDefenses(self):
        """ Return the number of Remaining defenses """
        remainingDefenses = {}
        for contentClass in self.contents:
            remainingDefenses[contentClass] = 0
        
        for content in self.contentItems:
            if not content.isDeactivated():
                remainingDefenses[content.__class__] += 1
            
        return remainingDefenses
        
    def getNumberOfMinesRemaining(self):
        """ Returns the number of mines remaining to be defused """
        minesRemaining = 0
        for content in self.contentItems:
            if not content.isDeactivated():
                minesRemaining += 1
        return minesRemaining