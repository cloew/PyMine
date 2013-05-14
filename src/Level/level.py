from drone import Drone
from minefield import Minefield

from Level.Rating.completion_rating import CompletionRating

class Level:
    """ Represents a Level """
    
    def __init__(self, name, rows, columns, defenses):
        """ Initialize the Level """
        self.name = name
        self.rows = rows
        self.columns = columns
        self.defenses = defenses
        
        self.reset()
        
    def reset(self):
        """ Reset the Level """
        self.minefield = Minefield(self.rows, self.columns)
        self.drone = Drone(self.getPowerRating(), self.minefield)
        self.completionRating = CompletionRating(self)
        
        self.defenseItems = []
        for defenseClass in self.defenses:
            for i in range(self.defenses[defenseClass]):
                self.addDefense(defenseClass)
                
    def addDefense(self, defenseClass):
        """ Add a Defense to the minefield """
        defense = defenseClass()
        defenseAdder = defenseClass.adderClass()
        
        self.defenseItems.append(defense)
        defenseAdder.addDefense(defense, self.minefield)
            
    def getPowerRating(self):
        """ Returns the amount of power the drone should have on the level """
        powerRating = self.minefield.rowCount()*self.minefield.columnCount()*2
        for defenseClass in self.defenses:
            powerRating += self.defenses[defenseClass]*defenseClass.powerRating
        return powerRating
        
    def performGameCycle(self):
        """ Perform a single Game Cycle """
        if not self.finished():
            for defense in self.defenseItems:
                defense.performGameCycle(self.minefield, self.drone)
        else:
            self.tryToAwardRatings()
        
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
        for defense in self.defenseItems:
            if not defense.isDeactivated():
                return False
        else:
            return self.drone.power >= 0
        return won
        
    def finished(self):
        """ Return if the level is finished """
        return self.lost() or self.won()
        
    def tryToAwardRatings(self):
        """ Try To award the Ratings """
        self.completionRating.checkAwarded()
        
    def getRemainingDefenses(self):
        """ Return the number of Remaining defenses """
        remainingDefenses = {}
        for defenseClass in self.defenses:
            remainingDefenses[defenseClass] = 0
        
        for defense in self.defenseItems:
            if not defense.isDeactivated():
                remainingDefenses[defense.__class__] += 1
            
        return remainingDefenses