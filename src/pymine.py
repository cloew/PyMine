from View.Qt.level_controller import LevelController
from PySide.QtGui import QDesktopWidget, QMainWindow

class PyMine(QMainWindow):
    
    def __init__(self):
        QMainWindow.__init__(self)

        self.setWindowTitle('PyMine')
        self.level_controller = LevelController(self)
        self.level_controller.run()
            
        self.showFullScreen()