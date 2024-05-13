package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/**
 * The top strategy tries to win by assuming the human opponent will be more likely a hand that they
 * have a history throwing.
 *
 * <p>For example, if the human has thrown more even hands than odd hands, and the human needs an
 * even to win, the CPU will throw an odd hand, and vice versa.
 */
public class TopStrategy implements Strategy {

  private Human human;

  /**
   * Constructor for the TopStrategy class. Initializes the top strategy with a human opponent. This
   * is so that the strategy can make predictions based on the human's past moves.
   *
   * @param human
   */
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
