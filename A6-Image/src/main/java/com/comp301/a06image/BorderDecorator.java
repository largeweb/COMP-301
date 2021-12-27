package com.comp301.a06image;

import java.awt.*;

public class BorderDecorator implements Image {

  private Image image;
  private int thiccness;
  private Color borderColor;

  public BorderDecorator(Image image, int thiccness, Color borderColor)
      throws IllegalArgumentException {
    if (thiccness < 0 || image == null || borderColor == null) {
      throw new IllegalArgumentException();
    }
    this.image = image;
    this.thiccness = thiccness;
    this.borderColor = borderColor;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x < 0
        || y < 0
        || x >= (image.getWidth() + (2 * thiccness))
        || y >= (image.getHeight() + (2 * thiccness))) {
      throw new IllegalArgumentException();
    }
    if (x < thiccness
        || x >= image.getWidth() + thiccness
        || y < thiccness
        || y >= image.getHeight() + thiccness) {
      return borderColor;
    }
    return image.getPixelColor(x - thiccness, y - thiccness);
  }

  @Override
  public int getWidth() {
    return image.getWidth() + 2 * thiccness;
  }

  @Override
  public int getHeight() {
    return image.getHeight() + 2 * thiccness;
  }

  @Override
  public int getNumLayers() {
    return image.getNumLayers() + 1;
  }
}
