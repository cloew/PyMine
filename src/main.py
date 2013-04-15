from minefield import Minefield

import sys

def main(args):
    """ Run the main file """
    field = Minefield()
    print field

if __name__ == "__main__":
    main(sys.argv[1:])