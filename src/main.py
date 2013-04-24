#from View.Console.level_controller import LevelController

from pymine import PyMine
from PySide.QtGui import QApplication

import sys

def main(args):
    """ Run the main file """
    app = QApplication(sys.argv)
    pymine = PyMine()
    sys.exit(app.exec_())

if __name__ == "__main__":
    main(sys.argv[1:])