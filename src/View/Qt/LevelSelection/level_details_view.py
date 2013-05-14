from Defense.anti_drone_mine import AntiDroneMine
from Defense.mine import Mine
from Defense.fragile_mine import FragileMine
from Defense.reverse_mine import ReverseMine
from Defense.worm import Worm

from PySide.QtCore import Qt
from PySide.QtGui import QColor, QFont, QFrame, QLabel

class LevelDetailsView(QFrame):
    """ Represents the View of the Level Details """

    def __init__(self, levelSelection, parent=None):
        """ Initialize the Level Details View """
        QFrame.__init__(self, parent)

        #self.resize(self.WIDTH, self.HEIGHT)
        self.levelSelection = levelSelection
        
        self.smallFont = QFont()
        self.smallFont.setPointSize(14)
        
        self.bigFont = QFont()
        self.bigFont.setPointSize(24)
        
        self.detailsLabel = self.getLabel("Level Details", self.bigFont)
        self.detailsLabel.move(32, 16)
        self.setupDefensesLabels()
        
    def getLabel(self, text, font):
        """ Get a Level Label with the text """
        label = QLabel(text, self)
        label.setFont(font)
        label.setAlignment(Qt.AlignCenter)
        return label
        
    def setupDefensesLabels(self):
        """ Setup the Remaining Defenses Labels """
        self.defensesLabels = {}
        
        for defenseClass in [AntiDroneMine, Mine, FragileMine, ReverseMine, Worm]:
            label = self.getLabel("", self.smallFont)
            label.setVisible(False)
            self.defensesLabels[defenseClass] = label
        
    def updateView(self):
        """ Update the View """
        self.hideDefenseLabels()
        self.updateDefenseLabels()
        self.update()
        
    def hideDefenseLabels(self):
        """ Hide Defense Labels """
        for defenseClass in self.defensesLabels:
            label = self.defensesLabels[defenseClass]
            label.setVisible(False)
        
    def updateDefenseLabels(self):
        """ Update the Defense Label """
        defenses = self.levelSelection.getLevel().defenses
        labelNumber = 1
        for defenseClass in defenses:
            label = self.defensesLabels[defenseClass]
            label.setVisible(True)
            label.setText("{0}: {1}".format(defenseClass.friendlyName, defenses[defenseClass]))
            label.move(32, 16+32*(labelNumber+1))
            labelNumber += 1