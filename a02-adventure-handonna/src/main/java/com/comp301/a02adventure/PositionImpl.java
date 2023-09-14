package com.comp301.a02adventure;

public class PositionImpl implements Position {
  private final int x;
  private final int y;

  public PositionImpl(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int getX() {
    return x;
  }

  @Override
  public int getY() {
    return y;
  }

  @Override
  public Position getNeighbor(Direction direction) {
    int next_x = x;
    int next_y = y;

    if (direction == Direction.WEST) {
      next_x -= 1;
    }
    if (direction == Direction.NORTH) {
      next_y += 1;
    }
    if (direction == Direction.EAST) {
      next_x += 1;
    }
    if (direction == Direction.SOUTH) {
      next_y -= 1;
    }
    Position new_position = new PositionImpl(next_x, next_y);
    return new_position;
  }
}
