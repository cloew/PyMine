from PySide.QtCore import QRect
from PySide.QtGui import QColor, QFont, QFrame, QLabel, QPalette

class GameStatusView(QFrame):
    """ It's the game status view """
    
    def __init__(self, level, width, height, parent=None):
        """  """
        QFrame.__init__(self, parent)
        self.level = level
        
        self.setup()
        
        self.updateView()
        self.color = QColor(200, 200, 200)
        self.setStyleSheet("QFrame { background-color: %s }" % self.color.name()) 
        self.setFrameRect(QRect(0, 0, width, height))
        self.resize(width, height)
        
    def setup(self):
        """ Setup the View """
        self.setupFont()
        self.setupPowerLabel()
        self.setupRemainingMinesLabel()
        
    def setupFont(self):
        """ Setup the Font """
        self.font = QFont()
        self.font.setPointSize(24)
        
    def setupPowerLabel(self):
        """ Setup the Power Label """
        self.powerLabel = QLabel("", self)
        self.powerLabel.move(32, 16)
        self.powerLabel.setFont(self.font)
        
    def setupRemainingMinesLabel(self):
        """ Setup the Remaining Mines Label """
        self.remainingMinesLabel = QLabel("", self)
        self.remainingMinesLabel.move(32, 64)
        self.remainingMinesLabel.setFont(self.font)
        
    def updateView(self):
        """ Update the View """
        self.updatePowerLabel()
        self.updateRemainingMinesLabel()
        
    def updatePowerLabel(self):
        """ Update the Power Label """
        self.powerLabel.setText("Power: {0}".format(self.level.drone.power))
        
    def updateRemainingMinesLabel(self):
        """ Update the Remaining Mines Label """
        self.remainingMinesLabel.setText("Mines Left: {0}".format(self.level.getNumberOfMinesRemaining()))
        
    def draw(self, painter):
        """ Draw the Game Status Panel """
        painter.fillRect(self.x, self.y, self.width, self.height, QColor(200, 200, 200))
        
        font = QFont()
        font.setPointSize(24)
        painter.setFont(font)
        painter.drawText(self.x+32, self.y+32+64, "Power: {0}".format(self.level.drone.power))
        
        painter.drawText(self.x+32, self.y+32+64+64, "Mines Left: {0}".format(self.level.getNumberOfMinesRemaining()))