from drone import Drone
from minefield import Minefield

from View.Console.minefield_view import MinefieldView

from kao_console import getch
from kao_console.ascii import ESCAPE, KAO_UP, KAO_DOWN, KAO_LEFT, KAO_RIGHT

class LevelController:
    """ Controller class for the level """
    
    def __init__(self):
        """ Initialize the Level Controller """
        self.minefield = Minefield()
        self.drone = Drone(self.minefield)
        self.minefield_view = MinefieldView(self.minefield, self.drone)
        
        self.actions = {KAO_UP:self.drone.up,
                        KAO_DOWN:self.drone.down,
                        KAO_LEFT:self.drone.left,
                        KAO_RIGHT:self.drone.right,
                        ord(' '):self.drone.scan,
                        ESCAPE:self.stopRunning}
        
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
        if kao_char in self.actions:
            self.actions[kao_char]()
            
    def stopRunning(self):
        """ Stop the Controller from running """
        self.running = False
            