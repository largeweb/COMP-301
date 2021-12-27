package com.comp301.a06image;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SquareDecorator implements Image {

  private Image image;
  private int squareX;
  private int squareY;
  private int squareSize;
  private Color color;

  public SquareDecorator(Image image, int squareX, int squareY, int squareSize, Color color)
      throws IllegalArgumentException {
    if (image == null || squareSize < 0) {
      throw new IllegalArgumentException();
    }
    this.image = image;
    this.squareX = squareX;
    this.squareY = squareY;
    this.squareSize = squareSize;
    this.color = color;
  }

  @Override
  public Color getPixelColor(int x, int y) throws IllegalArgumentException {
    if (x < 0 && y < 0 && x >= image.getWidth() && y >= image.getHeight()) {
      throw new IllegalArgumentException();
    }
    if (x < squareX + squareSize && x >= squareX && y < squareY + squareSize && y >= squareY) {
      return color;
    }
    return image.getPixelColor(x, y);
  }

  @Override
  public int getWidth() {
    return image.getWidth();
  }

  @Override
  public int getHeight() {
    return image.getHeight();
  }

  @Override
  public int getNumLayers() {
    return image.getNumLayers() + 1;
  }
}
