package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public abstract class CPU {
  protected Strategy strategy;
  private String name = "HAL-9000";
  protected int numMoves;
  protected Choice winCondition;
  // CPU has access to player statistics
  protected int numHumanEven;
  protected int numHumanOdd;
  protected int numHumanWins;
  protected boolean humanWon;

  public CPU(Strategy strategy, Choice winCondition) {
    this.strategy = strategy;
    this.numMoves = 0;
    this.numHumanEven = 0;
    this.numHumanOdd = 0;
    this.winCondition = winCondition;
    this.numHumanWins = 0;
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

  public void incrementNumHumanWins() {
    this.numHumanWins++;
  }

  public void setHumanWon(boolean humanWon) {
    this.humanWon = humanWon;

    if (humanWon) {
      incrementNumHumanWins();
    }
  }
}
