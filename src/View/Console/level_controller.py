from drone import Drone
from minefield import Minefield

from View.Console.minefield_view import MinefieldView

from kao_console import getch
from kao_console.ascii import ESCAPE, KAO_UP, KAO_DOWN

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
            self.processInput()
            
    def processInput(self):
        """ Process the input """
        kao_char = getch()
        if kao_char == KAO_DOWN:
            self.drone.down(self.minefield)
        elif kao_char == ESCAPE:
            self.running = False
            