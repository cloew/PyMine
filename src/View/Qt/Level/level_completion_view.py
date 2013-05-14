from PySide.QtGui import QColor, QFrame, QFont, QLabel

class LevelCompletionView(QFrame):
    """ View of the Level Completion Status """
    
    def __init__(self, level, width, height, parent=None):
        """ Initialize the Level Completion View """
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
        self.setupLevelCompletionLabel()
        self.setupCompletionDetailsLabel()
        
    def setupFont(self):
        """ Setup the Font """
        self.font = QFont()
        self.font.setPointSize(32)
        
    def setupLevelCompletionLabel(self):
        """ Setup the Power Label """
        self.font = QFont()
        self.font.setPointSize(32)
        
        self.levelCompletionLabel = QLabel("You Won!", self)
        self.levelCompletionLabel.move(32, 16)
        self.levelCompletionLabel.setFont(self.font)
        self.levelCompletionLabel.setVisible(False)
        
    def setupCompletionDetailsLabel(self):
        """ Setup the Remaining Mines Label """
        self.font = QFont()
        self.font.setPointSize(24)
        
        self.completionDetailsLabel = QLabel("Destroyed!", self)
        self.completionDetailsLabel.move(32, 64)
        self.completionDetailsLabel.setFont(self.font)
        self.completionDetailsLabel.setVisible(False)
        
    def updateView(self):
        """ Update the View """
        self.updateLevelCompletionLabel()
        self.updateCompletionDetailsLabel()
        
    def updateLevelCompletionLabel(self):
        """ Update the Power Label """
        if self.level.won():
            self.levelCompletionLabel.setText("You Won!")
            self.levelCompletionLabel.setVisible(True)
        elif self.level.lost():
            self.levelCompletionLabel.setText("Game Over!")
            self.levelCompletionLabel.setVisible(True)
        
    def updateCompletionDetailsLabel(self):
        """ Update the Remaining Mines Label """
        if self.level.destroyed():
            self.completionDetailsLabel.setText("Destroyed")
            self.completionDetailsLabel.setVisible(True)
        elif self.level.noPower() and not self.level.won():
            self.completionDetailsLabel.setText("Insufficient Power")
            self.completionDetailsLabel.setVisible(True)
        elif self.level.won():
            text = ""
            if self.level.completionRating.awarded:
                text += "C"
            if self.level.moveRating.awarded:
                text += "M"
            self.completionDetailsLabel.setText(text)
            self.completionDetailsLabel.setVisible(True)