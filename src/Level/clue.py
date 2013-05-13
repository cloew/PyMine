from Level.Clue.adjacency_clue import AdjacencyClue
from Level.Clue.fragility_clue import FragilityClue
from Level.Clue.weapon_caution_clue import WeaponCautionClue

class Clue:
    """ Represents a Clue for the Mine Game """
    
    def __init__(self):
        """ Initialize the Clue """
        self.reverse = False
        self.distance = None
        self.nearWeapons = False
        self.adjacencyClue = AdjacencyClue()
        self.fragilityClue = FragilityClue()
        self.weaponCautionClue = WeaponCautionClue()
        self.subClues = [self.adjacencyClue, self.fragilityClue, self.weaponCautionClue]
        
    def populate(self, minefield, gridRow, gridColumn):
        """ Populate the Clue """
        for subclue in self.subClues:
            subclue.update(minefield, gridRow, gridColumn)
        self.findAdjacentMines(minefield, gridRow, gridColumn)
        self.nearWeapons = self.weaponCautionClue.nearWeapons
        self.distance = self.fragilityClue.distance
        
    def findAdjacentMines(self, minefield, gridRow, gridColumn):
        """ Find an Adjacent Mine """
        self.reverse = False
        currentSquare = minefield.getSquare(gridRow, gridColumn)
        
        for square in minefield.getAdjacentSquares(currentSquare, includeCenter=True):
            if square.reversed():
                self.reverse = True
                for subclue in self.subClues:
                    subclue.reverseReading()
            if square.row == gridRow and square.column == gridColumn:
                continue # Ignore the current grid Location, because we only want to examine adjacent cells
            for subclue in self.subClues:
                subclue.updateFromAdjacentSquare(square)
        
    def __repr__(self):
        """ Return the string representation of the Clue """
        reportedAdjacentMines = self.adjacencyClue.getAdjacentMinesClue()
        if reportedAdjacentMines == 0:
            return ' '
        else:
            return str(reportedAdjacentMines)