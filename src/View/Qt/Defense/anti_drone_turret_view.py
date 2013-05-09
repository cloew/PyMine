from View.Qt.Level.grid_square_frame import GridSquareFrame

class AntiDroneTurretView(GridSquareFrame):
    """ Represents the Graphical view of an Anti-Drone Turret """
    DEFUSED_IMAGE_FILENAME = "DefusedMine1.png"
    REGULAR_IMAGE_FILENAME = "AntiDroneTurret.png"
    
    def __init__(self, turret, parent=None):
        """ Initialize the turret view """
        GridSquareFrame.__init__(self, parent)
        self.turret = turret
        self.loadTurretImages()
        self.setVisible(False)

    def loadTurretImages(self):
        """ Load the Turret images """
        self.turret_label = self.loadGridSquareSizedImage(self.REGULAR_IMAGE_FILENAME)
        #self.defused_mine_label = self.loadGridSquareSizedImage(self.DEFUSED_IMAGE_FILENAME, visible=False)

    def updateView(self):
        """  """
        if self.turret.deactivated:
            self.setVisible(True)