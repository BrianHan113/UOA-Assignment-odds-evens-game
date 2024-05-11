package nz.ac.auckland.se281;

public class EasyCPU extends CPU {

  public EasyCPU(Human human) {
    super(new RandomStrategy(), human);
  }

  @Override
  public int play() {
    return strategy.getAction();
  }
}
