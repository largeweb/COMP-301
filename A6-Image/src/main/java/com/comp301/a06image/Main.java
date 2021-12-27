package com.comp301.a06image;

import java.awt.Color;
import java.io.IOException;

import javafx.application.Application;
// import org.w3c.dom.css.RGBColor;

public class Main {
  /**
   * Creates and returns an image object for testing. The image that this method produces will be
   * automatically displayed on the screen when main() is run below. Use this method to test
   * different decorators.
   */
  public static Image makeImage() throws IOException {
    // TODO use this method for testing your decorators
    Image image = new PictureImage("img/kmp.jpg");
    image = new BorderDecorator(image, 5, new Color(255, 0, 0));
    image = new BorderDecorator(image, 50, new Color(0, 0, 255));
    image = new CircleDecorator(image, 50, 50, 40, new Color(255, 255, 0));
    image = new SquareDecorator(image, 100, 100, 40, new Color(200, 80, 10));
    image = new ZoomDecorator(image, 2);
    return image;
  }

  /**
   * Use this method for testing your code. When main() runs, the image you created and decorated in
   * the makeImage() method above will be generated and displayed on the screen. You don't need to
   * make any changes to this main() method.
   */
  public static void main(String[] args) {
    Application.launch(ImageDisplay.class, args);
  }
}
