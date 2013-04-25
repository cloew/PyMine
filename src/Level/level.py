from drone import Drone
from minefield import Minefield
from Mine.mine import Mine
from Mine.reverse_mine import ReverseMine

class Level:
    """ Represents a Level """
    
    def __init__(self, name, rows, columns, numMines, numReverseMines):
        """ Initialize the Level """
        self.name = name
        self.rows = rows
        self.columns = columns
        self.numMines = numMines
        self.numReverseMines = numReverseMines
        self.reset()
        
    def reset(self):
        """ Reset the Level """
        self.minefield = Minefield(self.rows, self.columns)
        self.drone = Drone(self.getPowerRating(), self.minefield)
        
        self.mines = []
        for i in range(self.numMines):
            mine = Mine()
            self.mines.append(mine)
            self.minefield.addMine(mine)
            
        for i in range(self.numReverseMines):
            mine = ReverseMine()
            self.mines.append(mine)
            self.minefield.addMine(mine)
            
    def getPowerRating(self):
        """ Returns the amount of power the drone should have on the level """
        powerRating = self.minefield.rowCount()*self.minefield.columnCount()*2
        powerRating += self.numMines*5
        powerRating += self.numReverseMines*5
        return powerRating
        
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