from grid_square import GridSquare

class Minefield:
    """ Represents the Minefield for the current level """
    
    def __init__(self):
        """ Initialize the mine field """
        self.squares = []
        
        for row in range(4):
            self.squares.append([])
            for column in range(5):
                self.squares[row].append(GridSquare())
        
    def __repr__(self):
        """ Print the String representation of the Minefield """
        fieldString = ""
        for row in self.squares:
            for column in row:
                fieldString += "|{0}".format(column)
            fieldString += "|\n"
        return fieldString
            