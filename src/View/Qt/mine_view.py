from PySide.QtCore import Qt
from PySide.QtGui import QFrame, QImage, QLabel, QMatrix, QPixmap

class MineView(QFrame):
    """ Represents the Graphical view of the Drone """

    def __init__(self, mine, parent=None):
        """ Initialize the drone view """
        QFrame.__init__(self, parent)
        self.mine = mine
        self.scaled_mine = None
        self.scaled_defused_mine = None
        self.loadMineImage()
        self.setVisible(False)
        self.resize(64, 64)

    def loadMineImage(self):
        """ Load the drone image """
        self.unscaled_mine = QImage("Mine1.png")
        self.scaled_mine = self.unscaled_mine.scaled(64, 64)
        self.mine_pixmap = QPixmap()
        self.mine_pixmap.convertFromImage(self.scaled_mine)
        self.mine_label = QLabel(self)
        self.mine_label.setPixmap(self.mine_pixmap)
        self.mine_label.move(0, 0)
        
        self.unscaled_defused_mine = QImage("DefusedMine1.png")
        self.scaled_defused_mine = self.unscaled_defused_mine.scaled(64, 64)
        self.defused_mine_pixmap = QPixmap()
        self.defused_mine_pixmap.convertFromImage(self.scaled_defused_mine)
        self.defused_mine_label = QLabel(self)
        self.defused_mine_label.setPixmap(self.defused_mine_pixmap)
        self.defused_mine_label.move(0, 0)
        self.defused_mine_label.setVisible(False)

    def updateView(self):
        """  """
        if self.mine.defused:
            self.setVisible(True)
            self.defused_mine_label.setVisible(True)
            self.mine_label.setVisible(False)