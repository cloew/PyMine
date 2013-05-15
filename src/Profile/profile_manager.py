from profile_loader import LoadProfiles
import sys

__profiles__ = []
CURRENT_PROFILE = None

def GetCurrentProfile():
    """ Set the Current Profile """
    try:
        __profiles__ = LoadProfiles()
    except IOError:
        pass
    return __profiles__[0]

CURRENT_PROFILE = GetCurrentProfile()