package nz.ac.auckland.se281;

public abstract class CPU {
  protected Strategy strategy;

  public CPU(Strategy strategy) {
    this.strategy = strategy;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public abstract int getNumFingers();
}
