package nz.ac.auckland.se281;

public class EasyCpu extends Cpu {

  public EasyCpu(Human human) {
    super(new RandomStrategy(), human);
  }

  @Override
  public int play() {
    return strategy.getAction();
  }
}
