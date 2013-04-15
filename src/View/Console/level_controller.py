from level import Level

from View.Console.minefield_view import MinefieldView

from kao_console import getch
from kao_console.ascii import ESCAPE, KAO_UP, KAO_DOWN, KAO_LEFT, KAO_RIGHT

class LevelController:
    """ Controller class for the level """
    
    def __init__(self):
        """ Initialize the Level Controller """
        self.level = Level(4)
        self.minefield_view = MinefieldView(self.level.minefield, self.level.drone)
        
        self.actions = {KAO_UP:self.level.drone.up,
                        KAO_DOWN:self.level.drone.down,
                        KAO_LEFT:self.level.drone.left,
                        KAO_RIGHT:self.level.drone.right,
                        ord('s'):self.level.drone.scan,
                        ord('d'):self.level.drone.defuse,
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
            self.checkGameOver()
            
    def processInput(self):
        """ Process the input """
        kao_char = getch()
        if kao_char in self.actions:
            self.actions[kao_char]()
            
    def stopRunning(self):
        """ Stop the Controller from running """
        self.running = False
            
    def checkGameOver(self):
        """ Check if the Game is Over """
        if self.level.lost():
            self.stopRunning()
            print "Game Over\r"
        elif self.level.won():
            self.stopRunning()
            print "Congratulations! You won!"