from Defense.mine import Mine
from Defense.fragile_mine import FragileMine
from Defense.reverse_mine import ReverseMine
from Defense.worm import Worm

from View.Qt.Defense.mine_view import MineView
from View.Qt.Defense.fragile_mine_view import FragileMineView
from View.Qt.Defense.reverse_mine_view import ReverseMineView
from View.Qt.Defense.worm_view import WormView

DefenseToViewDictionary = {Mine:MineView,
                           FragileMine:FragileMineView,
                           ReverseMine:ReverseMineView,
                           Worm:WormView}
                        
def GetViewForDefense(defense, parentView):
    """  """
    if defense.__class__ in DefenseToViewDictionary:
        return DefenseToViewDictionary[defense.__class__](defense, parentView)
    else:
        return MineView(defense, parentView)