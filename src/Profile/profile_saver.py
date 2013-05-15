from xml.etree.ElementTree import parse, SubElement

PROFILES_FILENAME = "profiles.xml"
        
def SaveProfile(profile):
    """ Save the given Profile """
    tree = parse(PROFILES_FILENAME)
    root = tree.getroot()
    
    profileElement = FindProfileElementWithName(profile.name, root)
    if profileElement:
        UpdateProfile(profile, profileElement)
        tree.write(PROFILES_FILENAME)
    
def FindProfileElementWithName(name, root):
    """ Return the profile with the given name """
    for profileElement in root.findall('profile'):
        if name == profileElement.attrib['name']:
            return profileElement
    else:
        return None
        
def UpdateProfile(profile, profileElement):
    """ Update the profile XML """
    UpdateRatings(profile.completionRatings, profileElement.find('completionAwards'))
    UpdateRatings(profile.moveRatings, profileElement.find('moveAwards'))
    UpdateRatings(profile.powerRatings, profileElement.find('powerAwards'))
    
def UpdateRatings(ratings, ratingsElement):
    """ Update the Completion Rating """
    alreadySavedIds = GetLevelIDs(ratingsElement)
    for id in ratings:
        if id not in alreadySavedIds:
            levelElement = SubElement(ratingsElement, 'level')
            levelElement.text = str(id)
    
def GetLevelIDs(element):
    """ Return all level IDs saved in the profile """
    ids = []
    for levelIDElement in element.findall('level'):
        ids.append(int(levelIDElement.text))
    return ids