from cursor import Cursor

from input_processor import InputProcessor
from screen import Screen

from square import Square
from mine_square import MineSquare
from num_square import NumberSquare

class PyMine:
    """ The overarching game class for the PyMine game """
    SIZE = 8
    
    def __init__(self):
        """  """
        self.field = []
        
        for i in range(self.SIZE):
            self.field.append([])
            for j in range(self.SIZE):
                self.field[i].append(Square())
                
        self.cursor = Cursor(self.SIZE)
        self.screen = Screen(self.field, self.cursor)
        self.inputProcessor = InputProcessor(self, False)
        self.running = True
        
    def run(self):
        """ Runs the main game loop """
        while self.running:
            self.screen.printScreen()
            self.inputProcessor.processInput()
        
        
    def clear(self):
        """ Clear the selected square """
        square = self.getCurrentSquare()
        square.clear()
        
    def cursorUp(self):
        """ Move the cursor up one row """
        self.cursor.up()
        
    def cursorDown(self):
        """ Move the cursor down one row """
        self.cursor.down()
        
    def cursorRight(self):
        """ Move the cursor right one column """
        self.cursor.right()
        
    def cursorLeft(self):
        """ Move the cursor left one column """
        self.cursor.left()
    
    def exit(self):
        """ Exits the game """
        self.running = False
        
    def getCurrentSquare(self):
        """ Returns the current sqaure """
        return self.field[self.cursor.row][self.cursor.col]
    