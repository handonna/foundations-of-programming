package com.comp301.a02adventure;

public class MapImpl implements Map {
  private final int width;
  private final int height;
  private final int numItems;
  private final Cell[][] cellgrid;

  public MapImpl(int width, int height, int numItems) {
    if (width <= 0) {
      throw new IllegalArgumentException("negative width");
    }
    if (height <= 0) {
      throw new IllegalArgumentException("negative height");
    }
    this.width = width;
    this.height = height;
    this.numItems = numItems;
    this.cellgrid = new Cell[width][height];
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public Cell getCell(int x, int y) {
    if ((x >= width) || (x < 0)) {
      throw new IndexOutOfBoundsException("x out of bounds");
    }
    if ((y >= height) || (y < 0)) {
      throw new IndexOutOfBoundsException("y out of bounds");
    }
    return cellgrid[x][y];
  }

  @Override
  public Cell getCell(Position position) {
    if ((position.getX() >= width) || (position.getX() < 0)) {
      throw new IndexOutOfBoundsException("x out of bounds");
    }
    if ((position.getY() >= height) || (position.getY() < 0)) {
      throw new IndexOutOfBoundsException("y out of bounds");
    }
    return getCell(position.getX(), position.getY());
  }

  @Override
  public void initCell(int x, int y) {
    if ((x >= width) || (x < 0)) {
      throw new IndexOutOfBoundsException("x out of bounds");
    }
    if ((y >= height) || (y < 0)) {
      throw new IndexOutOfBoundsException("y out of bounds");
    }
    cellgrid[x][y] = new CellImpl(x, y);
  }

  @Override
  public int getNumItems() {
    return numItems;
  }
}
