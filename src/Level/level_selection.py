from level import Level

from Mine.mine import Mine
from Mine.fragile_mine import FragileMine
from Mine.reverse_mine import ReverseMine

class LevelSelection:
    """ Model for selecting a Level """
    
    def __init__(self):
        """ Initialize the Level Selection """
        self.levels = [Level("Level 1", 4, 5, {Mine:4}), 
                       Level("Level 2", 4, 5, {Mine:4, ReverseMine:1}), 
                       Level("Level 3", 4, 5, {Mine:10, ReverseMine:2})]
        self.selectedIndex = 0
        
    def performGameCycle(self):
        """ Perform a Game Cycle """
        
    def getLevel(self):
        """ Return the selected Level """
        return self.levels[self.selectedIndex]
        
    def nextLevel(self):
        """ Select the next level """
        if self.selectedIndex < len(self.levels)-1:
            self.selectedIndex += 1
            
    def previousLevel(self):
        """ Select the Previous Level """
        if self.selectedIndex > 0:
            self.selectedIndex -= 1
        