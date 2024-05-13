package nz.ac.auckland.se281;

/**
 * A medium difficulty level CPU that uses a random strategy for the first 3 moves and then switches
 * to the top strategy for the rest of the game.
 */
public class MediumCpu extends Cpu {

  private TopStrategy topStrategy;

  /**
   * Constructor for MediumCpu makes a CPU with a random strategy initially, and the human player.
   *
   * @param human the human player
   */
  public MediumCpu(Human human) {
    super(new RandomStrategy(), human);
  }

  @Override
  public int play() {
    numMoves++;

    // Done this way to avoid creating a new TopStrategy object every time play is called
    if (numMoves == 4) {
      topStrategy = new TopStrategy(human);
      setStrategy(topStrategy);
    }

    return strategy.getAction();
  }
}
