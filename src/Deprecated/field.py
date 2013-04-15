from square import Square
from mine_square import MineSquare
from num_square import NumberSquare

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
            
            print row, col
            self.setSquareAt(row, col, MineSquare())
            self.updateAdjacentSquares(row, col)
            
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

    def updateAdjacentSquares(self, row, col):
        """ Updates adjacent squares to add hint squares """
        minRow, maxRow = self.getMinAndMax(row)
        minCol, maxCol = self.getMinAndMax(col)
        
        for  adjRow in range(minRow, maxRow):
            for adjCol in range(minCol, maxCol):
                square = self.squareAt(adjRow, adjCol)
                if square is None:
                    self.setSquareAt(adjRow, adjCol, NumberSquare(1))
                elif square.TYPE == NumberSquare.TYPE:
                    self.setSquareAt(adjRow, adjCol, NumberSquare(square.num+1))
        
    def getMinAndMax(self, value):
        """ Returns the potential min and max values for the adjacent squares """
        min = value -1
        max = value + 2
        
        return self.normalize(min), self.normalize(max)
        
    def normalize(self, value):
        """ Normalizes the value so it fits in the min and max values of the field """
        if value < 0:
            value = 0
        if value > self.size:
            value = self.size
        return value