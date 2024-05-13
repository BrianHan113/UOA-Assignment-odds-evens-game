package nz.ac.auckland.se281;

/** The random strategy which returns a random number between 0 and 5. */
public class RandomStrategy implements Strategy {

  @Override
  public int getAction() {
    return Utils.getRandomNumberRange(0, 5);
  }
}
