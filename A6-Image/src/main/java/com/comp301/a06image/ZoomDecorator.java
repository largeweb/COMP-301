package com.comp301.a06image;

import java.awt.*;

public class ZoomDecorator implements Image {

  private Image image;
  private int multiplier;

  public ZoomDecorator(Image image, int multiplier) throws IllegalArgumentException {
    if (multiplier <= 0 || image == null) {
      throw new IllegalArgumentException();
    }
    this.image = image;
    this.multiplier = multiplier;
  }

  public ZoomDecorator(Image image) {
    this(image, 2);
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (multiplier == 0) {
      throw new IllegalArgumentException();
    }
    if (x < 0
        || y < 0
        || x >= image.getWidth() * multiplier
        || y >= image.getHeight() * multiplier) {
      throw new IllegalArgumentException();
    }
    int nx = (int) Math.ceil(x / multiplier);
    int ny = (int) Math.ceil(y / multiplier);
    return image.getPixelColor(nx, ny);
    //    return image.getPixelColor((int) Math.ceil((x / multiplier)), (int) Math.ceil(y /
    // multiplier));
  }

  @Override
  public int getWidth() {
    return image.getWidth() * multiplier;
  }

  @Override
  public int getHeight() {
    return image.getHeight() * multiplier;
  }

  @Override
  public int getNumLayers() {
    return image.getNumLayers() + 1;
  }
}
