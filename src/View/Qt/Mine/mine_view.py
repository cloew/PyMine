from View.Qt.image_loader import LoadImageLabel
from View.Qt.Level.grid_square_frame import GridSquareFrame

class MineView(GridSquareFrame):
    """ Represents the Graphical view of a Mine """

    def __init__(self, mine, parent=None):
        """ Initialize the mine view """
        GridSquareFrame.__init__(self, parent)
        self.mine = mine
        self.loadMineImages()
        self.setVisible(False)

    def loadMineImages(self):
        """ Load the Mine images """
        self.mine_label = self.loadGridSquareSizedImage("Mine1.png")
        self.defused_mine_label = self.loadGridSquareSizedImage("DefusedMine1.png", visible=False)

    def updateView(self):
        """  """
        if self.mine.defused:
            self.setVisible(True)
            self.defused_mine_label.setVisible(True)
            self.mine_label.setVisible(False)