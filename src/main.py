from drone import Drone
from minefield import Minefield

from View.Console.minefield_view import MinefieldView

import sys

def main(args):
    """ Run the main file """
    field = Minefield()
    drone = Drone()
    
    field_view = MinefieldView(field, drone)
    print field_view

if __name__ == "__main__":
    main(sys.argv[1:])