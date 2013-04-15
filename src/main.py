from View.Console.level_controller import LevelController

import sys

def main(args):
    """ Run the main file """
    levelController = LevelController()
    levelController.run()

if __name__ == "__main__":
    main(sys.argv[1:])