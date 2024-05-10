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
    if (numHumanEven > numHumanOdd) {
      return winCondition == Choice.EVEN ? Utils.getRandomEvenNumber() : Utils.getRandomOddNumber();
    } else if (numHumanEven < numHumanOdd) {
      return winCondition == Choice.EVEN ? Utils.getRandomOddNumber() : Utils.getRandomEvenNumber();
    } else {
      return Utils.getRandomNumberRange(0, 5);
    }
  }
}
