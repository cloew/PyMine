from PySide.QtGui import QColor, QFrame, QImage, QLabel, QMatrix, QPainter, QPixmap

def LoadImage(imageFilename, scaledXSize=None, scaledYSize=None):
    """ Loads the Image and scales it if necessary """
    unscaled_image = QImage(imageFilename)
    
    if scaledXSize is not None and scaledYSize is not None:
        return unscaled_image.scaled(scaledXSize, scaledYSize)
    else:
        return unscaled_image
        
def SetImageTransparency(image, transparency):
    """ Set the Image Transparency to the value provided """
    alpha = QImage(image)
    painter = QPainter(alpha)
    painter.fillRect(alpha.rect(), QColor(transparency, transparency, transparency))
    painter.end()
    image.setAlphaChannel(alpha)
        
def GetPixelMapFromImage(image):
    """ Returns a QpixelMap of the QImage given """
    image_pixmap = QPixmap()
    image_pixmap.convertFromImage(image)
    return image_pixmap
    
def GetImageLabelFromPixelMap(pixmap, parent=None):
    """ Return a QLabel made to display the given Pixel Map """
    image_label = QLabel(parent)
    image_label.setPixmap(pixmap)
    return image_label
    
def GetImageLabelFromImage(image, parent=None):
    """ Return a QLabel made to display the given Image """
    pixmap = GetPixelMapFromImage(image)
    return GetImageLabelFromPixelMap(pixmap, parent=parent)
    
def LoadImageLabel(filename, scaledXSize=None, scaledYSize=None, parent=None):
    """ Create an Image Label from an Image file at the filename given """
    image = LoadImage(filename, scaledXSize=scaledXSize, scaledYSize=scaledYSize)
    return GetImageLabelFromImage(image, parent=parent)