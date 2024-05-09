package nz.ac.auckland.se281;

public class MediumCPU extends CPU {

  private int numMoves;

  public MediumCPU() {
    super(new RandomStrategy());
    this.numMoves = 0;
  }

  @Override
  public int play() {
    numMoves++;
    if (numMoves == 4) {
      setStrategy(new TopStrategy());
    }
    return strategy.getAction();
  }
}
