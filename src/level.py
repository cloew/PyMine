from drone import Drone
from mine import Mine
from minefield import Minefield

class Level:
    """ Represents a Level """
    
    def __init__(self, name, numMines):
        """ Initialize the Level """
        self.name = name
        self.minefield = Minefield()
        self.drone = Drone(self.minefield)
        
        self.mines = []
        for i in range(numMines):
            mine = Mine()
            self.mines.append(mine)
            self.minefield.addMine(mine)
        
    def performGameCycle(self):
        """ Perform a single Game Cycle """
        
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
        for mine in self.mines:
            if not mine.defused:
                return False
        return won
        
    def getNumberOfMinesRemaining(self):
        """ Returns the number of mines remaining to be defused """
        minesRemaining = 0
        for mine in self.mines:
            if not mine.defused:
                minesRemaining += 1
        return minesRemaining