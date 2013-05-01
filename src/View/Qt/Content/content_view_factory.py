from Content.mine import Mine
from Content.fragile_mine import FragileMine
from Content.reverse_mine import ReverseMine

from View.Qt.Content.mine_view import MineView
from View.Qt.Content.fragile_mine_view import FragileMineView
from View.Qt.Content.reverse_mine_view import ReverseMineView

MineToViewDictionary = {Mine:MineView,
                        FragileMine:FragileMineView,
                        ReverseMine:ReverseMineView}
                        
def GetViewForContent(content, parentView):
    """  """
    if content.__class__ in MineToViewDictionary:
        return MineToViewDictionary[content.__class__](content, parentView)
    else:
        return MineView(content, parentView)