package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {

  @Override
  public int getAction() {
    return Utils.getRandomNumberRange(0, 5);
  }
}
