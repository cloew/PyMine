from grid_square import GridSquare
from mine import Mine

class Minefield:
    """ Represents the Minefield for the current level """
    
    def __init__(self):
        """ Initialize the mine field """
        self.squares = []
        
        for row in range(4):
            self.squares.append([])
            for column in range(5):
                self.squares[row].append(GridSquare(row, column))
                
        self.getSquare(1, 2).addContent(Mine())
                
    def scan(self, row, column, drone):
        """ Scan the given Grid Square """
        self.getSquare(row, column).scan(drone)
        
    def defuse(self, row, column, drone):
        """ Defuse the given Grid Square """
        self.getSquare(row, column).defuse(drone)
        
    def getSquare(self, row, column):
        """ Return the square at the location """
        if row < 0 or column < 0 or row >= self.rowCount() or column >= self.columnCount():
            return None
        else:
            return self.squares[row][column]
    
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
            