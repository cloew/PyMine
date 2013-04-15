from drone import Drone
from minefield import Minefield

from View.Console.minefield_view import MinefieldView

class LevelController:
    """ Controller class for the level """
    
    def __init__(self):
        """ Initialize the Level Controller """
        self.drone = Drone()
        self.minefield = Minefield()
        self.minefield_view = MinefieldView(self.minefield, self.drone)
        
    def run(self):
        """ Run the controller """
        self.running = True
        self.loop()
        
    def loop(self):
        """ Run the controller main loop """
        while self.running:
            print self.minefield_view
            self.running = False
            