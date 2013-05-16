from nytram.core.game_engine import TheGameEngine
from PySide.QtCore import QCoreApplication, QTimer, Qt

from level_view import LevelView

class LevelController:
    """ Controller for a Level """
    
    def __init__(self, application, level):
        """ Initialize the Level Controller """
        self.application = application
        self.level = level
        self.level.reset()
        self.window = LevelView(application, self.level)

    def run(self):
        """ Run the controller """
        self.previousController = TheGameEngine.controller
        self.application.addWidget(self.window)
        self.application.setCurrentWidget(self.window)
        TheGameEngine.start(self.window, self)
        self.window.grabKeyboard()

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
        elif not (self.level.lost() or self.level.won()):
            if key == Qt.Key_S:
                self.level.drone.scan()
            elif key == Qt.Key_D:
                self.level.drone.defuse()
            elif key == Qt.Key_F:
                self.level.drone.defuseCarefully()
            elif key == Qt.Key_E:
                self.level.drone.performEMP()
        else:
            if key == Qt.Key_S:
                self.previousController.run()

    def keyReleased(self, key):
        """ Called when the Game Engine gets a keyReleased event """