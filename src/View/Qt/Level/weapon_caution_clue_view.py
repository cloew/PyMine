from View.Qt.image_loader import LoadImageLabel

from PySide.QtGui import QFrame

class WeaponCautionClueView(QFrame): # Prolly could use a better name
    """ Represents a Weapon Caution Clue View """
    
    def __init__(self, weaponCautionClue, parent=None):
        """ Initialize the Weapon Caution Clue View """
        QFrame.__init__(self, parent)
        self.weaponCautionClue = weaponCautionClue
        self.resize(16, 15)
        self.loadImage()
        self.setVisible(False)
        
    def loadImage(self):
        """ Load the Warning Image """
        self.image = LoadImageLabel("warning.gif", parent=self)
        self.image.move(0, 0)
        
    def updateView(self):
        """ Update the View """
        self.setVisible(self.weaponCautionClue.nearWeapons)