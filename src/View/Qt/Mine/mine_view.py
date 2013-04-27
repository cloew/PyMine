from View.Qt.image_loader import LoadImageLabel

from PySide.QtGui import QFrame

class MineView(QFrame):
    """ Represents the Graphical view of the Drone """

    def __init__(self, mine, parent=None):
        """ Initialize the drone view """
        QFrame.__init__(self, parent)
        self.mine = mine
        self.loadMineImage()
        self.setVisible(False)
        self.resize(64, 64)

    def loadMineImage(self):
        """ Load the drone image """
        self.mine_label = LoadImageLabel("Mine1.png", scaledXSize=64, scaledYSize=64, parent=self)
        self.mine_label.move(0, 0)
        
        self.defused_mine_label = LoadImageLabel("DefusedMine1.png", scaledXSize=64, scaledYSize=64, parent=self)
        self.defused_mine_label.move(0, 0)
        self.defused_mine_label.setVisible(False)

    def updateView(self):
        """  """
        if self.mine.defused:
            self.setVisible(True)
            self.defused_mine_label.setVisible(True)
            self.mine_label.setVisible(False)