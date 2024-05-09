package nz.ac.auckland.se281;

public class EasyCPU extends CPU {

  public EasyCPU() {
    super(new RandomStrategy());
  }

  @Override
  public int play() {
    return strategy.getAction();
  }
}
