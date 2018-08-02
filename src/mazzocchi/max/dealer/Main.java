package mazzocchi.max.dealer;

import java.io.IOException;

import mazzocchi.max.dealer.deck.Card;

public class Main {

  private static final int DEFAULT_NUMBER_OF_PLAYERS = 8;

  /**
   * Print a message and block until the user presses Enter.
   */
  private static void pause() {
    System.out.println("Press <Enter> to continue.");
    try {
      System.in.read();

    } catch(IOException ioe) {
      System.err.println("An error occured while waiting for user input"+
        ioe.getMessage());
    }
  }

  public static void printCardsOnTable(Game game) {
    for(Card card : game.getCardsOnTable()) {
      System.out.println("  "+card);
    }
  }

  /**
   * Start a new Game with the default number of players, and play rounds
   * infinitely until interuptted.
   */
  public static void main(String[] args) {
    Game game = new Game(DEFAULT_NUMBER_OF_PLAYERS);

    Player user = game.getUser();
    System.out.println("You are "+user+".");
    System.out.println("There are "+DEFAULT_NUMBER_OF_PLAYERS+
      " player(s) total.");
    System.out.println("");

    while(true) {
      Stage stage = game.advance();
      System.out.println(stage+":");

      switch(stage) {
        case NEW_ROUND:
          Player dealer = game.getDealer();
          if(user == dealer) {
            System.out.println("  You are the dealer.");
          } else {
            System.out.println("  "+dealer+" is the dealer.");
          }

          System.out.println("");
          pause();
          break;

        case DEAL:
          System.out.println("  Your hand:");
          for(Card card : user.getHand()) {
            System.out.println("    "+card);
          }
          pause();
          break;

        case FLOP:
          printCardsOnTable(game);
          pause();
          break;

        case TURN:
          printCardsOnTable(game);
          pause();
          break;

        case RIVER:
          printCardsOnTable(game);
          pause();
          break;
      }
    }
  }
}
