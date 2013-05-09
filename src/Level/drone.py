from power_ratings import CAREFUL_DEFUSE_POWER, DEFUSE_POWER, EMP_POWER, SCAN_POWER

from nytram.core.game_engine import TheGameEngine

class Drone:
    """ Represents the Player's Drone """
    
    def __init__(self, power, minefield):
        """ Intialize the Player's Drone """
        self.row = 0
        self.column = 0
        self.power = power
        
        self.minefield = minefield
        self.destroyed = False
        
    def scan(self):
        """ Scan the current cell """
        self.power -= SCAN_POWER
        self.minefield.scan(self.row, self.column, self)
        TheGameEngine.updateUI()
        
    def defuse(self):
        """ Defuse the current cell """
        self.power -= DEFUSE_POWER
        self.minefield.defuse(self.row, self.column, self)
        TheGameEngine.updateUI()
        
    def defuseCarefully(self):
        """ Carfeully defuse a Fragile mine """
        self.power -= CAREFUL_DEFUSE_POWER
        self.minefield.defuseCarefully(self.row, self.column, self)
        TheGameEngine.updateUI()
        
    def performEMP(self):
        """ Performan EMP Blast """
        self.power -= EMP_POWER
        self.minefield.performEMP(self.row, self.column, self)
        TheGameEngine.updateUI()
        
    def destroy(self):
        """ Destroy the drone """
        self.destroyed = True
        
    def up(self):
        """  """
        if self.row > 0:
            self.move(-1, 0)
        
    def down(self):
        """ """
        if self.row < self.minefield.rowCount()-1:
            self.move(1, 0)
    
    def left(self):
        """ """
        if self.column > 0:
            self.move(0, -1)
    
    def right(self):
        """ """
        if self.column < self.minefield.columnCount()-1:
            self.move(0, 1)
            
    def move(self, rowMovement, columnMovement):
        """ Move the drone """
        self.row += rowMovement
        self.column += columnMovement
        
        square = self.minefield.getSquare(self.row, self.column)
        square.onMove(self)
        TheGameEngine.updateUI()