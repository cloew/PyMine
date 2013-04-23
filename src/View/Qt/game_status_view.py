
from PySide.QtGui import QColor, QFont, QFrame, QLabel

class GameStatusView(QFrame):
    """ It's the game status view """
    
    def __init__(self, level, parent=None):#x, y, width, height, level):
        """  """
        QFrame.__init__(self, parent)
        #self.x = x
        #self.y = y
        #self.width = width
        #self.height = height
        
        self.level = level
        
        self.powerLabel = QLabel("", self)
        self.remainingMinesLabel = QLabel("", self)
        
        self.updateView()
        
    def updateView(self):
        """ Update the View """
        self.updatePowerLabel()
        self.updateRemainingMinesLabel()
        self.update()
        
    def updatePowerLabel(self):
        """ Update the Power Label """
        self.powerLabel.setText("Power: {0}".format(self.level.drone.power))
        
    def updateRemainingMinesLabel(self):
        """ Update the Remaining Mines Label """
        self.powerLabel.setText("Mines Left: {0}".format(self.level.getNumberOfMinesRemaining()))
        
    def draw(self, painter):
        """ Draw the Game Status Panel """
        painter.fillRect(self.x, self.y, self.width, self.height, QColor(200, 200, 200))
        
        font = QFont()
        font.setPointSize(24)
        painter.setFont(font)
        painter.drawText(self.x+32, self.y+32+64, "Power: {0}".format(self.level.drone.power))
        
        painter.drawText(self.x+32, self.y+32+64+64, "Mines Left: {0}".format(self.level.getNumberOfMinesRemaining()))