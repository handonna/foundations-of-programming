package com.comp301.a06image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PictureImage implements Image {
  private final BufferedImage b_image;

  public PictureImage(String pathname) throws IOException {
    if (pathname == null) {
      throw new IOException();
    }
    this.b_image = ImageIO.read(new File(pathname));
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x < 0 || y < 0 || x >= b_image.getWidth() || y >= b_image.getHeight()) {
      throw new IllegalArgumentException();
    }
    return new Color(b_image.getRGB(x, y));
  }

  @Override
  public int getWidth() {
    return b_image.getWidth();
  }

  @Override
  public int getHeight() {
    return b_image.getHeight();
  }

  @Override
  public int getNumLayers() {
    return 1;
  }
}
