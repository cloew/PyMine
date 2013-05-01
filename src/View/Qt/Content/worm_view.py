from View.Qt.Level.grid_square_frame import GridSquareFrame

class WormView(GridSquareFrame):
    """ Represents the Worm """
    REGULAR_IMAGE_FILENAME = "Worm.png"
    
    def __init__(self, worm, parent=None):
        """ Initialize the worm view """
        GridSquareFrame.__init__(self, parent)
        self.worm = worm
        self.loadMineImages()
        self.setVisible(False)
    
    def loadMineImages(self):
        """ Load the Mine images """
        self.mine_label = self.loadGridSquareSizedImage(self.REGULAR_IMAGE_FILENAME)
        
    def updateView(self):
        """ Update the View """
        if self.worm.deactivated:
            self.setVisible(True)
        elif self.worm.attacking:
            
            self.setVisible(True)
        else:
            self.setVisible(False)