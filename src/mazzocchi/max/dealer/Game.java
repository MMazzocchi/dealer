package mazzocchi.max.dealer;

import java.util.List;
import java.util.ArrayList;

import mazzocchi.max.dealer.deck.Card;

/**
 * Game represents the top-level class for the Dealer package. As a class, it
 * represents a set of players playing multiple rounds of poker.
 */
public class Game {

  private static final int USER_INDEX = 0;

  private List<Player> players;
  private int number_of_players;
  private int dealer_index;
  private Stage stage;
  private Round round;

  public Game(int number_of_players) {
    this.number_of_players = number_of_players;
    this.dealer_index = 0;

    this.players = new ArrayList<Player>(number_of_players);
    for(int i=0; i<number_of_players; i++) {
      Player player = new Player("Player #"+i);
      this.players.add(player);
    }

    this.stage = Stage.NEW_ROUND;
  }

  /**
   * Advance to the next stage. Returns the stage that was just performed.
   */
  public Stage advance() {
    Stage prev_stage = stage;

    switch(stage) {
      case NEW_ROUND:
        round = new Round(players, dealer_index);
        break;

      case DEAL:
        round.deal();
        break;

      case FLOP:
        round.flop();
        break;

      case TURN:
        round.turn();
        break;

      case RIVER:
        round.river();
        dealer_index = (dealer_index + 1) % number_of_players;
        break;
    }

    stage = stage.next();
    return prev_stage;
  };

  public final List<Card> getCardsOnTable() {
    return round.getCardsOnTable();
  }

  public final Player getUser() {
    return players.get(USER_INDEX);
  }

  public final Player getDealer() {
    return players.get(dealer_index);
  }
}
