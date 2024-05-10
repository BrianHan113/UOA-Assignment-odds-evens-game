package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class HardCPU extends CPU {

  private TopStrategy topStrategy;

  public HardCPU(Choice winCondition) {
    super(new RandomStrategy(), winCondition);
    topStrategy = new TopStrategy(winCondition);
  }

  @Override
  public int play() {
    numMoves++;

    // First 3 moves are always random
    if (numMoves < 4) {
      return strategy.getAction();
    }

    // if cpu lost the last round, switch strategy
    if (humanWon) {
      switchStrategy();
    }

    return strategy.getAction();
  }

  private void switchStrategy() {
    if (strategy instanceof RandomStrategy) {
      setStrategy(topStrategy);
      topStrategy.setNumHumanEven(numHumanEven);
      topStrategy.setNumHumanOdd(numHumanOdd);
    } else {
      setStrategy(new RandomStrategy());
    }
  }
}
