package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class TopStrategy implements Strategy {

  private Human human;

  public TopStrategy(Human human) {
    this.human = human;
  }

  @Override
  public int getAction() {
    if (human.getNumEvenHands() > human.getNumOddHands()) {
      return human.getChoice() == Choice.EVEN
          ? Utils.getRandomOddNumber()
          : Utils.getRandomEvenNumber();
    } else if (human.getNumEvenHands() < human.getNumOddHands()) {
      return human.getChoice() == Choice.EVEN
          ? Utils.getRandomEvenNumber()
          : Utils.getRandomOddNumber();
    } else {
      return Utils.getRandomNumberRange(0, 5);
    }
  }
}
