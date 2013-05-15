from profile import Profile
from profile_loader import LoadProfiles
from profile_saver import SaveProfile

__profiles__ = []
CURRENT_PROFILE = None

def GetCurrentProfile():
    """ Set the Current Profile """
    try:
        __profiles__ = LoadProfiles()
    except IOError:
        profile = Profile("Some Profile")
        SaveProfile(profile)
        __profiles__ = [profile]
    return __profiles__[0]

CURRENT_PROFILE = GetCurrentProfile()