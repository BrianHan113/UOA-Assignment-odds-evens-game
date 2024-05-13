package nz.ac.auckland.se281;

/** This class represents the CPU player in the game. */
public abstract class Cpu {
  protected Strategy strategy;
  private String name = "HAL-9000";
  protected int numMoves;
  protected int numWins;
  protected boolean wonLastGame;

  // CPU has reference to human so it can pass on information to the strategy if necessary
  protected Human human;

  /**
   * Constructor for the CPU class. Initializes the CPU with a given strategy and human opponent.
   *
   * @param strategy the strategy the CPU will use
   * @param human the human player
   */
  public Cpu(Strategy strategy, Human human) {
    this.human = human;
    this.strategy = strategy;
    this.numMoves = 0;
    this.numWins = 0;
  }

  public abstract int play();

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public String getName() {
    return name;
  }

  public void incrementNumWins() {
    this.numWins++;
  }

  public int getNumWins() {
    return numWins;
  }

  public void setWonLastGame(boolean wonLastGame) {
    this.wonLastGame = wonLastGame;
  }
}
