package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class TopStrategy implements Strategy {

  private int numHumanEven;
  private int numHumanOdd;
  private Choice winCondition;

  public TopStrategy(int numHumanEven, int numHumanOdd, Choice winCondition) {
    this.numHumanEven = numHumanEven;
    this.numHumanOdd = numHumanOdd;
    this.winCondition = winCondition;
  }

  public void setNumHumanEven(int numHumanEven) {
    this.numHumanEven = numHumanEven;
  }

  public void setNumHumanOdd(int numHumanOdd) {
    this.numHumanOdd = numHumanOdd;
  }

  @Override
  public int getAction() {
    return -1;
  }
}
