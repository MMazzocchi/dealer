package mazzocchi.max.dealer;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 * Game represents the top-level class for the Dealer package. As a class, it
 * represents a set of players playing multiple rounds of poker.
 */
public class Game {

  private static final int USER_INDEX = 0;

  private List<Player> players;
  private int number_of_players;
  private int dealer_index;

  public Game(int number_of_players) {
    this.number_of_players = number_of_players;
    this.dealer_index = 0;

    this.players = new ArrayList<Player>(number_of_players);
    for(int i=0; i<number_of_players; i++) {
      Player player = new Player("Player #"+i);
      this.players.add(player);
    }
  }

  /**
   * Start a round of poker. This method will proceed through the dealing, flop,
   * turn, and river phases, pausing between each.
   */
  public void playRound() {
    Player user = players.get(USER_INDEX);
    System.out.println("==================== NEW ROUND ====================");
    System.out.println("");
    System.out.println("You are "+user+".");
    System.out.println("There are "+number_of_players+" player(s) total.");
    System.out.println("");

    if(dealer_index == USER_INDEX) {
      System.out.println("You are the dealer.");

    } else {
      Player dealer = players.get(dealer_index);
      System.out.println(dealer+" is the dealer.");
    }
    System.out.println("");

    Round round = new Round(players, dealer_index);

    // Initial deal
    round.deal();
    System.out.println("Your hand:");
    user.printHand();

    pause();

    // Flop
    round.flop();
    System.out.println("Flop:");
    round.printCardsOnTable();

    pause();

    // Turn
    round.turn();
    System.out.println("Turn: ");
    round.printCardsOnTable();

    pause();

    // River
    round.river();
    System.out.println("River: ");
    round.printCardsOnTable();

    pause();

    // Rotate the dealer 
    dealer_index = (dealer_index + 1) % number_of_players;
  }

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
}
