from console_helper import cls

class Screen:
    """ Class to print to the screen """
    
    def __init__(self, field, cursor):
        """  """
        self.cursor = cursor
        self.field = field
    
    def printScreen(self):
        """ Prints the game fiedl to the screen """
        cls()
        self.printColumnHeaders()
        self.printField()
            
    def printColumnHeaders(self):
        """ Prints the column headers """ 
        print "  ",
        for i in range(len(self.field.field)):
            print " %d" % i,
        print "\r"
        
    def printField(self):
        """ Prints the mine field """
        for row in self.field.field:
            rowIndex = self.field.field.index(row)
            print "%s:" % rowIndex,
            s = ""
            for square in row:
                filler, next = self.getFiller(rowIndex, row.index(square))
                s += filler + square.display() + next
            print "%s\r" % s
            
    def getFiller(self, row, col):
        """ Get filler characters """
        if row == self.cursor.row and col == self.cursor.col:
            return "[", "]"
        else:
            return " ", " "
            