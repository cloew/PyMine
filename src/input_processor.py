from console_helper import *

class InputProcessor:
    """ Processor of command line input """
    
    def __init__(self, parent, debug):
        """ Set up the Input Processor """
        self.debugging = debug
        self.cmds = {ESCAPE:self.processEscape,
                           ENDL:parent.clear}
                           
                           
        self.escapeCmds = {ESCAPE:parent.exit,
                                     ARROW_ESCAPE:self.processArrowEscape}
                                     
        self.arrowCmds = {UP_ARROW:parent.cursorUp,
                                   DOWN_ARROW:parent.cursorDown,
                                   LEFT_ARROW:parent.cursorLeft,
                                   RIGHT_ARROW:parent.cursorRight}
        
    def processInput(self):
        """ Processes the command line input """
        c, val = self.getInput()
        
        if val in self.cmds.keys():
            self.cmds[val]()
            
    def processEscape(self):
        """ Processes an escape sequence """
        c, val = self.getInput()
        
        if val in self.escapeCmds.keys():
            self.escapeCmds[val]()
        
    def processArrowEscape(self):
        """ Processes an Arrow Excape command """
        c, val = self.getInput()
        
        if val == DELETE:
                self.getInput()
        
        if val in self.arrowCmds.keys():
            self.arrowCmds[val]()
            
    def getInput(self):
        """ Gets a char and its ord """
        c = getch()
        val = ord(c)
        
        if self.debugging:
            print val, "\r"
        
        return c, val