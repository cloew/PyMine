from DefenseAdder.standard_adder import StandardDefenseAdder

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
                self.addDefense(contentClass)
                # content = contentClass()
                # self.contentItems.append(content)
                # self.minefield.addMine(content)
                
    def addDefense(self, contentClass):
        """ Add a Defense to the minefield """
        content = contentClass()
        defenseAdder = StandardDefenseAdder()
        
        self.contentItems.append(content)
        defenseAdder.addDefense(content, self.minefield)
            
    def getPowerRating(self):
        """ Returns the amount of power the drone should have on the level """
        powerRating = self.minefield.rowCount()*self.minefield.columnCount()*2
        for contentClass in self.contents:
            powerRating += self.contents[contentClass]*contentClass.powerRating
        return powerRating
        
    def performGameCycle(self):
        """ Perform a single Game Cycle """
        if not self.finished():
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
        
    def finished(self):
        """ Return if the level is finished """
        return self.lost() or self.won()
        
    def getRemainingDefenses(self):
        """ Return the number of Remaining defenses """
        remainingDefenses = {}
        for contentClass in self.contents:
            remainingDefenses[contentClass] = 0
        
        for content in self.contentItems:
            if not content.isDeactivated():
                remainingDefenses[content.__class__] += 1
            
        return remainingDefenses