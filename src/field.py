from square import Square
from mine_square import MineSquare

import random

class Field:
    """ Represents the mine field """
    
    def __init__(self, size):
        """ Initializes the mine field """
        self.field = []
        self.size = size
        self.numMines = 4
        
        self.allocateField()
        self.placeMines()
        self.fillField()
                
    def allocateField(self):
        """ Builds the field to be the right size """
        for i in range(self.size):
            self.field.append([])
            for j in range(self.size):
                self.field[i].append(None)
                
    def placeMines(self):
        """ Place mines throughout the field """
        for i in range(self.numMines):
            row = random.randint(0, self.size-1)
            col = random.randint(1, self.size-1)
            
            self.setSquareAt(row, col, MineSquare())
            
    def fillField(self):
        """ Fills the field with default squares """
        for row in self.field:
            for square in row:
                if square is None:
                    self.setSquareAt(self.field.index(row),  row.index(square), Square())
                    
    def squareAt(self, row, col):
        """ Returns the square at the given row and column """
        return self.field[row][col]
        
    def setSquareAt(self, row, col, square):
        """ Sets the square at the given location to the given square """
        self.field[row][col] = square