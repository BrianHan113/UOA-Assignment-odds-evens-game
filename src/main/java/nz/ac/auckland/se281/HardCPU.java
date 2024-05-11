package nz.ac.auckland.se281;

public class HardCPU extends CPU {

  private TopStrategy topStrategy;

  public HardCPU(Human human) {
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
