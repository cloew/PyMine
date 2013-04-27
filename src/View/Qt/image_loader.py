from PySide.QtGui import QFrame, QImage, QLabel, QMatrix, QPixmap

def LoadImage(imageFilename, scaledXSize=None, scaledYSize=None):
    """ Loads the Image and scales it if necessary """
    unscaled_image = QImage(imageFilename)
    
    if scaledXSize is not None and scaledYSize is not None:
        return unscaled_image.scaled(scaledXSize, scaledYSize)
    else:
        return unscaled_image