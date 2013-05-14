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
        self.resize(width, height)
        
    def setup(self):
        """ Setup the View """
        self.setupFont()
        self.setupPowerLabel()
        self.setupMovesLabel()
        self.setupRemainingDefensesLabels()
        
    def setupFont(self):
        """ Setup the Font """
        self.font = QFont()
        self.font.setPointSize(14)
        
    def setupPowerLabel(self):
        """ Setup the Power Label """
        self.powerLabel = QLabel("", self)
        self.powerLabel.move(32, 16)
        self.powerLabel.setFont(self.font)
        
    def setupMovesLabel(self):
        """ Setup the Moves Label """
        self.movesLabel = QLabel("", self)
        self.movesLabel.move(32, 16+48)
        self.movesLabel.setFont(self.font)
        
    def setupRemainingDefensesLabels(self):
        """ Setup the Remaining Defenses Labels """
        self.remainingDefensesLabels = {}
        labelNumber = 1
        remainingDefenses = self.level.getRemainingDefenses()
        for defenseClass in remainingDefenses:
            label = QLabel("", self)
            label.move(32, 16+48*(labelNumber+1))
            label.setFont(self.font)
            self.remainingDefensesLabels[defenseClass] = label
            labelNumber += 1
        
    def updateView(self):
        """ Update the View """
        self.updatePowerLabel()
        self.updateMovesLabel()
        self.updateRemainingDefensesLabels()
        
    def updatePowerLabel(self):
        """ Update the Power Label """
        self.powerLabel.setText("Power: {0}".format(self.level.drone.powerRating.power))
        
    def updateMovesLabel(self):
        """ Update the Moves Label """
        self.movesLabel.setText("Moves: {0}".format(self.level.moveRating.moveCount))
        self.movesLabel.resize(self.movesLabel.contentsRect().width(), self.movesLabel.contentsRect().height())
        
    def updateRemainingDefensesLabels(self):
        """ Update the Remaining Mines Label """
        remainingDefenses = self.level.getRemainingDefenses()
        
        for defenseClass in remainingDefenses:
            label = self.remainingDefensesLabels[defenseClass]
            label.setText("{0} Left: {1}".format(defenseClass.friendlyName, remainingDefenses[defenseClass]))