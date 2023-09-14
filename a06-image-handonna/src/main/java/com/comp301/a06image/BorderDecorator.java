package com.comp301.a06image;

import java.awt.*;

public class BorderDecorator implements Image {
  private final Image image;
  private final int thiccness;
  private final Color borderColor;

  public BorderDecorator(Image image, int thiccness, Color borderColor) {
    if (borderColor == null || image == null || thiccness < 0) {
      throw new IllegalArgumentException();
    }
    this.image = image;
    this.thiccness = thiccness;
    this.borderColor = borderColor;
  }

  @Override
  public Color getPixelColor(int x, int y) throws IllegalArgumentException {
    if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
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
