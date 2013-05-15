from Profile.profile import Profile
import Profile as P

from xml.etree import ElementTree

PROFILES_FILENAME = "profiles.xml"
        
def LoadProfiles():
    """ Load Profiles and returns them """
    tree = ElementTree.parse(PROFILES_FILENAME)
    root = tree.getroot()
    profiles = []
    
    for profileElement in root.findall('profile'):
        profiles.append(LoadProfile(profileElement))
    return profiles
        
def LoadProfile(profileElement):
    """ Load a Profile from an XML Profile Element """
    name = profileElement.attrib['name']
    completionIDs = LoadIDs(profileElement.find('completionAwards'))
    moveIDs = LoadIDs(profileElement.find('moveAwards'))
    powerIDs = LoadIDs(profileElement.find('powerAwards'))
    
    profile = Profile(name)
    profile.completionRatings = completionIDs
    profile.moveRatings = moveIDs
    profile.powerRatings = powerIDs
    return profile
    
def LoadIDs(element):
    """ Load Level IDs from an XML Element """
    ids = []
    for levelIDElement in element.findall('level'):
        ids.append(int(levelIDElement.text))
    return ids