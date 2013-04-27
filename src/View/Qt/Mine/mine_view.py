from View.Qt.image_loader import LoadImageLabel

from PySide.QtGui import QFrame

class MineView(QFrame):
    """ Represents the Graphical view of the Drone """

    def __init__(self, mine, parent=None):
        """ Initialize the drone view """
        QFrame.__init__(self, parent)
        self.mine = mine
        self.loadMineImages()
        self.setVisible(False)
        self.resize(64, 64)

    def loadMineImages(self):
        """ Load the drone image """
        self.mine_label = self.loadMineImage("Mine1.png")
        self.defused_mine_label = self.loadMineImage("DefusedMine1.png", visible=False)
        
    def loadMineImage(self, filename, visible=True):
        """ Load a Mine Image from the given filename """
        mineImage = LoadImageLabel(filename, scaledXSize=64, scaledYSize=64, parent=self)
        mineImage.move(0, 0)
        mineImage.setVisible(visible)
        return mineImage

    def updateView(self):
        """  """
        if self.mine.defused:
            self.setVisible(True)
            self.defused_mine_label.setVisible(True)
            self.mine_label.setVisible(False)