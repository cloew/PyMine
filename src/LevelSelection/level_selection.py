from Level.level import Level
from Level.level_init import LevelInit

from Defense.anti_drone_mine import AntiDroneMine
from Defense.mine import Mine
from Defense.fragile_mine import FragileMine
from Defense.reverse_mine import ReverseMine
from Defense.worm import Worm

class LevelSelection:
    """ Model for selecting a Level """
    
    def __init__(self):
        """ Initialize the Level Selection """
        self.levels = [Level(LevelInit("1", 4, 5, {Mine:4})), 
                       Level(LevelInit("2", 4, 5, {Mine:4, ReverseMine:1})),
                       Level(LevelInit("3", 4, 5, {Mine:10, ReverseMine:2})),
                       Level(LevelInit("4", 4, 5, {Mine:8, ReverseMine:2, FragileMine:1})),
                       Level(LevelInit("5", 5, 6, {Mine:8, ReverseMine:2, FragileMine:1})),
                       Level(LevelInit("6", 5, 6, {Mine:8, ReverseMine:2, Worm:1})),
                       Level(LevelInit("7", 5, 6, {Mine:4, ReverseMine:2, Worm:8})),
                       Level(LevelInit("8", 4, 5, {AntiDroneMine:1}))]
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