
class MinefieldView:
    """ Represents the View of the Minefield """
    
    def __init__(self, field, drone):
        """ Initialize the Minefield View """
        self.field = field
        self.drone = drone
        
    def __repr__(self):
        """ Print the string representation of the Minefield View """
        fieldString = ""
        for row in self.field.squares:
            for square in row:
                fieldString += self.getSquareString(square)
            fieldString += "\r\n"
        return fieldString
                
    def getSquareString(self, square):
        """ Get Square String """
        if square.row == self.drone.row and square.column == self.drone.column:
            return "[{0}]".format(square)
        else:
            return " {0} ".format(square)