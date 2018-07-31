public class Player {
  private static int next_id = 0;

  private String name;
  private boolean is_dealer = false;

  public Player() {
    name = "Player #"+next_id;
    next_id++;
  }

  public void setDealer(boolean is_dealer) {
    this.is_dealer = is_dealer;
  }

  @Override
  public String toString() {
    if(is_dealer) {
      return name+" (dealer)";

    } else {
      return name;
    }
  }
}
