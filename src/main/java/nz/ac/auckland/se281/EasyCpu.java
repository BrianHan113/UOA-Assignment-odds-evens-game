package nz.ac.auckland.se281;

/** An easy difficulty level CPU that uses only the random strategy. */
public class EasyCpu extends Cpu {

  public EasyCpu(Human human) {
    super(new RandomStrategy(), human);
  }

  @Override
  public int play() {
    return strategy.getAction();
  }
}
