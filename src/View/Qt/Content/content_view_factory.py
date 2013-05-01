from Content.mine import Mine
from Content.fragile_mine import FragileMine
from Content.reverse_mine import ReverseMine
from Content.worm import Worm

from View.Qt.Content.mine_view import MineView
from View.Qt.Content.fragile_mine_view import FragileMineView
from View.Qt.Content.reverse_mine_view import ReverseMineView
from View.Qt.Content.worm_view import WormView

ContentToViewDictionary = {Mine:MineView,
                           FragileMine:FragileMineView,
                           ReverseMine:ReverseMineView,
                           Worm:WormView}
                        
def GetViewForContent(content, parentView):
    """  """
    if content.__class__ in ContentToViewDictionary:
        return ContentToViewDictionary[content.__class__](content, parentView)
    else:
        return MineView(content, parentView)