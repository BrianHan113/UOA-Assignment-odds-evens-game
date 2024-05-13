package nz.ac.auckland.se281;

/**
 * A hard difficulty level CPU that uses a random strategy for the first 3 moves and switches
 * strategies if the CPU lost the round before.
 *
 * <p>E.g. if using random strategy and lost the last round, switch to top strategy. If using top
 * strategy and lost the last round, switch to random strategy.
 */
public class HardCpu extends Cpu {

  private TopStrategy topStrategy;

  /**
   * Constructor for HardCpu makes a CPU with a random strategy initially, and the human player.
   *
   * @param human the human player
   */
  public HardCpu(Human human) {
    super(new RandomStrategy(), human);
    topStrategy = new TopStrategy(human);
  }

  @Override
  public int play() {
    numMoves++;

    // First 3 moves are always random
    if (numMoves < 4) {
      return strategy.getAction();
    }

    // For round 4 onwards, if cpu lost the last round, switch strategy
    if (!this.wonLastGame) {
      switchStrategy();
    }

    return strategy.getAction();
  }

  private void switchStrategy() {
    if (strategy instanceof RandomStrategy) {
      setStrategy(topStrategy);
    } else {
      setStrategy(new RandomStrategy());
    }
  }
}
