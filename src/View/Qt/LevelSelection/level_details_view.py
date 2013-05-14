from Defense.anti_drone_mine import AntiDroneMine
from Defense.mine import Mine
from Defense.fragile_mine import FragileMine
from Defense.reverse_mine import ReverseMine
from Defense.worm import Worm

from Profile.profile import CURRENT_PROFILE

from PySide.QtCore import Qt
from PySide.QtGui import QColor, QFont, QFrame, QLabel

class LevelDetailsView(QFrame):
    """ Represents the View of the Level Details """
    DEFENSE_ORDER = [Mine, ReverseMine, FragileMine, Worm, AntiDroneMine]

    def __init__(self, levelSelection, parent=None):
        """ Initialize the Level Details View """
        QFrame.__init__(self, parent)

        #self.resize(self.WIDTH, self.HEIGHT)
        self.levelSelection = levelSelection
        
        self.smallFont = QFont()
        self.smallFont.setPointSize(14)
        
        self.bigFont = QFont()
        self.bigFont.setPointSize(24)
        
        self.detailsLabel = self.getLabel("Level Details", self.bigFont, alignment=Qt.AlignCenter)
        self.detailsLabel.move(32, 16)
        self.setupGridLabel()
        self.setupDefensesLabels()
        self.setupRatingsLabel()
        
    def getLabel(self, text, font, alignment=None):
        """ Get a Level Label with the text """
        label = QLabel(text, self)
        label.setFont(font)
        if alignment:
            label.setAlignment(alignment)
        return label
        
    def setupGridLabel(self):
        """ Setup the Grid Label """
        self.gridLabel = self.getLabel("", self.smallFont)
        self.gridLabel.move(32, 48+16)
        self.gridLabel.resize(200, 32)
        
    def setupRatingsLabel(self):
        """ Setup the Ratings Label """
        self.ratingsLabel = self.getLabel("", self.smallFont)
        self.ratingsLabel.move(32, 48+16)
        self.ratingsLabel.resize(200, 32)
        
    def setupDefensesLabels(self):
        """ Setup the Remaining Defenses Labels """
        self.defensesLabels = {}
        
        for defenseClass in self.DEFENSE_ORDER:
            label = self.getLabel("", self.smallFont)
            label.setVisible(False)
            label.resize(200, 32)
            self.defensesLabels[defenseClass] = label
        
    def updateView(self):
        """ Update the View """
        self.updateGridLabel()
        self.updateDefenseLabels()
        self.updateRatingsLabel()
        self.update()
        
    def updateGridLabel(self):
        """ Update the Grid Label """
        level = self.levelSelection.getLevel()
        self.gridLabel.setText("{0} x {1}".format(level.rows, level.columns))
        
    def updateDefenseLabels(self):
        """ Update the Defense Label """
        defenses = self.levelSelection.getLevel().defenses
        labelNumber = 1
        for defenseClass in self.DEFENSE_ORDER:
            label = self.defensesLabels[defenseClass]
            if defenseClass in defenses:
                label.setVisible(True)
                label.setText("{0}: {1}".format(defenseClass.friendlyName, defenses[defenseClass]))
                label.move(32, 48+32*(labelNumber+1))
                labelNumber += 1
            else:
                label.setVisible(False)
                
    def updateRatingsLabel(self):
        """ Update the Ratings Label """
        self.ratingsLabel.move(32, 48+32*(len(self.levelSelection.getLevel().defenses)+3))
        
        text = ""
        if CURRENT_PROFILE.completedLevel(self.levelSelection.getLevel()):
            text += "C"
        if CURRENT_PROFILE.acheivedMoveAwardOnLevel(self.levelSelection.getLevel()):
            text += "M"
        if CURRENT_PROFILE.acheivedPowerAwardOnLevel(self.levelSelection.getLevel()):
            text += "P"
        self.ratingsLabel.setText(text)