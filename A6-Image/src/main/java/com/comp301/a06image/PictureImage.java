package com.comp301.a06image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PictureImage implements Image {

  private BufferedImage bimage;

  public PictureImage(String pathname) throws IOException {
    if (pathname == null || pathname == "") {
      throw new IOException();
    }
    this.bimage = ImageIO.read(new File(pathname));
  }

  @Override
  public Color getPixelColor(int x, int y) throws IllegalArgumentException {
    if (x < 0 || y < 0 || x > bimage.getWidth() || y > bimage.getHeight()) {
      throw new IllegalArgumentException();
    }
    return new Color(bimage.getRGB(x, y));
  }

  @Override
  public int getWidth() {
    return bimage.getWidth();
  }

  @Override
  public int getHeight() {
    return bimage.getHeight();
  }

  @Override
  public int getNumLayers() {
    return 1;
  }
}
