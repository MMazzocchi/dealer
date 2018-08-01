package mazzocchi.max.dealer;

public class Main {

  private static final int DEFAULT_NUMBER_OF_PLAYERS = 8;

  /**
   * Start a new Game with the default number of players, and play rounds
   * infinitely until interuptted.
   */
  public static void main(String[] args) {
    Game game = new Game(DEFAULT_NUMBER_OF_PLAYERS);

    while(true) {
      game.playRound();
    }
  }
}
