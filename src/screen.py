from console_helper import cls

class Screen:
    """ Class to print to the screen """
    
    def __init__(self, field):
        """  """
        self.field = field
    
    def printScreen(self):
        """ Prints the game fiedl to the screen """
        cls()
        self.printColumnHeaders()
        self.printField()
            
    def printColumnHeaders(self):
        """ Prints the column headers """ 
        print "  ",
        for i in range(len(self.field)):
            print i,
        print "\r"
        
    def printField(self):
        """ Prints the mine field """
        for row in self.field:
            print "%s:" % self.field.index(row),
            for square in row:
                print square.display(),
            print "\r"