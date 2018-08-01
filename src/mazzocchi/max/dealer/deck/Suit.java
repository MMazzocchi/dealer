package mazzocchi.max.dealer.deck;

public enum Suit {
  SPADES("Spades"),
  HEARTS("Hearts"),
  DIAMONDS("Diamonds"),
  CLUBS("Clubs");

  private String name;

  private Suit(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}
