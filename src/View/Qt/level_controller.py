from nytram.core.game_engine import TheGameEngine
from PySide.QtCore import QCoreApplication, Qt

from level import Level
from level_view import LevelView

class LevelController:
    """ Controller for a Level """
    
    def __init__(self, application):
        """ Initialize the Level Controller """
        self.application = application
        self.level = Level(4)
        self.window = LevelView(application, self.level)

    def run(self):
        """ Run the controller """
        self.application.setCentralWidget(self.window)
        TheGameEngine.start(self.window, self)

    def performGameCycle(self):
        """ Perform a single Game Cycle """
        self.level.performGameCycle()

    def keyPressed(self, key):
        """ Called when the Game Engine gets a keyPressed event """
        if key == Qt.Key_Left:
            self.level.drone.left()
        elif key == Qt.Key_Right:
            self.level.drone.right()
        elif key == Qt.Key_Down:
            self.level.drone.down()
        elif key == Qt.Key_Up:
            self.level.drone.up()
        elif key == Qt.Key_S:
            self.level.drone.scan()

    def keyReleased(self, key):
        """ Called when the Game Engine gets a keyReleased event """