from level_selection_view import LevelSelectionView

from LevelSelection.level_selection import LevelSelection
from View.Qt.Level.level_controller import LevelController

from nytram.core.game_engine import TheGameEngine
from PySide.QtCore import QCoreApplication, Qt

class LevelSelectionController:
    """ Controller for a Level """
    
    def __init__(self, application):
        """ Initialize the Level Controller """
        self.application = application
        self.level_selection = LevelSelection()
        self.window = LevelSelectionView(application, self.level_selection)

    def run(self):
        """ Run the controller """
        self.application.addWidget(self.window)
        self.application.setCurrentWidget(self.window)
        TheGameEngine.start(self.window, self)

    def performGameCycle(self):
        """ Perform a single Game Cycle """
        self.level_selection.performGameCycle()

    def keyPressed(self, key):
        """ Called when the Game Engine gets a keyPressed event """
        if key == Qt.Key_Up:
            for i in range(LevelSelectionView.ENTRIES_PER_ROW):
                self.level_selection.previousLevel()
        elif key == Qt.Key_Down:
            for i in range(LevelSelectionView.ENTRIES_PER_ROW):
                self.level_selection.nextLevel()
        elif key == Qt.Key_Left:
            self.level_selection.previousLevel()
        elif key == Qt.Key_Right:
            self.level_selection.nextLevel()
        elif key == Qt.Key_S:
            level_controller = LevelController(self.application, self.level_selection.getLevel())
            level_controller.run()

    def keyReleased(self, key):
        """ Called when the Game Engine gets a keyReleased event """