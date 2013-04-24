from View.Qt.level_selection_controller import LevelSelectionController
from PySide.QtGui import QDesktopWidget, QMainWindow

class PyMine(QMainWindow):
    
    def __init__(self):
        QMainWindow.__init__(self)

        self.setWindowTitle('PyMine')
        self.level_selection_controller = LevelSelectionController(self)
        self.level_selection_controller.run()
            
        self.show()
        self.resize(640, 480)