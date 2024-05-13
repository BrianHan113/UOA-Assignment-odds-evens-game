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
   * @param human the human player
   */
  public TopStrategy(Human human) {
    this.human = human;
  }

  @Override
  public int getAction() {
    // If the human has thrown more even hands than odd hands, and the human needs an even to win,
    // the CPU will throw an odd hand
    if (human.getNumEvenHands() > human.getNumOddHands()) {
      return human.getChoice() == Choice.EVEN
          ? Utils.getRandomOddNumber()
          : Utils.getRandomEvenNumber();
      // If the human has thrown more odd hands than even hands, and the human needs an even to win,
      // the CPU will throw an even hand
    } else if (human.getNumEvenHands() < human.getNumOddHands()) {
      return human.getChoice() == Choice.EVEN
          ? Utils.getRandomEvenNumber()
          : Utils.getRandomOddNumber();
      // If the human has thrown equal number of even and odd hands, CPU will throw a random hand
    } else {
      return Utils.getRandomNumberRange(0, 5);
    }
  }
}
