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
                
        self.squares[row][column].addContent(Mine())
                
    def scan(self, row, column):
        """ Scan the given Grid Square """
        self.squares[row][column].scan()
    
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
            