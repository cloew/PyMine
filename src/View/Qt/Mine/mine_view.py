from View.Qt.Level.grid_square_frame import GridSquareFrame

class MineView(GridSquareFrame):
    """ Represents the Graphical view of a Mine """
    DEFUSED_IMAGE_FILENAME = "DefusedMine1.png"
    REGULAR_IMAGE_FILENAME = "Mine1.png"
    
    def __init__(self, mine, parent=None):
        """ Initialize the mine view """
        GridSquareFrame.__init__(self, parent)
        self.mine = mine
        self.loadMineImages()
        self.setVisible(False)

    def loadMineImages(self):
        """ Load the Mine images """
        self.mine_label = self.loadGridSquareSizedImage(self.REGULAR_IMAGE_FILENAME)
        self.defused_mine_label = self.loadGridSquareSizedImage(self.DEFUSED_IMAGE_FILENAME, visible=False)

    def updateView(self):
        """  """
        if self.mine.defused:
            self.setVisible(True)
            self.defused_mine_label.setVisible(True)
            self.mine_label.setVisible(False)