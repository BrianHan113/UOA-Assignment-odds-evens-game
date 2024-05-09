package nz.ac.auckland.se281;

public class CPU {
  protected Strategy strategy;
  private String name = "HAL-9000";

  public CPU(Strategy strategy) {
    this.strategy = strategy;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public int getNumFingers() {
    return strategy.getNumFingers();
  }

  public String getName() {
    return name;
  }
}
