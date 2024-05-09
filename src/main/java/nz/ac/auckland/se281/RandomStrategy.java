package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {

  @Override
  public int getNumFingers() {
    return Utils.getRandomNumberRange(0, 5);
  }
}
