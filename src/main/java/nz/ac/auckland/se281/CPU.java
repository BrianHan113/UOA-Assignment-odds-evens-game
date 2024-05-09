package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public abstract class CPU {
  protected Strategy strategy;
  private String name = "HAL-9000";
  protected int numMoves;

  // CPU has access to past human moves
  protected int numHumanEven;
  protected int numHumanOdd;
  protected Choice winCondition;

  public CPU(Strategy strategy, Choice winCondition) {
    this.strategy = strategy;
    this.numMoves = 0;
    this.numHumanEven = 0;
    this.numHumanOdd = 0;
    this.winCondition = winCondition;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public abstract int play();

  public String getName() {
    return name;
  }

  public void incrementNumHumanEven() {
    numHumanEven++;
  }

  public void incrementNumHumanOdd() {
    numHumanOdd++;
  }
}
