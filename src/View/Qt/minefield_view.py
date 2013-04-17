from drone_view import DroneView
from grid_square_view import GridSquareView

class MinefieldView:
    """ Represents the Graphical view of the Minefield """

    def __init__(self, minefield, drone):
        """ Initialize the grid square view """
        self.minefield = minefield
        self.drone = drone
        
        self.gridSquareViews = []
        for row in self.minefield.squares:
            for square in row:
                self.gridSquareViews.append(GridSquareView(square, self))
        self.droneView = DroneView(drone)

    def draw(self, painter, window):
        """ Draw the image """
        width = GridSquareView.GRID_SQUARE_SIZE*self.minefield.columnCount()
        height = GridSquareView.GRID_SQUARE_SIZE*self.minefield.rowCount()
        
        self.x = 32 #window.contentsRect().width()/2 - width/2
        self.y = 32 #window.contentsRect().height()/2 - height/2
        
        for square in self.gridSquareViews:
            square.draw(painter, self)
        self.droneView.draw(painter, self)