from Defense.anti_drone_mine import AntiDroneMine
from Defense.mine import Mine
from Defense.fragile_mine import FragileMine
from Defense.reverse_mine import ReverseMine
from Defense.worm import Worm

from Level.level import Level
from Level.level_init import LevelInit

from xml.etree import ElementTree

DEFENSES = {"AntiDroneMine":AntiDroneMine,
            "FragileMine":FragileMine,
            "Mine":Mine,
            "ReverseMine":ReverseMine,
            "Worm":Worm}
            
STANDARD_LEVELS_FILENAME = "levels.xml"
        
def LoadLevels():
    """ Load Levels and returns them """
    tree = ElementTree.parse(STANDARD_LEVELS_FILENAME)
    root = tree.getroot()
    levels = []
    
    for levelElement in root.findall('level'):
        levels.append(LoadLevel(levelElement))
    return levels
        
def LoadLevel(levelElement):
    """ Load a Level from an XML Level Element """
    name = levelElement.attrib['name']
    rows, columns = LoadGridSettings(levelElement.find('grid'))
    defenses = LoadDefenses(levelElement.find('defenses'))
    init = LevelInit(name, rows, columns, defenses)
    return Level(init)
    
def LoadGridSettings(gridElement):
    """ Load the Grid Settings from the XML Grid Element """
    rows = int(gridElement.find('rows').text)
    columns = int(gridElement.find('columns').text)
    return rows, columns
    
def LoadDefenses(defensesElement):
    """ Load Defenses from the XML Defenses Element """
    defenses = {}
    for defenseElement in defensesElement.findall('defense'):
        LoadDefense(defenseElement, defenses)
    return defenses
    
def LoadDefense(defenseElement, defenses):
    """ Load a Defense from an XML Defense Element """
    type = defenseElement.attrib['type']
    count = int(defenseElement.attrib['count'])
    
    if type in DEFENSES:
        defenseClass = DEFENSES[type]
        if defenseClass in defenses:
            defenses[defenseClass] += count
        else:
            defenses[defenseClass] = count