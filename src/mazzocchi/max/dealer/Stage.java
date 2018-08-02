package mazzocchi.max.dealer;

enum Stage {
  NEW_ROUND("New Round"),
  DEAL("Deal"),
  FLOP("Flop"),
  TURN("Turn"),
  RIVER("River");

  private String name;

  private Stage(String name) {
   this.name = name;
  }

  public Stage next() {
    switch(this) {
      case NEW_ROUND:
        return DEAL;
      case DEAL:
        return FLOP;
      case FLOP:
        return TURN;
      case TURN:
        return RIVER;
      case RIVER:
        return NEW_ROUND;
    }

    return NEW_ROUND;
  }

  @Override
  public String toString() {
    return name;
  }
};
