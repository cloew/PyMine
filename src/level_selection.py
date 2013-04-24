from level import Level

class LevelSelection:
    """ Model for selecting a Level """
    
    def __init__(self):
        """ Initialize the Level Selection """
        self.levels = [Level(4), Level(5)]
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
        