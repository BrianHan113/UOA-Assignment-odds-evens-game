package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class MediumCPU extends CPU {

  private TopStrategy topStrategy;

  public MediumCPU(Choice winCondition) {
    super(new RandomStrategy(), winCondition);
  }

  @Override
  public int play() {
    numMoves++;

    // Done this way to avoid creating a new TopStrategy object every time play is called
    if (numMoves == 4) {
      topStrategy = new TopStrategy(numHumanEven, numHumanOdd, winCondition);
      setStrategy(topStrategy);
    }
    if (numMoves > 3) {
      topStrategy.setNumHumanEven(numHumanEven);
      topStrategy.setNumHumanOdd(numHumanOdd);
    }

    return strategy.getAction();
  }
}
