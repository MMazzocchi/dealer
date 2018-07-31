public class Player {
  private static int next_id = 0;

  private String name;

  public Player() {
    name = "Player #"+next_id;
    next_id++;
  }

  @Override
  public String toString() {
    return name;
  }
}
