from grid_square import GridSquare

from random import randint

class Minefield:
    """ Represents the Minefield for the current level """
    
    def __init__(self, rows, columns):
        """ Initialize the mine field """
        self.squares = []
        
        for row in range(rows):
            self.squares.append([])
            for column in range(columns):
                self.squares[row].append(GridSquare(row, column))
                
    def scan(self, row, column, drone):
        """ Scan the given Grid Square """
        self.getSquare(row, column).scan(drone)
        
    def defuse(self, row, column, drone):
        """ Defuse the given Grid Square """
        self.getSquare(row, column).defuse(drone)
        
    def defuseCarefully(self, row, column, drone):
        """ Defuse the given Grid Square """
        self.getSquare(row, column).defuseCarefully(drone)
        
    def performEMP(self, row, column, drone):
        """ Performan EMP Blast """
        centerSquare = self.getSquare(row, column)
        for square in self.getAdjacentSquares(centerSquare, includeCenter=True):
            square.hitByEMP(drone)
    
    def addMine(self, mine):
        """ Adds a Mine to the Minefield """
        while True:
            row = randint(0, self.rowCount()-1)
            column = randint(1, self.columnCount()-1)
            square = self.getSquare(row, column)
            if square.mined():
                continue
            else:
                square.setGroundContent(mine)
                mine.gridSquare = square
                break
        
    def getSquare(self, row, column):
        """ Return the square at the location """
        if row < 0 or column < 0 or row >= self.rowCount() or column >= self.columnCount():
            return None
        else:
            return self.squares[row][column]
            
    def getAdjacentSquares(self, centerSquare, includeCenter=False):
        """ Get Squares adjacent to the given square """
        squares = []
        for row in (centerSquare.row-1, centerSquare.row, centerSquare.row+1):
            for column in (centerSquare.column-1, centerSquare.column, centerSquare.column+1):
                square = self.getSquare(row, column)
                if not includeCenter and square is centerSquare:
                    continue
                if square is not None:
                    squares.append(square)
        return squares
    
    def rowCount(self):
        """ Return the Row Count """
        return len(self.squares)
    
    def columnCount(self):
        """ Return the Column Count """
        return len(self.squares[0])
        
    def __repr__(self):
        """ Print the String representation of the Minefield """
        fieldString = ""
        for row in self.squares:
            for column in row:
                fieldString += "|{0}".format(column)
            fieldString += "|\n"
        return fieldString